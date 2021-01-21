package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "produk_koperasi")
public class Produk {
	@Id
	private int id_produk;
	private String nama_produk;
	private String jenis_produk;
	private int stock;
	private int harga;
	private String deskripsi;
	public int getId_produk() {
		return id_produk;
	}
	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}
	public String getNama_produk() {
		return nama_produk;
	}
	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}
	public String getJenis_produk() {
		return jenis_produk;
	}
	public void setJenis_produk(String jenis_produk) {
		this.jenis_produk = jenis_produk;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	
	
}
