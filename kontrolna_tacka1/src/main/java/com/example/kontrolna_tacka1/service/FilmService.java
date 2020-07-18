package com.example.kontrolna_tacka1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kontrolna_tacka1.repository.*;
import com.example.kontrolna_tacka1.entity.*;
import java.util.*;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	public List<Film> findAll(){
		List<Film> film=this.filmRepository.findAll();
		return film;
	}
	
	//sortiranje filma po oceni
	public List<Film> sortOcena(){
		return this.filmRepository.findAllByOrderByOcenaDesc();
		
	}
	//pronalazenje samo odgledanih filmova
	public List<Film> findOdgledani(){
		List<Film> filmovi=this.filmRepository.findAll();
		List<Film> odgledani = new ArrayList<>();
		for (Film film : filmovi) {
			if(film.isOdgledan()==true)
			{
				odgledani.add(film);
			}	
		}
		return odgledani;
	}
	//pronalazenje odgledanih ali neocenjenih filmova
	public List<Film> findOdgledaniNeocenjeni(){
		List<Film> filmovi=this.filmRepository.findAll();
		List<Film> povratna = new ArrayList<>();
		for (Film film : filmovi) {
			if(film.isOdgledan()==true && film.getOcena()==0)
			{
				povratna.add(film);
			}	
		}
		return povratna;
	}
	
	//pronalazenje odgledanih i ocenjenih filmova
		public List<Film> findOdgledaniOcenjeni(){
			List<Film> filmovi=this.filmRepository.findAll();
			List<Film> povratna = new ArrayList<>();
			for (Film film : filmovi) {
				if(film.isOdgledan()==true && film.getOcena()!=0)
				{
					povratna.add(film);
				}	
			}
			return povratna;
		}
		public Film findOne(Long id) {
			Film film=this.filmRepository.getOne(id);
			return film;
		}
		public Film saveFilm(Film f)
		{
			return this.filmRepository.save(f);
		}
}
