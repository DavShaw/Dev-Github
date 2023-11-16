package org.davshaw.classes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Players {

    /*
     * 
     * X -> Jugador humano (-1)
     * O -> Máquina (1)
     * 
    */


    // Singleton
    private static Players instance = null;
    private Map map;

    public static Players getInstance() {
        if (instance == null) {
            instance = new Players();
        }
        return instance;
    }

    private Players() {
    }

    private void setPlayerAt(String player, Position position) {
        this.map.changeCellData(position, player);
    }

    public void setXAt(Position position) {
        this.setPlayerAt("X", position);
    }

    public void setXAt(int x, int y) {
        this.setPlayerAt("X", new Position(x, y));
    }

    public void setOAt(Position position) {
        this.setPlayerAt("O", position);
    }

    public void setOAt(int x, int y) {
        this.setPlayerAt("O", new Position(x, y));
    }

    public String getPlayerAt(Position position) {
        return this.map.getCellData(position);
    }

    public String getPlayerAt(int x, int y) {
        return this.map.getCellData(new Position(x, y));
    }

    public void viewPlayers() {
        this.map.view();
    }

    public int countX() {
        return this.map.countMatchingCells("X");
    }

    public int countO() {
        return this.map.countMatchingCells("O");
    }

    public String whoIsNext() {
        if (this.countX() == this.countO()) {
            return "X";
        }
        return "O";
    }


}
