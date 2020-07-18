package com.example.kontrolna_tacka1.entitydto;

public class MenadzerDTO {
	
	private Long id;
	private String name;
	private String surname;
	private String userName;
	public MenadzerDTO(Long id, String name, String surname, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.userName = userName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
