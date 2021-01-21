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

import com.java.model.Pulsa;
import com.java.service.PulsaService;


@RestController
@RequestMapping("pulsa")
public class PulsaController {
	
	@Autowired PulsaService pulsaService;
		
		@GetMapping("/get")
		public List<Pulsa> getAllPulsa(){
			return pulsaService.getAllPulsa();
		}
	
		@GetMapping("/get/{id}")
		public ResponseEntity<Pulsa> getPulsaById(@PathVariable("id") int id){
			try {
				Pulsa pulsa = pulsaService.getPulsaById(id);
				return new ResponseEntity<Pulsa>(pulsa, HttpStatus.OK);
			}catch(NoSuchElementException e) {
				return new ResponseEntity<Pulsa>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		@PutMapping(value = "/edit/{id}")
		public ResponseEntity<Pulsa> updatePulsa (@PathVariable("id") int id, @RequestBody Pulsa pulsa){
			try {
				Pulsa existPulsa = pulsaService.getPulsaById(id);
				pulsa.setId_pulsa(id);
				pulsaService.savePulsa(pulsa);
				
				return new ResponseEntity<Pulsa>(pulsa, HttpStatus.OK);
			}catch(NoSuchElementException e) {
				return new ResponseEntity<Pulsa>(HttpStatus.NOT_FOUND);
			}
		}
		
		
		@PostMapping(value="/add")
		 public ResponseEntity<Pulsa> createPulsa(@RequestBody Pulsa pulsa){
			 pulsaService.savePulsa(pulsa);
			 
			 return new ResponseEntity<Pulsa>(pulsa, HttpStatus.OK);
		 }
		
		@DeleteMapping(value="/delete/{id}")
		 public ResponseEntity<String> deletePulsa(@PathVariable("id") int id){
			 try {
				 Pulsa existpulsa = pulsaService.getPulsaById(id);
				 pulsaService.deletePulsa(id);
				 
				 return new ResponseEntity<String>(HttpStatus.OK);
			 }catch(NoSuchElementException e) {
				 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			 }
		 }
		
	

}
