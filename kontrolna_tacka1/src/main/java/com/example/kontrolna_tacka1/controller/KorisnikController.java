package com.example.kontrolna_tacka1.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kontrolna_tacka1.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.*;
import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.service.KorisnikService;


import com.example.kontrolna_tacka1.service.BioskopService;

import java.util.List;

@Controller
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private BioskopService bioskopService;

	@GetMapping("/")
    public String welcome() {
        return "home.html";
    }
	 
	
	@GetMapping("/prijava")
    public String prijava(Model model) {
		Korisnik korisnik = new Korisnik();
    	model.addAttribute("korisnik", korisnik);
        return "prijava.html";
    }
	@GetMapping("/validacija")
    public String uspesna(Model model) {
		Korisnik korisnik = new Korisnik();
		Korisnik validan = this.korisnikService.findByuserNameAndPassword(korisnik.getUserName(), korisnik.getPassword());
		
			if(validan!=null)
				return "uspesna_prijava.html";
				
		return "neuspesna_prijava.html";
        
    }
	
	@GetMapping("/pregled")
    public String pregledProfila(Model model) {
	
     //   model.addAttribute("korisnici", this.korisnikService.findAll());
        return "pregled.html";
    }
	 @GetMapping("/registration")
	    public String registracija(Model model) {
	    	Korisnik korisnik = new Korisnik();
	    	model.addAttribute("korisnik", korisnik);
	    	return "registration.html";
	    }
	 @PostMapping("/sacuvaj-korisnika")
	    public String sacuvajKorisnika(@ModelAttribute Korisnik korisnik) {
	    	this.korisnikService.saveKorisnik(korisnik);
	    	return "prijava.html";
	    }
	 
	 @GetMapping("/dodajBioskop")
	    public String dodajBioskop(Model model) {
		 Bioskop bioskop = new Bioskop();
		 model.addAttribute("bioskop",bioskop);
	     return "dodajBioskop.html";
	    }
	
	 @PostMapping("/sacuvaj-bioskop")
	    public String sacuvajBioskop(@ModelAttribute Bioskop bioskop) {
	    	this.bioskopService.saveBioskop(bioskop);
	    	return "home.html";
	    }
	
}
