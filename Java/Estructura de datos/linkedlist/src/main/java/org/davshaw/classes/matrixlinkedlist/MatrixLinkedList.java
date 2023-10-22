package org.davshaw.classes.matrixlinkedlist;

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
    
    public void showMatrix() {
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

    public Node getNodeAt(int row, int index) {
        return this.getRowAt(row).getNodeAt(index);
    }

    public void changeValueAt(int row, int index, String value) { 
        this.getNodeAt(row, index).setValue(value);
    }

    

    public static void main(String[] args) {
        MatrixLinkedList matrix = new MatrixLinkedList();
        matrix.generateMatrix(2, 2);
        matrix.changeValueAt(0, 0, "x");
        matrix.changeValueAt(1, 1, "y");
        matrix.showMatrix();
    }
    
}
