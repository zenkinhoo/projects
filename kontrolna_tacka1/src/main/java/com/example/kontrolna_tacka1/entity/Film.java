package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Film implements Serializable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	private String naziv;
	@Column
	private String opis;
	@Column
	private String zanr;
	@Column
	private double trajanje;
	@Column
	private double ocena;
	@Column
	private boolean odgledan;
	
	public Film()
	{
		
	}
	
	
	public Film(long id, String naziv, String opis, String zanr, double trajanje, double ocena, boolean odgledan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.zanr = zanr;
		this.trajanje = trajanje;
		this.ocena = ocena;
		this.odgledan = odgledan;
	}

	//druga strana veze s gledaocem
	@ManyToMany(mappedBy = "filmovi")
	private Set<Gledalac> gledaoci = new HashSet<>();
	
	@ManyToMany(mappedBy = "rezervisani_filmovi")
	private Set<Gledalac> gledaoci_rez = new HashSet<>();
	
	@ManyToMany(mappedBy = "ocene")
	private Set<Gledalac> gledaoci_ocene = new HashSet<>();
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy="film")
	private List<Projekcija> projekcije=new ArrayList<>();
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	public double getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(double trajanje) {
		this.trajanje = trajanje;
	}
	public double getOcena() {
		return ocena;
	}
	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	public boolean isOdgledan() {
		return odgledan;
	}
	public void setOdgledan(boolean odgledan) {
		this.odgledan = odgledan;
	}
	
	

}
