package com.example.kontrolna_tacka1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.kontrolna_tacka1.repository.*;
import org.springframework.stereotype.Service;

import com.example.*;
import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.repository.KorisnikRepository;


@Service
public class KorisnikService {
	
	@Autowired
    private KorisnikRepository korisnikRepository;
	
	
	public Korisnik saveKorisnik(Korisnik korisnik) {
    	return this.korisnikRepository.save(korisnik);
    }

	public List<Korisnik> findAll() {
		List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
	}
	
	
	
	
	

}
