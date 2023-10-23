package org.davshaw.classes.matrixlinkedlist;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.classes.Position;
import org.davshaw.classes.doublelinkedlist.DoubleLinkedList;
import org.davshaw.classes.doublelinkedlist.Node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatrixLinkedList {
    
    private DoubleLinkedList head;

    public DoubleLinkedList getRowAt(int index) {

        if (index >= 0 && index < this.getSize()) {

            DoubleLinkedList current = this.getHead();
    
            for (int i = 0; i < index; i++) {
                if (current.getNext() != null) {
                    current = current.getNext();
                }
            }
            
            return (current != null) ? current : null;
        }
        return null;
    }

    public boolean isValidPosition(Position position) {
        if (this.getRowAt(0) != null) {
            return position.getX() >= 0 && position.getY() >= 0 &&
               position.getX() <= this.getSize() - 1 && position.getY() <= this.getRowAt(0).size() - 1;
        }
        return false;
    }
    
    public void moveFromTo(Position from, Position to) {
        try {
            if(!(this.isValidPosition(from))) {
                throw new IllegalArgumentException("Out of the range.");
            }

            if(!(this.isValidPosition(to))) {
                throw new IllegalArgumentException("Out of the range.");
            }

            if (this.isAnyPlayerThere(to)) {
                throw new IllegalArgumentException("Any one else is on that position");
            }

            Node nodeFrom = this.getNodeAt(from);
            Node nodeTo = this.getNodeAt(to);

            nodeTo.setValue(nodeFrom.getValue());
            nodeFrom.setValue(" ");

        }

        catch (IllegalArgumentException error) {
            System.out.println("FATAL ERROR: " + error.getMessage());
        }
    }

    public boolean isPlayerThere(Position position, String playerValue) {
        return this.getNodeAt(position).getValue().equals(playerValue);
    }

    public boolean isAnyPlayerThere(Position position) {
        return this.isPlayerThere(position, "x") || this.isPlayerThere(position, "y");
    }

    public int getSize() {
        int counter = 0;
        DoubleLinkedList current = this.getHead();
        while (current != null) {
            counter++;
            current = current.getNext();
        }
        return counter;
    }

    public int getRowsSize() {
        if (this.getSize() > 0) {
            return this.getRowAt(0).size();
        } 
        return 0;
    }

    public void addRow(String value) {
        DoubleLinkedList node = new DoubleLinkedList();
        node.addNodeAtTailAsList(value);
        if (this.getHead() == null) {
            this.setHead(node);
        }
        else {
            DoubleLinkedList current = this.getHead();
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }
    
    public void print() {
        this.showMatrix(this.getHead());
    }

    private void showMatrix(DoubleLinkedList row) {
        if (row != null) {
            System.out.println(row);
            this.showMatrix(row.getNext());
        }
        
    }

    public void generateMatrix(int rows, int columns) {
        this.clearMatrix();
    
        DoubleLinkedList currentRow = null;
        DoubleLinkedList prevRow = null;
    
        for (int i = 0; i < rows; i++) {
            DoubleLinkedList row = new DoubleLinkedList();
    
            for (int j = 0; j < columns; j++) {
                row.addNodeAtTail(" ");
            }
    
            if (prevRow != null) {
                prevRow.setNext(row);
                row.setPrev(prevRow);
            }
    
            if (currentRow == null) {
                this.setHead(row);
            }
    
            prevRow = row;
            currentRow = row;
        }
    }
    
    public void clearMatrix() {
        this.setHead(null);
    }

    public Node getNodeAt(Position position) {
        return this.getRowAt(position.getX()).getNodeAt(position.getY());
    }

    public void changeValueAt(Position position, String value) { 
        this.getNodeAt(position).setValue(value);
    }

    public Position getPlayerCoords(String playerValue) {

        DoubleLinkedList current = this.getHead();
        for (int i = 0; i < this.getSize(); i++) {

            if(current != null) {
                for(int j = 0; j < current.size(); j++) {
                    if (current.getNodeAt(j).getValue().equals(playerValue)) {
                        return new Position(i, j);
                    }
                }
                current = current.getNext();
            }
        }
        return null;
    }

    public boolean canWin(String playerValue) {
        return false;
    }
    
    public boolean isBlocked(Position position) {

        if (isValidPosition(position)) {

            Node node = this.getNodeAt(position);

            if (node != null) {
                return node.getValue().equals("#");
            }

        }
        return true;
    }
    
    public boolean hasBeenVisited(Position position, List<Position> route) {
        return route.contains(position);
    }

    public List<List<Position>> getRouteFromTo(List<Position> singleRoute,
    List<List<Position>> allRoute,
    Position start,
    Position end) {
        
    List<Position> currentRoute = new ArrayList<>(singleRoute);

    if ((!hasBeenVisited(start, currentRoute)) && (!isBlocked(start)) && (isValidPosition(start))) {
        currentRoute.add(start);

        // if start (next) position equals to the so we've finished 
        if (start.equals(end)) {
            allRoute.add(currentRoute);
        }
        
        else {
            // Increment x
            Position next1 = new Position(start.getX() + 1, start.getY());
            // Increment y
            Position next2 = new Position(start.getX(), start.getY() + 1);
            // Decrement x
            Position next3 = new Position(start.getX() - 1, start.getY());
            // Decrement y
            Position next4 = new Position(start.getX(), start.getY() - 1);

            getRouteFromTo(currentRoute, allRoute, next1, end);
            getRouteFromTo(currentRoute, allRoute, next2, end);
            getRouteFromTo(currentRoute, allRoute, next3, end);
            getRouteFromTo(currentRoute, allRoute, next4, end);
        }
    }

    return allRoute;
}


    public static void main(String[] args) {
        MatrixLinkedList matrix = new MatrixLinkedList();

        matrix.generateMatrix(3,3);
        matrix.print();

        List<Position> singleRoute = new ArrayList<Position>();
        List<List<Position>> allRoute = new ArrayList<List<Position>>();
        matrix.getRouteFromTo(singleRoute, allRoute, new Position(0, 0), new Position(2, 2));
        System.out.println(allRoute.get(0));


    }

}
