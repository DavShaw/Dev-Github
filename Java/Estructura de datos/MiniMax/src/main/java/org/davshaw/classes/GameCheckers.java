package org.davshaw.classes;

import java.util.ArrayList;
import java.util.List;

public class GameCheckers {

    public void setX(Map state, Position position) {

        // Checking if position is valid!
        if(state.isValidPosition(position)) {
            state.changeCellData(position, "X");
        }
    }

    public void setO(Map state, Position position) {

        // Checking if position is valid!
        if(state.isValidPosition(position)) {
            state.changeCellData(position, "O");
        }
    }

    // Overloaded
    public void setX(Map state, int x, int y) {
        this.setX(state, new Position(x, y));
    }

    // Overloaded
    public void setO(Map state, int x, int y) {
        this.setO(state, new Position(x, y));
    }

    public Integer countX(Map state) {

        Integer total = 0;

        for (int i = 0; i < state.getSize(); i++) {
            
            for (int j = 0; j < state.getSize(); j++) {
                
                Position cell = new Position(i,j);
                if(state.isValidPosition(cell)) {
                    if(state.getCellData(cell).equals("X")) {
                        total++;
                    }
                }

            }

        }
        return total;
    }

    public Integer countO(Map state) {

        Integer total = 0;

        for (int i = 0; i < state.getSize(); i++) {
            
            for (int j = 0; j < state.getSize(); j++) {
                
                Position cell = new Position(i,j);
                if(state.isValidPosition(cell)) {
                    if(state.getCellData(cell).equals("O")) {
                        total++;
                    }
                }

            }

        }
        return total;
    }

    public Integer countVoid(Map state) {
        return (state.getSize() * state.getSize()) - (this.countX(state)) - (this.countO(state));
    }

    // Will be overloaded!
    private boolean hasAnyWon(Map state, String playerValue) {
        for (int i = 0; i < state.getSize(); i++) {
            for (int j = 0; j < state.getSize(); j++) {

                

            }
        }
        return false;
    }
    

    private boolean hasXWon(Map state) {
        return this.hasAnyWon(state, "X");
    }

    private boolean hasOWon(Map state) {
        return this.hasAnyWon(state, "O");
    }

    public int value(Map state) {

        if (this.hasOWon(state)) {
            return 1;
        }

        if (this.hasXWon(state)) {
            return -1;
        }
        return 0;
    }

    public boolean terminal(Map state) {
        return (this.hasOWon(state) || this.hasXWon(state));
    }

    public String player(Map state) {

        Integer xCount = this.countX(state);
        Integer oCount = this.countO(state);

        return (xCount <= oCount) ? "X" : "O";
    }

    public List<Position> actions(Map state) {
        
        List<Position> actions = new ArrayList<Position>();

        for (int i = 0; i < state.getSize(); i++) {
            for (int j = 0; j < state.getSize(); j++) {
                
                Position current = new Position(i,j);
                boolean isValid = state.isValidPosition(current);
                boolean isEqual = state.getCellData(current).equals(" ");
                
                if(isEqual && isValid) {
                    actions.add(current);
                }

            }
        }
        return actions;
    }

    public Map result(Map state, Position action, String player) {
        Map stateResult = state.copy();
        System.out.println("El moviento a evaluar es:");
        System.out.println(action);
    
        if (player.equals("X")) {
            this.setX(stateResult, action);
        }
        
        else if (player.equals("O")) {
            this.setO(stateResult, action);
        }
        System.out.println("- - - - - - ");
        stateResult.view();
        return stateResult;
    }
    
    public Integer miniMax(Map state) {
        if (this.terminal(state)) {
            return this.value(state);
        }
    
        // Jugador AI (Max)
        if (this.player(state).equals("O")) {
            Integer bestValue = Integer.MIN_VALUE;
    
            for (Position movement : this.actions(state)) {
                Map nextState = this.result(state, movement, "O");
                Integer value = miniMax(nextState);
                bestValue = Math.max(bestValue, value);
            }
            return bestValue;
        }
    
        // Jugador Humano (Min)
        if (this.player(state).equals("X")) {
            Integer bestValue = Integer.MAX_VALUE;
    
            for (Position movement : this.actions(state)) {
                Map nextState = this.result(state, movement, "X");
                Integer value = miniMax(nextState);
                bestValue = Math.min(bestValue, value);
            }
            return bestValue;
        }
    
        return null;
    }
    


    public static void main(String[] args) {
        
        Map state = new Map(4);
        GameCheckers gameManager = new GameCheckers();


        state.changeCellData(0, 3, "O");
        state.changeCellData(1, 1, "O");
        state.changeCellData(3, 1, "O");
        state.changeCellData(2, 1, "X");
        state.changeCellData(1, 3, "O");
        state.changeCellData(3, 2, "O");
        state.changeCellData(0, 1, "O");
        state.changeCellData(2, 2, "O");



        state.changeCellData(0, 0, "X");
        
        state.changeCellData(0, 2, "X");
        

        state.changeCellData(1, 0, "O");
        
        state.changeCellData(1, 2, "X");
        

        state.changeCellData(2, 0, "X");
        
        
        state.changeCellData(2, 3, "X");

        state.changeCellData(3, 0, "X");
        
        
        state.changeCellData(3, 3, "O");



        state.view();

        System.out.println(gameManager.terminal(state));


    }



}