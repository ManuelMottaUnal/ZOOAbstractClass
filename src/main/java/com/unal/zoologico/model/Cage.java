/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.zoologico.model;

import com.google.cloud.firestore.annotation.Exclude;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Cage {
    private int animalCapacity;
    private ArrayList<Animal> animals;
    private int frequentyCleaning;
    private LocalDateTime lastCleaning;

    public int getFrequentyCleaning() {
        return frequentyCleaning;
    }

    public void setFrequentyCleaning(int frequentyCleaning) {
        this.frequentyCleaning = frequentyCleaning;
    }

    public String getLastCleaning() {
        return lastCleaning.toString();
    }

    public Cage() {
        this.lastCleaning = LocalDateTime.now();
        this.animals = new ArrayList<>();
    }

    public Cage(int animalCapacity, ArrayList<Animal> animals, int frequentyCleaning, LocalDateTime lastCleaning) {
        this.animalCapacity = animalCapacity;
        this.animals = animals;
        this.frequentyCleaning = frequentyCleaning;
        this.lastCleaning = lastCleaning;
    }

    public void setLastCleaning(String lastCleaning) {
        this.lastCleaning = LocalDateTime.parse(lastCleaning);
    }
    
    
    public Cage(int animalCapacity, int frequentyCleaning) {
        this.animalCapacity = animalCapacity;
        this.frequentyCleaning = frequentyCleaning;
        this.lastCleaning = LocalDateTime.now();
        this.animals = new ArrayList<>();
    }
    
    public int getAnimalCapacity() {
        return this.animalCapacity;
    }
    
    @Exclude
    public int getAnimalCount() {
        return animals.size();
    }
    
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
    
    public void addAnimal(Animal animal) {
        if (getAnimalCount() < getAnimalCapacity()) {
            animals.add(animal);
        }
    }
    
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
    
    @Exclude
    public String getStatusCleaning() {
        LocalDateTime cleanHour = lastCleaning.plusHours(frequentyCleaning);
        if (LocalDateTime.now().isBefore(cleanHour)) {
            return "Jaula Limpia";
        } else {
            return "La jaula está sucia.";
        }
    }
    
    public void cleanCage() {
        lastCleaning = LocalDateTime.now();
    }
}
