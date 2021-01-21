package com.java.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Produk;
import com.java.repository.ProdukRepository;

@Service
@Transactional
public class ProdukService {

	@Autowired ProdukRepository produkRepo;
	
	public List<Produk> getAllProduk(){
		return produkRepo.findAll();
	}
	
	
	public Produk getProdukById(int id) {
		return produkRepo.findById(id).get();
	}
	
	public void saveProduk(Produk produk) {
		produkRepo.save(produk);
	}
	
	public void deleteProduk(int id) {
		produkRepo.deleteById(id);
	}
}
