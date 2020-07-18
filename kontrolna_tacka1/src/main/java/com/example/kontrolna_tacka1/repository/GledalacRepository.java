package com.example.kontrolna_tacka1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kontrolna_tacka1.entity.*;

public interface GledalacRepository extends JpaRepository<Gledalac,Long>{

	Gledalac findByUserNameAndPassword(String userName,String password);
}
