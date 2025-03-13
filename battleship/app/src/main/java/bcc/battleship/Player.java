package bcc.battleship;
import bcc.battleship.Constants;

public class Player {

    private Ship[] ships = new Ship[5];
    private Grid myGrid = new Grid();
    private Grid oppGrid = new Grid();
    // Constructor: Initialize the grids and the ships.
    public Player() {
        for(int i = 0; i<5;i++)
        {
            ships[i] = new Ship(Constants.SHIP_LENGTHS[i]);
        }
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        ships[index].setDirection(direction);
        ships[index].setLocation(row,col);
        if(myGrid.addShip(ships[index])==true)
        {
            return true;
        }
        return false;
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if(myGrid.get(row, col).hasShip()==true)
        {
            myGrid.get(row, col).markHit();
            return true;
        }
        myGrid.get(row,col).markMiss();
        return false;
    }
    
    
    public Grid getMyGrid() {
        return myGrid;
    }
    
    public Grid getOpponentGrid() {
        return oppGrid;
    }
}
