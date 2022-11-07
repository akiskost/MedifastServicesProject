package com.test.medifastservices.model;

public class Patient {
	private int pid;
	private String fname;
	private String lname;
	private String address;
	private Long phonenumber;
	private Long amka;
	private String idno;
	
	public Patient() {}

	public Patient(int pid, String fname, String lname, String address, Long phonenumber, Long amka, String idno) {
		
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

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {this.phonenumber = phonenumber;
	}

	public Long getAmka() {
		return amka;
	}

	public void setAmka(Long amka) {
		this.amka = amka;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}
}
