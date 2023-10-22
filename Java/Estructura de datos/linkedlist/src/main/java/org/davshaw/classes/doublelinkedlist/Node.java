package org.davshaw.classes.doublelinkedlist;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node
{
    private String value;
    private Node next;
    private Node prev;
    private Node down;

    public Node(String value) {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.down = null;
    }

    public Node(int value) {
        this.value = String.valueOf(value);
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}