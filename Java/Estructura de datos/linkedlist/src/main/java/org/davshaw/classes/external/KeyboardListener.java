package org.davshaw.classes.external;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyboardListener implements KeyListener {
    private KeyEvent lastKeyEvent; // Store the last key event

    @Override
    public void keyTyped(KeyEvent e) {
        // You don't need to implement this in this case
    }

    @Override
    public void keyPressed(KeyEvent e) {
        lastKeyEvent = e; // Store the event for later use
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // You don't need to implement this in this case
    }

    // You can access the lastKeyEvent variable to retrieve the event
    public KeyEvent getLastKeyEvent() {
        return lastKeyEvent;
    }

    public static void main(String[] args) {
        KeyboardListener keyboard = new KeyboardListener();



        while (true) {
            if (keyboard.getLastKeyEvent() != null) {
                System.out.println(keyboard.getLastKeyEvent());
            }

        }
    }
}
