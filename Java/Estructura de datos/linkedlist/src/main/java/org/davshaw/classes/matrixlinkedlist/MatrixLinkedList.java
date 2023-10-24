package org.davshaw.classes.matrixlinkedlist;

import org.davshaw.classes.AllRouteList;
import org.davshaw.classes.Position;
import org.davshaw.classes.SingleRouteList;
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
    
    public boolean isValidPosition(int x, int y) {
        return this.isValidPosition(new Position(x, y));
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

    public void changeValueAt(int x, int y, String value) {
        this.changeValueAt(new Position(x, y), value);
    }

    public void graphicRoute(SingleRouteList route) {
        MatrixLinkedList copy = this;

        for (int i = 1; i < route.getSize()-1; i++) {
            Position currPosition = route.getNodeAtIndex(i);
            copy.changeValueAt(currPosition, String.valueOf(i));
            if (i == 0) {
                copy.changeValueAt(currPosition, "X");
            }

            if(i == route.getSize()) {
                copy.changeValueAt(currPosition, "Y");
            }

            else {
                copy.changeValueAt(currPosition, String.valueOf(i));
            }
        }
        copy.print();
    }

    public AllRouteList getAllRoutesXY(
        Position x,
        Position y,
        SingleRouteList path,
        AllRouteList routes) {

        boolean checkValid = this.isValidPosition(x);
        boolean checkVisited = !this.hasBeenVisited(x, path);
        boolean checkBlocked = !this.isBlocked(x);
        boolean checkArrive = !this.hasArrived(y,path);

        if (checkValid && checkVisited && checkBlocked && checkArrive) {

            SingleRouteList pathCopy = path.copy();
            pathCopy.addToTail(x);

            if (x.equals(y)) {

                SingleRouteList auxiliar = new SingleRouteList();
                auxiliar.addAll(pathCopy);
                routes.addToTail(auxiliar);
            } else {
                
                Position x1 = new Position(x.getX() + 1, x.getY());
                Position x2 = new Position(x.getX(), x.getY() + 1);
                Position y1 = new Position(x.getX() - 1, x.getY());
                Position y2 = new Position(x.getX(), x.getY() - 1);


                getAllRoutesXY(x1, y, pathCopy, routes);
                getAllRoutesXY(x2, y, pathCopy, routes);
                getAllRoutesXY(y1, y, pathCopy, routes);
                getAllRoutesXY(y2, y, pathCopy, routes);
            }
        }
        return routes;
    }

    public boolean hasArrived(Position position, SingleRouteList path) {
        return path.containsPosition(position);
    }

    public boolean hasArrived(int x, int y, SingleRouteList path) {
        return this.hasArrived(new Position(x, y), path);
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

    public DoubleLinkedList getFirstRow() {
        return this.getHead();
    }

    public SingleRouteList getLastRowPositions() {
        SingleRouteList path = new SingleRouteList();
        for (int i = 0; i < this.getLastRow().size(); i++) {
            Position current = new Position(this.getSize()-1, i);
            path.addToTail(current);
        }
        return path;
    }

    public SingleRouteList getFirstRowPositions() {
        SingleRouteList path = new SingleRouteList();
        for (int i = 0; i < this.getLastRow().size(); i++) {
            Position current = new Position(0, i);
            path.addToTail(current);
        }
        return path;
    }

    public DoubleLinkedList getLastRow() {
        return this.getRowAt(this.getSize()-1);
    }
    
    public boolean firstRowContains(SingleRouteList path) {
        DoubleLinkedList row = this.getFirstRow();
        
        for (int i = 0; i < row.size(); i++) {
            if (path.containsPosition(new Position(0, i))) {
                return true;
            }
        }
        return false;
    }

    public boolean lastRowContains(SingleRouteList path) {
        DoubleLinkedList row = this.getFirstRow();
        
        for (int i = 0; i < row.size(); i++) {
            if (path.containsPosition(new Position(i, this.getSize()-1))) {
                return true;
            }
        }
        return false;
    }

    public boolean canXWin() {
        return this.lastRowContains(this.getLastRowPositions());
    }

    public boolean canYWin() {
        return this.firstRowContains(this.getFirstRowPositions());
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
    
    public boolean isBlocked(int x, int y) {
        return this.isBlocked(new Position(x, y));
    }

    public boolean hasBeenVisited(Position position, SingleRouteList route) {
        return route.containsPosition(position);
    }



    public static void main(String[] args) {
        MatrixLinkedList matrix = new MatrixLinkedList();
        matrix.generateMatrix(3,3);

        Position x = new Position(0,0);
        Position y = new Position(2,2);

        matrix.changeValueAt(x, "X");
        matrix.changeValueAt(y, "Y");


        SingleRouteList p = new SingleRouteList();
        AllRouteList a = new AllRouteList();

        matrix.getAllRoutesXY(x, y, p, a);
        System.out.println(a);
    }

}
