package com.test.medifastservices.dto;

public class AppointmentDTO {

    private int apid;
    private String fname;
    private String lname;
    private String date;
    private String exam;
    private String result;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int apid, String fname, String lname, String date, String exam, String result) {
        this.apid = apid;
        this.fname = fname;
        this.lname = lname;
        this.date = date;
        this.exam = exam;
        this.result = result;
    }

    public int getApid() {
        return apid;
    }

    public void setApid(int apid) {
        this.apid = apid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}