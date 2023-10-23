package org.davshaw.classes;

public class SingleRouteList {
    private Position head;
    private SingleRouteList next;

    public SingleRouteList() {
        head = null;
        next = null;
    }

    public Position getHead() {
        return head;
    }

    public void setHead(Position head) {
        this.head = head;
    }

    public SingleRouteList getNext() {
        return next;
    }

    public void setNext(SingleRouteList next) {
        this.next = next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Position getNodeAtIndex(int index) {
        Position current = head;
        int currentIndex = 0;
    
        while (current != null) {
            if (currentIndex == index) {
                return current;
            }
            currentIndex++;
            current = current.getNext();
        }
        return null;
    }
    

    public void addToTail(int x, int y) {
        Position newNode = new Position(x, y);
        if (isEmpty()) {
            head = newNode;
        } else {
            Position current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Position removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        Position removedNode = head;
        head = head.getNext();
        return removedNode;
    }

    public void printList() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Position current = head;
        while (current != null) {
            result.append(current.toString());
            if (current.getNext() != null) {
                result.append(" -> ");
            }
            current = current.getNext();
        }
        return result.toString();
    }
}
