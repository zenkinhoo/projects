package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Gledaoc extends Korisnik implements Serializable {
	
	@ManyToMany
    @JoinTable(name = "gledaoc_film",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> filmovi = new HashSet<>();
	
	
	@ManyToMany
    @JoinTable(name = "gledaoc_rez_film",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> rezervisani_filmovi = new HashSet<>();
	
	
	@ManyToMany
    @JoinTable(name = "gledaoc_ocennjen_film",
    joinColumns = @JoinColumn(name = "gledaoc_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Set<Film> ocene = new HashSet<>(); // tipa je film jer klasa Film sadrzi polje ocena
	public Set<Film> getFilmovi() {
		return filmovi;
	}
	public void setFilmovi(Set<Film> filmovi) {
		this.filmovi = filmovi;
	}
	public Set<Film> getRezervisani_filmovi() {
		return rezervisani_filmovi;
	}
	public void setRezervisani_filmovi(Set<Film> rezervisani_filmovi) {
		this.rezervisani_filmovi = rezervisani_filmovi;
	}
	public Set<Film> getOcene() {
		return ocene;
	}
	public void setOcene(Set<Film> ocene) {
		this.ocene = ocene;
	}
	
	
	

}
