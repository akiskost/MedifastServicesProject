package com.test.medifastservices.dto;

public class PatientDTO {
	private int id;
	private String fname;
	private String lname;
	private String address;
	private Integer phoneNumber;
	private Integer amka;
	private String idno;

	public PatientDTO() {
	}

	public PatientDTO(int id, String fname, String lname, String address, int phoneNumber, int amka, String idno) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.amka = amka;
		this.idno = idno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAmka() {
		return amka;
	}

	public void setAmka(Integer amka) {
		this.amka = amka;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}
}
