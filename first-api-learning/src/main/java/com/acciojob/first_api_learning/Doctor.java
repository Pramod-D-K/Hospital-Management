package com.acciojob.first_api_learning;

public class Doctor {
    private  int id;
    private String name;
    private String specialist;
    private double experience;

    public Doctor(int id, String name, String specialist, double experience) {
        this.id = id;
        this.name = name;
        this.specialist = specialist;
        this.experience = experience;
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

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialist='" + specialist + '\'' +
                ", experience=" + experience +
                '}';
    }
}
