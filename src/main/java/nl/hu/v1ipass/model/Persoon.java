package nl.hu.v1ipass.model;

import java.util.Date;

public class Persoon {
	private int id;
	private String adres;
	private String woonplaats;
	private int telefoonnummer;
	private String bijzonderheden;
	private String geboortedatum;
	private String email;
	private String huisarts;
	private String naam;
	private String groep;
	private String rol;
	
	
	public Persoon(int id, String adres, String woonplaats, int telefoonnummer, String bijzonderheden, String geboortedatum, String email, String huisarts, String naam, String groep, String rol) {
		this.id = id;
		this.adres = adres;
		this.woonplaats = woonplaats;
		this.telefoonnummer = telefoonnummer;
		this.bijzonderheden = bijzonderheden;
		this.geboortedatum = geboortedatum;
		this.email = email;
		this.huisarts = huisarts;
		this.naam = naam;
		this.groep = groep;
		this.rol = rol;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}


	public String getWoonplaats() {
		return woonplaats;
	}


	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}


	public int getTelefoonnummer() {
		return telefoonnummer;
	}


	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}


	public String getBijzonderheden() {
		return bijzonderheden;
	}


	public void setBijzonderheden(String bijzonderheden) {
		this.bijzonderheden = bijzonderheden;
	}


	public String getGeboortedatum() {
		return geboortedatum;
	}


	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHuisarts() {
		return huisarts;
	}


	public void setHuisarts(String huisarts) {
		this.huisarts = huisarts;
	}


	public String getNaam() {
		return naam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public String getGroep() {
		return groep;
	}


	public void setGroep(String groep) {
		this.groep = groep;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
