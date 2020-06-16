package com.example.kontrolna_tacka1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kontrolna_tacka1.entity.*;
import com.example.kontrolna_tacka1.entity.Bioskop;
import com.example.kontrolna_tacka1.*;

public interface BioskopRepository extends JpaRepository<Bioskop, Long> {
	

}
