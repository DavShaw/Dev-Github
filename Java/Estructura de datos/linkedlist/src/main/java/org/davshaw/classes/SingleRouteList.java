package org.davshaw.classes;

public class SingleRouteList {
    private Position head;
    private SingleRouteList next;

    public SingleRouteList() {
        head = null;
        next = null;
    }

    public int getSize() {
        int size = 0;
        Position current = this.head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
    
    public SingleRouteList copy() {
        SingleRouteList copiedList = new SingleRouteList();

        if (this.isEmpty()) {
            return copiedList;
        }
    
        Position current = this.getHead();
        while (current != null) {
            Position copiedNode = new Position(current.getX(), current.getY());
            copiedList.addToTail(copiedNode);
            current = current.getNext();
        }
    
        return copiedList;
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
    
    public boolean containsPosition(Position position) {
        Position current = head;
        while (current != null) {
            if (current.equals(position)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public void addToTail(Position newNode) {
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

    public void addToTail(int x, int y) {
        this.addToTail(new Position(x, y));
    }
    
    public void addAll(SingleRouteList otherList) {
        if (isEmpty()) {
            head = otherList.head;
        } else {
            Position current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(otherList.head);
        }
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
