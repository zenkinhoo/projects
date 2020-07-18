package com.example.kontrolna_tacka1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.entity.Korisnik;



import java.util.List;


import com.example.kontrolna_tacka1.*;
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	
}

