package org.davshaw.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.getX(), this.getY());
    }
}
