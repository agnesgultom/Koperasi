package com.java.api;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.model.Produk;
import com.java.model.Pulsa;

@Service
public class ProdukApi {
	
	String url = "http://localhost:8080/";
	

	
	@Autowired RestTemplate restTemplate;
	
	public List<Produk> getAllProduk(){
		List<Produk> listProduk= Arrays.stream(restTemplate.getForObject(url + "produk/get", Produk[].class)).collect(Collectors.toList());
		return listProduk;
	}
	
	public Produk getProdukById(int id) {
		Produk produk = restTemplate.getForObject(url + "/produk/get/{id}", Produk.class, id);
		return produk;
	}
	
	public void deleteProduk(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "/produk/delete/{id}", parameter);
	}
	
	public void updateProduk(Produk produk) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", produk.getId_produk());
		restTemplate.put(url + "produk/edit/{id}", produk, parameter);
	}
	
	public void addProduk(Produk produk) {
		restTemplate.postForObject(url + "/produk/add", produk, Produk.class);
	}
	public List<Pulsa> getAllPulsa(){
		List<Pulsa> listPulsa= Arrays.stream(restTemplate.getForObject(url + "pulsa/get", Pulsa[].class)).collect(Collectors.toList());
		return listPulsa;
	}
	
	public Pulsa getPulsaById(int id) {
		Pulsa pulsa = restTemplate.getForObject(url + "/pulsa/get/{id}", Pulsa.class, id);
		return pulsa;
	}
	
	public void deletePulsa(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "/pulsa/delete/{id}", parameter);
	}
	
	public void updatePulsa(Pulsa pulsa) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", pulsa.getId_pulsa());
		restTemplate.put(url + "pulsa/edit/{id}", pulsa, parameter);
	}
	
	public void addPulsa(Pulsa pulsa) {
		restTemplate.postForObject(url + "/pulsa/add", pulsa, Pulsa.class);
	}

}
