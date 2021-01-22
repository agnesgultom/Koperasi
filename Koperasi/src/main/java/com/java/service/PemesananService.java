package com.java.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.IPemesanan;
import com.java.model.Pemesanan;
import com.java.repository.PemesananRepository;

@Service
@Transactional
public class PemesananService {
	@Autowired PemesananRepository pemesananRepo;
	
	public List<Pemesanan> getAllPemesanan(){
		return pemesananRepo.findAll();
	}
	
	public void savePemesanan(Pemesanan pemesanan) {
		pemesananRepo.save(pemesanan);
	}
	
	public void updateStatusPemesanan(int id) {
	    pemesananRepo.updateStatusPemesanan(id);
	}
	
	public void updateStatusProduk(int id, int status) {
	    pemesananRepo.updateStatusProduk(id, status);
	}
	
	public List<Pemesanan> getFPemesanan(){
		return pemesananRepo.pemesananFinish();
	}
	
	public List<IPemesanan> getMonthTotalSale(){
		return pemesananRepo.sumTotalSaleByMonth();
	}
}
