package com.example.kontrolna_tacka1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Entity
public class Manager extends Korisnik implements Serializable {
	
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Bioskop> bioskopi = new HashSet<>();

}
