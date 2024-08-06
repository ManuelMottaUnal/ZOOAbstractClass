/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.zoologico.model.table;

import com.unal.zoologico.model.Cage;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author manuel
 */
public class CageTableModel extends AbstractTableModel {
    private final List<Cage> cages;
    private final String[] columnNames = {"Capacidad", "Cantidad actual", "Estado"};

    public CageTableModel(List<Cage> cages) {
        this.cages = cages;
    }
    

    @Override
    public int getRowCount() {
        return cages.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cage cage = cages.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cage.getAnimalCapacity();
            case 1 -> cage.getAnimalCount();
            case 2 -> cage.getStatusCleaning();
            default -> null;
        };
    }
    
    public Cage getObjectAt(int rowIndex) {
        return cages.get(rowIndex);
    }
    
}
