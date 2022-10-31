package com.test.medifastservices.model;

public class Patient {
	private int pid;
	private String fname;
	private String lname;
	private String address;
	private int phonenumber;
	private int amka;
	private String idno;
	
	public Patient() {}

	public Patient(int pid, String fname, String lname, String address, int phonenumber, int amka, String idno) {
		
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.amka = amka;
		this.idno = idno;

	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
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
