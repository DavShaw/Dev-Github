package org.davshaw.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {

    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.x, this.y);
    }
}
