package com.example.kontrolna_tacka1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kontrolna_tacka1.repository.*;
import com.example.kontrolna_tacka1.entity.*;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;
	
	public Sala saveSala(Sala sala) {
		return this.salaRepository.save(sala);
	}
	
	public List<Sala> findAll(){
		List<Sala> sale=this.salaRepository.findAll();
		return sale;
	}
	public void delete(Long id)
	{
		this.salaRepository.deleteById(id);
	}
	
	public Sala findOne(Long id) {
        return this.salaRepository.getOne(id);
	}
	
	

}
