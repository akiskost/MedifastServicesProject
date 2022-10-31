package com.test.medifastservices.dto;

public class PatientDTO {
	private Integer pid;
	private String fname;
	private String lname;
	private String address;
	private Integer phonenumber;
	private Integer amka;
	private String idno;

	public PatientDTO() {
	}

	public PatientDTO(int pid, String fname, String lname, String address, int phonenumber, int amka, String idno) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAmka() {
		return amka;
	}

	public void setAmka(int amka) {
		this.amka = amka;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}
}
