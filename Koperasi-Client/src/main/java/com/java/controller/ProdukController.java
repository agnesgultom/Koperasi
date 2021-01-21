package com.java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.java.api.ProdukApi;
import com.java.model.Produk;


@RestController
@RequestMapping("produk")
public class ProdukController {
	@Autowired ProdukApi produkapi;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("listProduk", produkapi.getAllProduk());
		System.out.println("get in");
		return mv;
	}

	    
    @GetMapping("/hapus/{id}")
    public RedirectView hapusProduk(@PathVariable("id") int id) {
    	System.out.println("into the delete");
    	produkapi.deleteProduk(id);
        return new RedirectView("/produk/");
    }
    
    @GetMapping("/form/{id}")
    public ModelAndView tampilFormedit(@PathVariable(name = "id") int id, ModelMap modelMap) {
        System.out.println(produkapi.getProdukById(id).getId_produk());
        
        ModelAndView mv = new ModelAndView("form");
       
        mv.addObject("produk", produkapi.getProdukById(id));
    
        return mv;
    }
    
    
    
    @PostMapping("/form")
    public RedirectView editProduk(@ModelAttribute Produk produk, BindingResult errors, SessionStatus status) {
        try {
        	produkapi.updateProduk(produk);
            status.setComplete();
            return new RedirectView("/produk/");
        } catch (HttpStatusCodeException e) {
            ResponseEntity<String> response = ResponseEntity.status(e.getStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            errors.reject("error.object", response.getBody());
        }
        return new RedirectView("/produk/form");
    }
    
    
    @GetMapping("/formAdd")
    public ModelAndView tampilFormTambah(){

          Produk produk= new Produk();
          ModelAndView modelAndView = new ModelAndView("formAdd");
          modelAndView.addObject("produk", produk);
          modelAndView.setViewName("formAdd");
        return modelAndView;
    }
    

    @PostMapping("/formAdd")
    public RedirectView addProduk(@ModelAttribute("formAdd") Produk produk){

        produkapi.addProduk(produk);
        
        return new RedirectView("/produk/");
    }

}
