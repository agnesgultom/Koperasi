package com.java.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.IPemesanan;
import com.java.model.Pemesanan;
import com.java.model.Produk;
import com.java.service.PemesananService;



@RestController
@RequestMapping("pemesanan")
public class PemesananController {
	
	@Autowired PemesananService pemesananService;
	
	@GetMapping("/get")
	public List<Pemesanan> getAllProduk(){
		return pemesananService.getAllPemesanan();
	}
	
	@GetMapping("/FinishPemesanan")
	public List<Pemesanan> getAllFPemesanan(){
		return pemesananService.getFPemesanan();
	}
	
	@GetMapping("/SaleByMonth")
	public List<IPemesanan> getSaleByMonth(){
		return pemesananService.getMonthTotalSale();
	}
	
	@PostMapping(value="/add")
	 public ResponseEntity<Pemesanan> createPemesanan(@RequestBody Pemesanan pemesanan){
		pemesananService.savePemesanan(pemesanan);
		 
		 return new ResponseEntity<Pemesanan>(pemesanan, HttpStatus.OK);
	 }
	
	
	@PutMapping(value = "/updatePemesanan/{id}")
	public ResponseEntity<Pemesanan> updateStatPemesanan (@PathVariable("id") int id){
		try {
			pemesananService.updateStatusPemesanan(id);
			return new ResponseEntity<Pemesanan>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Pemesanan>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/updateProduk/{id}/{status}")
	public ResponseEntity<Pemesanan> updateStatProduk (@PathVariable("id") int id, @PathVariable("status") Integer status){
		try {
			pemesananService.updateStatusProduk(id,status);
			
			System.out.println(status);
			return new ResponseEntity<Pemesanan>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Pemesanan>(HttpStatus.NOT_FOUND);
		}
	}
	

	

}
