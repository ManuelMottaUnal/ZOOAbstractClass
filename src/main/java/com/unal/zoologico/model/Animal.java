/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.zoologico.model;

import java.time.LocalDateTime;

/**
 *
 * @author manuel
 */
public class Animal {
    private int frequencyFood;
    private LocalDateTime lastMeal;
    private String animalName;
    private String nameOfTheAnimal;

    public LocalDateTime getLastMeal() {
        return lastMeal;
    }

    public void setLastMeal(LocalDateTime lastMeal) {
        this.lastMeal = lastMeal;
    }

    public String getNameOfTheAnimal() {
        return nameOfTheAnimal;
    }

    public void setNameOfTheAnimal(String nameOfTheAnimal) {
        this.nameOfTheAnimal = nameOfTheAnimal;
    }

    public int getFrequencyFood() {
        return frequencyFood;
    }

    public String getAnimalName() {
        return animalName;
    }
    
    public void feed() {
        lastMeal = LocalDateTime.now();
    }
}
