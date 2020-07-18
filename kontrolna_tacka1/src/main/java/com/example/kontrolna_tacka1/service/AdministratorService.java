package com.example.kontrolna_tacka1.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.repository.*;
import org.springframework.stereotype.Service;


@Service
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	public Administrator find(String userName,String password) {
		Administrator a=this.administratorRepository.findByUserNameAndPassword(userName, password);
		return a;
	}
}
