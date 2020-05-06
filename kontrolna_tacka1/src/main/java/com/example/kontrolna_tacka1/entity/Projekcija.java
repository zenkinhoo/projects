package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Projekcija implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column
	private String dan;
	@Column
	private int cena;
	
	
	@ManyToMany(mappedBy = "raspored")
	private Set<Bioskop> bioskopi = new HashSet<>();
	
	@ManyToMany(mappedBy = "projekcije")
	private Set<Sala> sale = new HashSet<>();
	
	public String getDan() {
		return dan;
	}
	public void setDan(String dan) {
		this.dan = dan;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	
	

}
