/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.zoologico;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Cage {
    private Size size;
    private int animalCapacity;
    private ArrayList<Animal> animals;
    private int frequentyCleaning;
    private LocalDateTime lastCleaning;
    
    public Cage(Size size, int animalCapacity, int frequentyCleaning) {
        this.size = size;
        this.animalCapacity = animalCapacity;
        this.frequentyCleaning = frequentyCleaning;
        this.lastCleaning = LocalDateTime.now();
    }
    
    public Size getSize() {
        return this.size;
    }
    
    public int getAnimalCapacity() {
        return this.animalCapacity;
    }
    
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
