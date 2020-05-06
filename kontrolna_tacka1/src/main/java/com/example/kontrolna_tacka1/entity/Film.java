package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;



import java.io.Serializable;
import java.util.HashSet;
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
	
	
	//druga strana veze s gledaocem
	@ManyToMany(mappedBy = "filmovi")
	private Set<Gledaoc> gledaoci = new HashSet<>();
	
	@ManyToMany(mappedBy = "rezervisani_filmovi")
	private Set<Gledaoc> gledaoci_rez = new HashSet<>();
	
	@ManyToMany(mappedBy = "ocene")
	private Set<Gledaoc> gledaoci_ocene = new HashSet<>();
	
	
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
	
	

}
