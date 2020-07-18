package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String vreme;
	@Column
	private int cena;
	@Column
	private int brojRezervacija;
	
	
	@Column
	private boolean rezervisan;
	
	public Projekcija()
	{
		
	}
	
	
	
	public Projekcija(long id, String dan, String vreme, int cena) {
		super();
		this.id = id;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.brojRezervacija = 0;
		this.rezervisan = false;
	}
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn
	private Film film;
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToMany(mappedBy = "raspored")
	private Set<Bioskop> bioskopi = new HashSet<>();
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	public int getBrojRezervacija() {
		return brojRezervacija;
	}
	public void setBrojRezervacija(int brojRezervacija) {
		this.brojRezervacija = brojRezervacija;
	}
	
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public boolean isRezervisan() {
		return rezervisan;
	}
	public void setRezervisan(boolean rezervisan) {
		this.rezervisan = rezervisan;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	

}
