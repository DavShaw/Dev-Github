package org.davshaw.classes;

public class AllRouteList {
    private SingleRouteList head;

    public AllRouteList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
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

    public SingleRouteList removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        SingleRouteList removedRoute = head;
        head = head.getNext();
        return removedRoute;
    }

    public void printList() {
        SingleRouteList current = head;
        while (current != null) {
            current.printList();
            current = current.getNext();
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        SingleRouteList current = head;
        while (current != null) {
            result.append(current.toString());
            if (current.getNext() != null) {
                result.append(" -> ");
            }
            current = current.getNext();
        }
        return result.toString();
    }


    public static void main(String[] args) {
        SingleRouteList l = new SingleRouteList();
        l.addToTail(0, 0);
        l.addToTail(1, 2);

        SingleRouteList l2 = new SingleRouteList();
        l2.addToTail(56, 62);
        l2.addToTail(11, 21);

        AllRouteList r = new AllRouteList();
        r.addToTail(l);
        r.addToTail(l2);
        System.out.println(r);
    }
}
