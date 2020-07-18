package com.example.kontrolna_tacka1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.repository.*;
import java.util.*;

@Service
public class ProjekcijaService {
	
	@Autowired
	private ProjekcijaRepository projekcijaRepository;
	
	public List<Projekcija> findAll(){
		List<Projekcija> projekcije=this.projekcijaRepository.findAll();
		return projekcije;
	}
	public Projekcija findOne(Long id)
	{
		return this.projekcijaRepository.getOne(id);
	}
	public List<Projekcija> findSlobodne(){
		List<Projekcija> projekcije=this.projekcijaRepository.findAll();
		List<Projekcija> slobodne = new ArrayList<>();
		for(Projekcija p : projekcije)
		{
			if(p.isRezervisan()==false)
			{
				slobodne.add(p);
			}
		}
		return slobodne;
	}
	public List<Projekcija> findRezervisane(){
		List<Projekcija> projekcije=this.projekcijaRepository.findAll();
		List<Projekcija> slobodne = new ArrayList<>();
		for(Projekcija p : projekcije)
		{
			if(p.isRezervisan()==true)
			{
				slobodne.add(p);
			}
		}
		return slobodne;
	}
	public Projekcija saveProjekcija(Projekcija p)
	{
		return this.projekcijaRepository.save(p);
	}

}
