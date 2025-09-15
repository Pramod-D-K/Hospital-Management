package com.acciojob.first_api_learning.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Doctor {
    @Id
    private  int id;
    private String name;
    private String spc;
    private double exp;

    public Doctor(int id, String name, String spc, double exp) {
        this.id = id;
        this.name = name;
        this.spc = spc;
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpc() {
        return spc;
    }

    public void setSpc(String spc) {
        this.spc = spc;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double experience) {
        this.exp = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spc='" + spc + '\'' +
                ", exp=" + exp +
                '}';
    }
}
