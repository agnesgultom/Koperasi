package com.java.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Produk;
import com.java.service.ProdukService;

@RestController
@RequestMapping("produk")
public class ProdukController {
	
	@Autowired ProdukService produkService;
	
	@GetMapping("/get")
	public List<Produk> getAllProduk(){
		return produkService.getAllProduk();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Produk> getProdukById(@PathVariable("id") int id){
		try {
			Produk produk = produkService.getProdukById(id);
			return new ResponseEntity<Produk>(produk, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Produk>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<Produk> updateProduk (@PathVariable("id") int id, @RequestBody Produk produk){
		try {
			Produk existProduk = produkService.getProdukById(id);
			produk.setId_produk(id);
			produkService.saveProduk(produk);
			
			return new ResponseEntity<Produk>(produk, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Produk>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping(value="/add")
	 public ResponseEntity<Produk> createProduk(@RequestBody Produk produk){
		 produkService.saveProduk(produk);
		 
		 return new ResponseEntity<Produk>(produk, HttpStatus.OK);
	 }
	
	@DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<String> deleteProduk(@PathVariable("id") int id){
		 try {
			 Produk existproduk = produkService.getProdukById(id);
			 produkService.deleteProduk(id);
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
	 }
	
	
	
	
}
