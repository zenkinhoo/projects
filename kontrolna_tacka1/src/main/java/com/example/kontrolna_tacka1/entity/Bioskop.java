package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Bioskop implements Serializable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String naziv;
	@Column
	private String adresa;
	@Column
	private String brCentrale;
	@Column
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Manager manager;
	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Sala> sale = new HashSet<>();
	
	@ManyToMany
    @JoinTable(name = "bioskop_projekcija",
    joinColumns = @JoinColumn(name = "bioskop_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	private Set<Projekcija> raspored = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrCentrale() {
		return brCentrale;
	}
	public void setBrCentrale(String brCentrale) {
		this.brCentrale = brCentrale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Sala> getSale() {
		return sale;
	}
	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Set<Projekcija> getRaspored() {
		return raspored;
	}
	public void setRaspored(Set<Projekcija> raspored) {
		this.raspored = raspored;
	}
	
	
	
	
	

}
