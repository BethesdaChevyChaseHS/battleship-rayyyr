package bcc.battleship;

public class Grid {
    
    private Location[][] grid;
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        grid = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j]= new Location();
            }
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
       grid[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        return !grid[row][col].isUnguessed();
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return grid[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return Constants.NUM_ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return Constants.NUM_COLS;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        //mark all locations the ship will take up and check if inbounds and no collision
        int h = 0;
        int v = 0;
        int row;
        int col;
        if(s.getDirection()==Constants.HORIZONTAL)
        {
            h = 1;
        }else{
            v=1;
        }
        for(int i = 0; i<s.getLength();i++)
        {
            row=s.getRow()+v*i;
            col=s.getCol()+h*i;
            if(row<Constants.NUM_ROWS && col<Constants.NUM_COLS && grid[row][col].hasShip()==false)
            {
                grid[row][col].setShip(true);
            }else
            {
                return false;
            }
        }
        return true;
    }

    public boolean allShipsSank(){
        for(int row = 0; row<Constants.NUM_ROWS; row++)
        {
            for(int col = 0; col<Constants.NUM_COLS; col++)
            {
                if (grid[row][col].hasShip()==true && grid[row][col].checkHit()==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
