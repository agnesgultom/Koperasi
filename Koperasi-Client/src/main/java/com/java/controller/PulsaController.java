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
import com.java.model.Pulsa;


@RestController
@RequestMapping("pulsa")
public class PulsaController {
	@Autowired ProdukApi produkapi;
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("pulsa");
		mv.addObject("listPulsa", produkapi.getAllPulsa());
		System.out.println("get in");
		return mv;
	}

	    
    @GetMapping("/hapus/{id}")
    public RedirectView hapusPulsa(@PathVariable("id") int id) {
    	System.out.println("into the delete");
    	produkapi.deletePulsa(id);
        return new RedirectView("/pulsa/");
    }
    
    @GetMapping("/EditPulsa/{id}")
    public ModelAndView tampilFormedit(@PathVariable(name = "id") int id, ModelMap modelMap) {
        System.out.println(produkapi.getPulsaById(id).getId_pulsa());
        
        ModelAndView mv = new ModelAndView("EditPulsa");
       
        mv.addObject("pulsa", produkapi.getPulsaById(id));
    
        return mv;
    }
    
    
    
    @PostMapping("/EditPulsa")
    public RedirectView editPulsa(@ModelAttribute Pulsa pulsa, BindingResult errors, SessionStatus status) {
        try {
        	produkapi.updatePulsa(pulsa);
            status.setComplete();
            return new RedirectView("/pulsa/");
        } catch (HttpStatusCodeException e) {
            ResponseEntity<String> response = ResponseEntity.status(e.getStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            errors.reject("error.object", response.getBody());
        }
        return new RedirectView("/pulsa/EditPulsa");
    }
    
    
    @GetMapping("/AddPulsa")
    public ModelAndView tampilFormTambah(){

          Pulsa pulsa= new Pulsa();
          ModelAndView modelAndView = new ModelAndView("AddPulsa");
          modelAndView.addObject("pulsa", pulsa);
          modelAndView.setViewName("AddPulsa");
        return modelAndView;
    }
    

    @PostMapping("/AddPulsa")
    public RedirectView addPulsa(@ModelAttribute("AddPulsa") Pulsa pulsa){

    	produkapi.addPulsa(pulsa);
        
        return new RedirectView("/pulsa/");
    }

}
