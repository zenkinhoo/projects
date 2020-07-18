package com.example.kontrolna_tacka1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.kontrolna_tacka1.service.*;

import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.entitydto.BioskopDTO;
import com.example.kontrolna_tacka1.entitydto.*;

@RestController
@RequestMapping(value="/api")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	 @PostMapping(
				value="/dodajSalu",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Sala> dodajSalu(@RequestBody Sala s) throws Exception{
		 if(KorisnikController.getRole()==2)
			{
			 Sala sala = new Sala(s.getId(),s.getKapacitet(),s.getOznaka());
				return new ResponseEntity<>(this.salaService.saveSala(sala),HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	 @GetMapping(
				value="/pregledSala",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Sala>> pregledSala(){
		 if(KorisnikController.getRole()==2)
			{
			 List<Sala> sala=this.salaService.findAll();
				return new ResponseEntity<>(sala,HttpStatus.OK);
			}
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	 
	 @GetMapping(
				value = "/obrisiSalu/{id}",
		        produces = MediaType.APPLICATION_JSON_VALUE)  
			public ResponseEntity<SalaDTO> obrisiSalu(@PathVariable(name="id") Long id){
			
				Sala sala = this.salaService.findOne(id);
				SalaDTO s = new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznaka());
				this.salaService.delete(id);
				
				return new ResponseEntity<>(s,HttpStatus.OK);
			}
	 @GetMapping(
				value="izmeniSalu/{id}",
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SalaDTO> sala(@PathVariable(name="id") Long id){
			Sala sala=this.salaService.findOne(id);
			if(sala==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			SalaDTO s=new SalaDTO();
			s.setId(sala.getId());
			s.setKapacitet(sala.getKapacitet());
			s.setOznaka(sala.getOznaka());
			
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
	 
	 @PostMapping(
				value="/izmena",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE
				)
			public ResponseEntity<SalaDTO> izmenaSale(@RequestBody SalaDTO s) throws Exception{
				Sala sala = this.salaService.findOne(s.getId());
				if(sala==null) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				sala.setKapacitet(s.getKapacitet());
				sala.setOznaka(s.getOznaka());
				this.salaService.saveSala(sala);
				
				SalaDTO ret = new SalaDTO();
				ret.setId(sala.getId());
				return new ResponseEntity<>(ret,HttpStatus.OK);
			}
	

}
