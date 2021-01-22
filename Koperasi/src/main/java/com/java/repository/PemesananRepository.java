package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.model.IPemesanan;
import com.java.model.Pemesanan;

@Repository
public interface PemesananRepository extends JpaRepository<Pemesanan, Integer>{
	@Modifying
	@Query(value = "UPDATE pemesanan_produk p SET p.status_bayar = 1 WHERE p.id_pemesanan = :id", nativeQuery = true)
	void updateStatusPemesanan(@Param(value = "id") int id);
	
	@Modifying
	@Query(value = "UPDATE pemesanan_produk p SET p.status_produk = :status WHERE p.id_pemesanan = :id", nativeQuery = true)
	void updateStatusProduk(@Param(value = "id") int id, @Param(value = "status") int status);
	
	@Modifying
	@Query(value = "SELECT * FROM pemesanan_produk p WHERE p.status_bayar = 1", nativeQuery = true)
	List<Pemesanan> pemesananFinish();
	
	@Modifying
	@Query(value = "SELECT MONTH(tanggal_pemesanan) AS monthSale, SUM(jumlah_harga) AS totalSale FROM pemesanan_produk p WHERE status_bayar = 1 GROUP BY YEAR(tanggal_pemesanan), MONTH(tanggal_pemesanan)", nativeQuery = true)
	List<IPemesanan> sumTotalSaleByMonth();
	
}
