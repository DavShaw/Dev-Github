package org.davshaw.classes.external;

public class AllRouteList {
    private SingleRouteList head;

    public AllRouteList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public SingleRouteList getNodeAtIndex(int index) {
        SingleRouteList current = head;
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
    
    public int getSize() {
        int count = 0;
        SingleRouteList current = head;
        
        while (current != null) {
            count++;
            current = current.getNext();
        }
        
        return count;
    }
    
    public void addToTail(SingleRouteList route) {
        if (isEmpty()) {
            head = route;
        } else {
            SingleRouteList current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(route);
        }
    }
    
    public void printList() {
        System.out.println(this);
    }

    // By ChatGPT
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        SingleRouteList current = head;
        while (current != null) {
            result.append("{ ");
            result.append(current.toString());
            result.append(" }");
            if (current.getNext() != null) {
                result.append(" ==> ");
            }
            current = current.getNext();
        }
        return result.toString();
    }


}
