package com.example.kontrolna_tacka1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.repository.*;

@Service
public class MenadzerService {
	
	@Autowired
	private MenadzerRepository menadzerRepository;
	
	public List<Menadzer> findAll(){
		List<Menadzer> men=this.menadzerRepository.findAll();
		return men;
	}
	public Menadzer save(Menadzer men) {
		return this.menadzerRepository.save(men);
	}
	public void delete(Long id) {
		this.menadzerRepository.deleteById(id);
	}
	public Menadzer registracija(Korisnik k) {
		//treba da imam throws kao exception da li vec postiji takav
		Menadzer men=new Menadzer();
		
		men.setUserName(k.getUserName());
		men.setPassword(k.getPassword());
		men.setName(k.getName());
		men.setSurname(k.getSurname());
		men.setContactTel(k.getContactTel());
		men.setDate(k.getDate());
		men.setEmail(k.getEmail());

		men.setRole("gledalac");
		men.setActive(true);
		
		return this.menadzerRepository.save(men);
		
	}
	public Menadzer find(String userName,String password) {
		Menadzer m=this.menadzerRepository.findByUserNameAndPassword(userName, password);
		return m;
	}
	public Menadzer findOne(Long id) {
		Menadzer menadzer = this.menadzerRepository.getOne(id);
        return menadzer;
	}

}
