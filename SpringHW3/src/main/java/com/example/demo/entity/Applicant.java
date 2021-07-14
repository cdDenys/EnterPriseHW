package com.example.demo.entity;

public class Applicant {
    private String fullname;
    private byte points;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public byte getPoints() {
        return points;
    }

    public void setPoints(byte points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "fullname='" + fullname + '\'' +
                ", points=" + points +
                '}';
    }
}
