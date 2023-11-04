package org.davshaw.main;

import org.davshaw.classes.Map;
import org.davshaw.classes.Players;

public class Main {
    public static void main(String[] args) {

        Map gameZone = new Map(4);
        Players playerManager = new Players(gameZone);
        playerManager.setXAt(0, 0);
        playerManager.setOAt(1, 0);
        playerManager.setOAt(2, 0);
        playerManager.setXAt(2, 1);
        System.out.println(playerManager.whoIsNext());
        System.out.println("- - - - - -");
        playerManager.viewPlayers();
    }
}