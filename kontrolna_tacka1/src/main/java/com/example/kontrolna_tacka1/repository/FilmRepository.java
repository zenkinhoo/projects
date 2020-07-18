package com.example.kontrolna_tacka1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kontrolna_tacka1.entity.*;

public interface FilmRepository extends JpaRepository<Film,Long> {
	
	List<Film> findAllByOrderByOcenaDesc();

}
