package com.java.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Pulsa;
import com.java.repository.PulsaRepository;


@Service
@Transactional
public class PulsaService {
	

	@Autowired PulsaRepository pulsaRepo;
	
	public List<Pulsa> getAllPulsa(){
		return pulsaRepo.findAll();
	}
	
	
	public Pulsa getPulsaById(int id) {
		return pulsaRepo.findById(id).get();
	}
	
	public void savePulsa(Pulsa pulsa) {
		pulsaRepo.save(pulsa);
	}
	
	public void deletePulsa(int id) {
		pulsaRepo.deleteById(id);
	}

}
