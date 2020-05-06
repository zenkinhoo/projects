package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Sala implements Serializable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int kapacitet;
	@Column
	private String oznaka;
	
	
	@ManyToMany
    @JoinTable(name = "sala_projekcija",
    joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	private Set<Projekcija> projekcije = new HashSet<>();
	
	
	//druga strana veze
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Bioskop bioskop;
	
	// terminska lista projekcija
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public Set<Projekcija> getProjekcije() {
		return projekcije;
	}
	public void setProjekcije(Set<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
	
	
	
}
