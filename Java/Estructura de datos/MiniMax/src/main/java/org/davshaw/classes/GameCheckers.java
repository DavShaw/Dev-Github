package org.davshaw.classes;

import java.util.ArrayList;
import java.util.Arrays;
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

                Position current = new Position(i, j);

                if (state.isValidPosition(current) && 
                    state.getCellData(current).equals(playerValue)) {

                    current.setX(current.getX() + 1);
                    
                    if (state.isValidPosition(current) && 
                    state.getCellData(current).equals(playerValue)) {

                        current.setY(current.getY() + 1);

                        if (state.isValidPosition(current) && 
                        state.getCellData(current).equals(playerValue)) {
                            return true;
                        }

                    }

                }

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

    public Integer value(Map state) {

        if (this.hasOWon(state)) {
            return 1;
        }

        else if (this.hasXWon(state)) {
            return -1;
        }
        
        else if (this.countVoid(state) == 0) {
            return 0;
        }
        return null;
    }

    public boolean terminal(Map state) {
        return (this.hasOWon(state) || this.hasXWon(state));
    }

    public String player(Map state) {
        Integer xCount = this.countX(state);
        Integer oCount = this.countO(state);

        if (xCount == 0 && oCount == 0) {
            return "X";
        }
        
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

    public Map result(Map state, Position action) {
        Map stateCopied = state.copy();
        String player = this.player(state);

        if (player.equals("X")) {
            this.setX(stateCopied, action);
        }
        
        else if (player.equals("O")) {
            this.setO(stateCopied, action);
        }
        return stateCopied;
    }

    // By me
    public Integer miniMax(Map state) {

        if(this.terminal(state)) {
            return this.value(state);
        }

        if (this.player(state).equals("O")) {

            Integer value = -9999999;

            for (Position action : this.actions(state)) {
                this.result(state, action).view();
                value = Math.max(value, this.miniMax(this.result(state, action)));

            }
            return value;
        }

        if (this.player(state).equals("X")) {

            Integer value = 9999999;

            for (Position action : this.actions(state)) {
                this.result(state, action).view();
                value = Math.min(value, this.miniMax(this.result(state, action)));
            }
            return value;
        }
        return null;
    }



    public static void main(String[] args) {
        
        Map map = new Map(4);
        GameCheckers gameManager = new GameCheckers();


        String[][] matriz = {
            // 3 x
            // 3 O
            {"O", "O", " ", "X"},
            {"O", " ", "O", "O"},
            {" ", "X", "O", " "},
            {"O", "X", " ", " "}};

        // Convierte la matriz en una lista de listas
        List<List<String>> listaDeListas = new ArrayList<>();
        for (String[] fila : matriz) {
            listaDeListas.add(Arrays.asList(fila));
        }

        map.setMap(listaDeListas);

        map.view();

        System.out.println(gameManager.miniMax(map));
        

    }
    


}



/*

public Integer miniMax(Map state) {

        if(this.terminal(state)) {
            return this.value(state);
        }

        // La máquina (+)
        if (this.player(state).equals("O")) {

            Integer value = -9999999;

            for (Position action : this.actions(state)) {
                value = Math.max(value, this.miniMax(this.result(state, action, "O")));
            }
            return value;
        }

        if (this.player(state).equals("X")) {

            Integer value = 9999999;

            for (Position action : this.actions(state)) {
                value = Math.min(value, this.miniMax(this.result(state, action, "X")));
            }
            return value;
        }
        return null;
    }
    


    public static void main(String[] args) {
        
        Map state = new Map(4);
        GameCheckers gameManager = new GameCheckers();
        
        String[][] matriz = {
        {" ", " ", " ", " "},
        {"O", " ", "X", "X"},
        {"O", " ", " ", " "},
        {" ", "X", " ", " "}};

        // Convierte la matriz en una lista de listas
        List<List<String>> listaDeListas = new ArrayList<>();
        for (String[] fila : matriz) {
            listaDeListas.add(Arrays.asList(fila));
        }

        state.setMap(listaDeListas);



        System.out.println("-------------------------------------");
        state.view();
        System.out.println("-------------------------------------");
        System.out.println(gameManager.player(state));
        System.out.println("-------------------------------------");
        System.out.println(gameManager.miniMax(state));
        System.out.println("-------------------------------------");
        


    }




*/