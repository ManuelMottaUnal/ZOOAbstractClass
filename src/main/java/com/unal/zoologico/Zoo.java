
package com.unal.zoologico;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Cage> jaulas;
    
    public ArrayList<Cage> getCage() {
        return this.jaulas;
    }
    
    public void addCage(Cage cage) {
        this.jaulas.add(cage);
    }
}
