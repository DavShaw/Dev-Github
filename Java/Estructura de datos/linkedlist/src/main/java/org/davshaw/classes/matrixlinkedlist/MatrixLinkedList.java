package org.davshaw.classes.matrixlinkedlist;

import org.davshaw.classes.doublelinkedlist.DoubleLinkedList;
import org.davshaw.classes.doublelinkedlist.Node;
import org.davshaw.classes.external.AllRouteList;
import org.davshaw.classes.external.Position;
import org.davshaw.classes.external.SingleRouteList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatrixLinkedList {
    
    public DoubleLinkedList head;

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
        return this.isPlayerThere(position, "X") || this.isPlayerThere(position, "Y");
    }

    public SingleRouteList getFirstRowPositions() {
        SingleRouteList firstRow = new SingleRouteList();
        for (int i = 0; i < getRowsSize(); i++) {
            firstRow.addToTail(new Position(0, i));
        }
        return firstRow;
    }
    
    public SingleRouteList getLastRowPositions() {
        SingleRouteList lastRow = new SingleRouteList();
        int numRows = getSize();
        int numColumns = getRowsSize();
        for (int i = 0; i < numColumns; i++) {
            lastRow.addToTail(new Position(numRows - 1, i));
        }
        return lastRow;
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
    
    public void printList() {
        this.printList(this.getHead());
    }

    public void printList(DoubleLinkedList row) {
        if (row != null) {
            System.out.println(row);
            this.printList(row.getNext());
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

    public MatrixLinkedList copy() {
        MatrixLinkedList copy = new MatrixLinkedList();

        int rows = this.getSize();
        int columns = this.getRowsSize();
    
        copy.generateMatrix(rows, columns);
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Position currentPosition = new Position(i, j);
                String value = this.getNodeAt(currentPosition).getValue();
                copy.changeValueAt(currentPosition, value);
            }
        }
        return copy;
    }
    
    public void blockAt(Position position) {
        this.changeValueAt(position, "#");

        boolean checkPlayers = (position.equals(this.getXPosition())) || (position.equals(this.getYPosition()));

        if (!this.canBothWin() || checkPlayers) {
            this.changeValueAt(position, " ");
        }
    }

    public void setXPlayer() {
        this.changeValueAt(0,0,"X");
    }

    public void setYPlayer() {
        int numRows = this.getRowsSize();
        int numColumns = this.getSize();
        Position coords = new Position(numRows - 1, numColumns - 1);
        this.changeValueAt(coords, "Y");
    }
    
    public void moveXUp() {
        
        Position playerPosition = this.getXPosition();
        Position newPlayerPosition = new Position(playerPosition.getX() - 1, playerPosition.getY());

        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "X");
        }
    }

    public void moveXDown() {
        Position playerPosition = this.getXPosition();
        Position newPlayerPosition = new Position(playerPosition.getX() + 1, playerPosition.getY());
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "X");
        }
    }
    
    public void moveXLeft() {
        Position playerPosition = this.getXPosition();
        Position newPlayerPosition = new Position(playerPosition.getX(), playerPosition.getY() -1);
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "X");
        }
    }
    
    public void moveXRight() {
        Position playerPosition = this.getXPosition();
        Position newPlayerPosition = new Position(playerPosition.getX(), playerPosition.getY() +1);
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "X");
        }
    }
    
    public void moveYUp() {
        
        Position playerPosition = this.getYPosition();
        Position newPlayerPosition = new Position(playerPosition.getX() -1, playerPosition.getY());

        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "Y");
        }
    }

    public void moveYDown() {
        Position playerPosition = this.getYPosition();
        Position newPlayerPosition = new Position(playerPosition.getX() +1, playerPosition.getY());
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "Y");
        }
    }
    
    public void moveYLeft() {
        Position playerPosition = this.getYPosition();
        Position newPlayerPosition = new Position(playerPosition.getX(), playerPosition.getY() -1);
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "Y");
        }
    }
    
    public void moveYRight() {
        Position playerPosition = this.getYPosition();
        Position newPlayerPosition = new Position(playerPosition.getX(), playerPosition.getY() +1);
    
        // Check if the new position is valid
        if (this.isValidPosition(newPlayerPosition) && !this.isBlocked(newPlayerPosition)) {
            this.changeValueAt(playerPosition, " ");
            this.changeValueAt(newPlayerPosition, "Y");
        }
    }
    
    public Position getXPosition() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getRowsSize(); j++) {
                if (this.isPlayerThere(new Position(i, j), "X")) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    public Position getYPosition() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getRowsSize(); j++) {
                if (this.isPlayerThere(new Position(i, j), "Y")) {
                    return new Position(i, j);
                }
            }
        }
        return null;
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
        MatrixLinkedList copy = this.copy();

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
        copy.printList();
    }

    public AllRouteList getAllRouteFromTo(Position from, Position to) {
        SingleRouteList p = new SingleRouteList();
        AllRouteList a = new AllRouteList();

        return this.getAllRouteFromTo(from, to, p, a);
    }

    public AllRouteList getAllRouteFromTo(
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


                getAllRouteFromTo(x1, y, pathCopy, routes);
                getAllRouteFromTo(x2, y, pathCopy, routes);
                getAllRouteFromTo(y1, y, pathCopy, routes);
                getAllRouteFromTo(y2, y, pathCopy, routes);
            }
        }
        return routes;
    }

    public boolean hasArrived(Position position, SingleRouteList path) {
        return path.containsPosition(position);
    }

    public boolean canXWin() {
        Position x = this.getXPosition();
        SingleRouteList lastRow = this.getLastRowPositions();

        for (int i = 0; i < lastRow.getSize(); i++) {

            Position y = lastRow.getNodeAtIndex(i);
            AllRouteList route = this.getAllRouteFromTo(x, y);

            for (int j = 0; j < route.getSize(); j++) {
                
                SingleRouteList currentPath = route.getNodeAtIndex(j);

                if (currentPath.containsPosition(y)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean canYWin() {
        Position y = this.getYPosition();
        SingleRouteList firstRow = this.getFirstRowPositions();
    
        for (int i = 0; i < firstRow.getSize(); i++) {
            Position x = firstRow.getNodeAtIndex(i);
            AllRouteList route = this.getAllRouteFromTo(x, y);
    
            for (int j = 0; j < route.getSize(); j++) {
                SingleRouteList currentPath = route.getNodeAtIndex(j);
                if (currentPath.containsPosition(x)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean canBothWin() {
        return this.canXWin() && canYWin();
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
    
    public boolean hasBeenVisited(Position position, SingleRouteList route) {
        return route.containsPosition(position);
    }

}
