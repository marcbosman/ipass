package nl.hu.v1ipass.model;

import java.util.Date;

public class Rooster {
	private int id;
	private Date datum;
	private String begintijd;
	private String eindtijd;
	private String groep;
	private int zwemleraar;	
	
	public Rooster(int id, Date datum, String begintijd, String eindtijd, String groep, int zwemleraar) {
		this.id = id;
		this.datum = datum;
		this.begintijd = begintijd;
		this.eindtijd = eindtijd;
		this.groep = groep;
		this.zwemleraar = zwemleraar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getBegintijd() {
		return begintijd;
	}

	public void setBegintijd(String begintijd) {
		this.begintijd = begintijd;
	}

	public String getEindtijd() {
		return eindtijd;
	}

	public void setEindtijd(String eindtijd) {
		this.eindtijd = eindtijd;
	}

	public String getGroep() {
		return groep;
	}

	public void setGroep(String groep) {
		this.groep = groep;
	}

	public int getZwemleraar() {
		return zwemleraar;
	}

	public void setZwemleraar(int zwemleraar) {
		this.zwemleraar = zwemleraar;
	}
	
}
