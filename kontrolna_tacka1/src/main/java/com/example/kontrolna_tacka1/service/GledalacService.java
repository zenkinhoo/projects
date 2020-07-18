package com.example.kontrolna_tacka1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.repository.*;

@Service
public class GledalacService {
	
	@Autowired
	private GledalacRepository gledalacRepository;
	
	//cuvanje odredjenog gledaoca
		public Gledalac save(Gledalac gledalac) {
			return this.gledalacRepository.save(gledalac);
		}
		
		public Gledalac registracija(Korisnik g) {
			//treba da imam throws kao exception da li vec postiji takav
			Gledalac gledalac=new Gledalac();
			gledalac.setUserName(g.getUserName());
			gledalac.setPassword(g.getPassword());
			gledalac.setName(g.getName());
			gledalac.setSurname(g.getSurname());
			gledalac.setContactTel(g.getContactTel());
			gledalac.setDate(g.getDate());
			gledalac.setEmail(g.getEmail());
			//nez jel ovako treba uloga i aktivnost
			gledalac.setRole("gledalac");
			gledalac.setActive(true);
			
			return this.gledalacRepository.save(gledalac);
			
		}
		
		public Gledalac find(String userName,String password) {
			Gledalac g=this.gledalacRepository.findByUserNameAndPassword(userName, password);

			return g;
		}

}
