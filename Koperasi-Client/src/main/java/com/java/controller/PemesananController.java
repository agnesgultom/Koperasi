package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.java.api.ProdukApi;


@RestController
@RequestMapping("pemesanan")
public class PemesananController {
	
	@Autowired ProdukApi pemesananapi;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("pemesanan");
		mv.addObject("listPemesanan", pemesananapi.getAllPemesanan());
		
		System.out.println("get in pemesanan");
		return mv;
	}
	
	@GetMapping("/Riwayat")
	public ModelAndView getRiwayat() {
		ModelAndView mv = new ModelAndView("Riwayat");
		mv.addObject("listRiwayat", pemesananapi.getAllFPemesanan());
		
		System.out.println("get in pemesanan");
		return mv;
	}
	
	
}
