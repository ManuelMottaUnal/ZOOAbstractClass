
package com.unal.zoologico.model;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Cage> cages;

    public Zoo() {
        cages = new ArrayList<>();
    }

    public Zoo(String name, String address, String phone, ArrayList<Cage> cages) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cages = cages;
    }
    
    public ArrayList<Cage> getCages() {
        return this.cages;
    }
    
    public void addCage(Cage cage) {
        this.cages.add(cage);
    }
    
    public void removeCage(Cage cage) {
        this.cages.remove(cage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
