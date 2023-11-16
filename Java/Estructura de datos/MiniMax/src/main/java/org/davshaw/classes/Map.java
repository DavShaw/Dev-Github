package org.davshaw.classes;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Map {

    private List<List<String>> map = new ArrayList<List<String>>();

    public Map(int size) {
        this.generateMap(size);
    }

    public List<List<String>> generateMap(int size) {
        
        for (int i = 0; i < size; i++) {

            List<String> row = new ArrayList<>();

            for (int j = 0; j < size; j++) {

                row.add(" ");

            }

            this.map.add(row);
        }
        
        return map;
    }
    
    public Integer getSize() {
        return this.map.size();
    }

    public int countMatchingCells(String cellName) {

        int counter = 0;    

        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.map.get(i).get(j).equals(cellName)) {
                    counter++;
                }
            }
        }
    
        return counter;
    }

    public int countVoidCells() {

        int counter = 0;    

        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.map.get(i).get(j).equals(" ")) {
                    counter++;
                }
            }
        }
    
        return counter;
    }

    public Map copy() {
        int size = this.getSize();
        Map copiedMap = new Map(size);
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String valueee = this.getCellData(i, j);
                copiedMap.changeCellData(i, j, valueee);
            }
        }
    
        return copiedMap;
    }
    
    // Has been overloaded
    public boolean isValidPosition(Position position) {

        int size = this.getSize();
        int x = position.getX();
        int y = position.getY();
    
        boolean checkX = x >= 0 && x < size;
        boolean checkY = y >= 0 && y < size;
    
        return checkX && checkY;
    }
    
    // Overloading
    public boolean isValidPosition(int x, int y) {
        return this.isValidPosition(new Position(x, y));
    }

    // Has been overloaded
    public void changeCellData(Position position, String data) {
        int x = position.getX();
        int y = position.getY();
        
        if (this.isValidPosition(x, y)) {
            this.map.get(x).set(y, data);
        }
    }
    
    // Overloading
    public void changeCellData(int x, int y, String data) {
        this.changeCellData(new Position(x, y), data);
    }

    // Has been overloaded
    public String getCellData(Position position) {
        if (this.isValidPosition(position)) {
            return this.map.get(position.getX()).get(position.getY());
        }
        return null;
    }

    // Overloading
    public String getCellData(int x, int y) {
        return this.getCellData(new Position(x, y));
    }

    public void view() {
        int size = this.getSize();
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.map.get(i).get(j));
                if (j < size - 1) {
                    System.out.print("    |    ");
                }
            }
            System.out.println();
    
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("========");
                }
                System.out.println();
            }
        }
    }
    
    public List<Position> getVoidCells() {

        List<Position> voidPositions = new ArrayList<Position>();

        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                
                if(this.getCellData(i, j).equals(" ")) {
                    voidPositions.add(new Position(i,j));
                }
            }
        }
        return voidPositions;
    }
    
}
