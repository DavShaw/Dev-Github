package org.davshaw.classes.external;

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

    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Position other = (Position) obj;
    return this.x == other.x && this.y == other.y;
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
