package org.davshaw.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private Position next;
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getNext() {
        return next;
    }

    public void setNext(Position next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %s)", this.getX(), this.getY());
    }
}
