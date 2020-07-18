package com.example.kontrolna_tacka1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.kontrolna_tacka1.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.*;

import com.example.kontrolna_tacka1.entitydto.*;
import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.service.KorisnikService;

import com.example.kontrolna_tacka1.service.BioskopService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class KorisnikController {
	
	public static int role=1; //promenljiva koja odredjuje ulogu(1 gledaoc, 2 menadzer , 3 administrator)
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private BioskopService bioskopService;
	
	@Autowired
	private GledalacService gledalacService;
	
	@Autowired
	private MenadzerService menadzerService;
	
	@Autowired
	private AdministratorService administratorService;

/*	@GetMapping("/")
    public String welcome() {
        return "home.html";
    }*/
    

	 
	
	/*@GetMapping("/prijava")
    public String prijava(Model model) {
		Korisnik korisnik = new Korisnik();
    	model.addAttribute("korisnik", korisnik);
        return "prijava.html";
    }*/
/*	@GetMapping("/validacija")
    public String uspesna(@ModelAttribute Korisnik korisnik,Model model) {
		//Korisnik korisnik = new Korisnik();
		Korisnik validan = this.korisnikService.findByuserNameAndPassword(korisnik.getUserName(), korisnik.getPassword());
		
			if(validan!=null)
				return "uspesna_prijava.html";
				
		return "neuspesna_prijava.html";
        
    }*/
	
	/*@GetMapping("/pregled")
    public String getKorisnici(Model model) {
        List<Korisnik> korisnikList = this.korisnikService.findAll();
        model.addAttribute("korisnici", korisnikList);
        return "pregled.html";
    }*/
	/* @GetMapping("/registration")
	    public String registracija(Model model) {
	    	Korisnik korisnik = new Korisnik();
	    	model.addAttribute("korisnik", korisnik);
	    	return "registration.html";
	    }
	 @PostMapping("/sacuvaj-korisnika")
	    public String sacuvajKorisnika(@ModelAttribute Korisnik korisnik) {
	    	this.korisnikService.saveKorisnik(korisnik);
	    	return "prijava.html";
	    }*/
	 
	 public static int getRole() {
		return role;
	}

	public static void setRole(int role) {
		KorisnikController.role = role;
	}

	@PostMapping(
				value="/registration",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Korisnik> registracija(@RequestBody Korisnik k) throws Exception{
				Korisnik korisnik=new Korisnik(k.getUserName(),k.getPassword(),k.getName(),k.getSurname(),k.getContactTel(),k.getEmail(),k.getDate(),k.getRole());
				Korisnik noviKorisnik=gledalacService.registracija(korisnik);
				return new ResponseEntity<>(noviKorisnik,HttpStatus.OK);
			}
	 
	// registracija menadzera 
		@PostMapping(
				value="/registrationMan",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Korisnik> registracijaMen(@RequestBody Korisnik kor) throws Exception{
			if(role==3)
			{
				Korisnik korisnik=new Korisnik(kor.getUserName(),kor.getPassword(),kor.getName(),kor.getSurname(),kor.getContactTel(),kor.getEmail(),kor.getDate(),kor.getRole());
				Korisnik noviKorisnik=menadzerService.registracija(korisnik);
				return new ResponseEntity<>(noviKorisnik,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		// pregled menadzera
		
		@GetMapping(
				value="/pregledMenadzera",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<MenadzerDTO>> pregledMenadzera(){
			if(role==1)
			{
				List<Menadzer> menadzeri=this.menadzerService.findAll();
				
				
				List<MenadzerDTO> menadzeriDTO=new ArrayList<>();
				
				for (Menadzer men : menadzeri) {
					MenadzerDTO menadzerDTO=new MenadzerDTO(men.getId(),men.getName(),men.getSurname(),men.getUserName());
					menadzeriDTO.add(menadzerDTO);
					
				}
				
				return new ResponseEntity<>(menadzeriDTO,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		@GetMapping(
			value = "/obrisiMenadzera/{id}",
	        produces = MediaType.APPLICATION_JSON_VALUE)  
		public ResponseEntity<MenadzerDTO> obrisi(@PathVariable(name="id") Long id){
		
			Menadzer menadzer=this.menadzerService.findOne(id);
			MenadzerDTO men = new MenadzerDTO(menadzer.getId(),menadzer.getName(),menadzer.getSurname(),menadzer.getUserName());
			this.menadzerService.delete(id);
			
			return new ResponseEntity<>(men,HttpStatus.OK);
		}
		@GetMapping(
				value = "/profilMenadzer/{id}",
		        produces = MediaType.APPLICATION_JSON_VALUE)  
			public ResponseEntity<MenadzerDTO> profil(@PathVariable(name="id") Long id){
			
				Menadzer menadzer=this.menadzerService.findOne(id);
				MenadzerDTO men = new MenadzerDTO(menadzer.getId(),menadzer.getName(),menadzer.getSurname(),menadzer.getUserName());
				
				return new ResponseEntity<>(men,HttpStatus.OK);
			}
			
		@PostMapping(
				value="/prijava",
				consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
		        produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Korisnik> prijava(@RequestBody Korisnik korisnik) throws Exception{
				Gledalac g=this.gledalacService.find(korisnik.getUserName(),korisnik.getPassword());
				Menadzer m=this.menadzerService.find(korisnik.getUserName(),korisnik.getPassword());
				Administrator a=this.administratorService.find(korisnik.getUserName(),korisnik.getPassword());
				if(g!=null && g.isActive()==true) {
					role=1;
					Korisnik povratna=new Korisnik(g.getUserName(),g.getPassword(),g.getName(),g.getSurname(),g.getContactTel(),g.getEmail(),g.getDate(),g.getRole());
					return new ResponseEntity<>(povratna,HttpStatus.OK);
				}else if(m!=null && m.isActive()==true) {
					role=2;
					Korisnik povratna=new Korisnik(m.getUserName(),m.getPassword(),m.getName(),m.getSurname(),m.getContactTel(),m.getEmail(),m.getDate(),m.getRole());
					return new ResponseEntity<>(povratna,HttpStatus.OK);
				}else if(a!=null && a.isActive()==true) {
					role=3;
					Korisnik povratna=new Korisnik(a.getUserName(),a.getPassword(),a.getName(),a.getSurname(),a.getContactTel(),a.getEmail(),a.getDate(),a.getRole());
					return new ResponseEntity<>(povratna,HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
	/* @GetMapping("/dodajBioskop")
	    public String dodajBioskop(Model model) {
		 Bioskop bioskop = new Bioskop();
		 model.addAttribute("bioskop",bioskop);
	     return "dodajBioskop.html";
	    }
	
	 @PostMapping("/sacuvaj-bioskop")
	    public String sacuvajBioskop(@ModelAttribute Bioskop bioskop) {
	    	this.bioskopService.saveBioskop(bioskop);
	    	return "home.html";
	    }*/
	
}
