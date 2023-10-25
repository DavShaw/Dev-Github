package org.davshaw.classes.Game;

import java.util.Random;

import org.davshaw.classes.external.ColorConsole;
import org.davshaw.classes.external.Position;
import org.davshaw.classes.matrixlinkedlist.MatrixLinkedList;
import java.util.Scanner;

public class ToucheTheEdge {

    private int size = 0;
    private MatrixLinkedList map;
    private Scanner read = new Scanner(System.in);
    private boolean randomBlock;

    public ToucheTheEdge(int size) {
        this.size = size;
        this.gameSetUp();
        this.randomBlock = true;
    }

    public ToucheTheEdge(int size, boolean randomBlock) {
        this.size = size;
        this.gameSetUp();
        this.randomBlock = randomBlock;

    }

    private void gameSetUp() {
        
        // Creating map
        this.map = new MatrixLinkedList();
        this.map.generateMatrix(this.size, this.size);

        // Appearing the players
        this.map.setXPlayer();
        this.map.setYPlayer();        
    }

    public void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
    
            if (os.contains("win")) {
                // Para Windows
                ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "cls");
                builder.inheritIO();
                Process process = builder.start();
                process.waitFor();
            } else {
                // Para sistemas Unix y Linux
                ProcessBuilder builder = new ProcessBuilder("clear");
                builder.inheritIO();
                Process process = builder.start();
                process.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveX(String direction) {

        direction = direction.toUpperCase();

        switch (direction) {
            case "UP":
                this.map.moveXUp();
                break;

            case "DOWN":
                this.map.moveXDown();
                        break;

            case "LEFT":
                this.map.moveXLeft();
                break;

            case "RIGHT":
                this.map.moveXRight();
                        break;

            case "U":
                this.map.moveXUp();
                break;

            case "D":
                this.map.moveXDown();
                        break;

            case "L":
                this.map.moveXLeft();
                break;

            case "R":
                this.map.moveXRight();
                        break;

            default:
                break;
        }
    }

    public void moveY(String direction) {

        direction = direction.toUpperCase();

        switch (direction) {
            case "UP":
                this.map.moveYUp();
                break;

            case "DOWN":
                this.map.moveYDown();
                        break;

            case "LEFT":
                this.map.moveYLeft();
                break;

            case "RIGHT":
                this.map.moveYRight();
                        break;

            case "U":
                this.map.moveYUp();
                break;

            case "D":
                this.map.moveYDown();
                        break;

            case "L":
                this.map.moveYLeft();
                break;

            case "R":
                this.map.moveYRight();
                        break;

            default:
                break;
        }
    }

    public void blockingAt(int x, int y) {
        this.map.blockAt(new Position(x, y));
    }

    public String selectRandomPlayer() {

        Random random = new Random();
        int randomNumber = random.nextInt(2);

        if (randomNumber == 0) {
            return "X";
        }
        return "Y";

    }

    public void announcePlayerTurn(String playerName) {

        String[] messages = {
            "Oh, yes, now it's your turn to make a wonderful move. -> %s",
            "It's the player's turn! What move will they make? -> %s",
            "All eyes are on the next move. Their time to shine. -> %s",
            "Get ready to see what's in store for us. -> %s",
            "A strategic masterstroke awaits us. -> %s",
            "Watch out for the next move. It's bound to be epic. -> %s",
            "Our tactical genius is up next. -> %s",
            "A brilliant move is coming up. -> %s",
            "Hold onto your seats! The move is on the horizon. -> %s",
            "Time to work some magic. -> %s"
        };
        
        

        Random random = new Random();
        int index = random.nextInt(messages.length);
        String message = ColorConsole.colorize(messages[index], "yellow");
        System.out.println(
            String.format(
                ColorConsole.colorize("(NARRATOR) ", "blue") 
                + message, ColorConsole.colorize(playerName, "red")));
    }

    public void askingForMoving(String player) {
        
        System.out.print(ColorConsole.colorize("(GAME) Let's moving! (UP, DOWN, LEFT, RIGHT): ", "magenta"));
        String direction = this.read.nextLine();
        
        if (player.equals("X")) {
            this.moveX(direction);
        }

        else if (player.equals("Y")) {
            this.moveY(direction);
        }
    }

    public void askingForBlocking() {
        System.out.println(ColorConsole.colorize("(GAME) Let's blocking! (x,y)\n", "cyan"));
        try {
            System.out.print("For x: ");
            int x = this.read.nextInt();
            System.out.print("For y: ");
            int y = this.read.nextInt();
            this.map.blockAt(new Position(x, y));
        } 
        catch (Exception e) {
            // Do nothing, just prevent the error
        }
    }

    public boolean canPlayerBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void passNextPlayer() {
        System.out.println("Your turn is over... Let's know who is the next player!");
        System.out.println("PRESS ENTER TO CONTINUE");
        this.read.nextLine();
    }

    public void space() {
        System.out.println("");
    }

    public void play() {

        while (true) {

            // Select random player
            String currentPlayer = this.selectRandomPlayer();

            // Print map
            this.map.printList();
            this.space();

            // Announce the player
            this.announcePlayerTurn(currentPlayer);
            this.space();

            // Ask for moving 
            this.askingForMoving(currentPlayer);
            this.space();

            // Blocking time
            if (this.randomBlock) {
                // If universe allows player to blocking, let's blocking the map!
                if (this.canPlayerBlock()) {
                    askingForBlocking();
                }
            }
            else {
                askingForBlocking();
            }

            // Next player
            this.passNextPlayer();
            this.space();
            this.clearScreen();
        }

    }
}
