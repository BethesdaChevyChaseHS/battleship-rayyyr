package bcc.battleship;

public class Ship {

    private int row = UNSET;
    private int col = UNSET;
    private int direction = UNSET;
    private int length;
    // Constructor. Create a ship and set the length.
    public Ship(int length) {
        this.length = length;
    }

    // Has the location been initialized
    public boolean isLocationSet() {
        if (row != UNSET)
        {
            return true;
        }
        return false;
    }

    // Has the direction been initialized
    public boolean isDirectionSet() {
        if (direction != UNSET)
        {
            return true;
        }
        return false;
    }

    // Set the location of the ship
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Set the direction of the ship
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Getter for the row value
    public int getRow() {
        return row;
    }

    // Getter for the column value
    public int getCol() {
        return col;
    }

    // Getter for the length of the ship
    public int getLength() {
        return length;
    }

    // Getter for the direction
    public int getDirection() {
        return direction;
    }

    // Helper method to get a string value from the direction
    // Helper method to get a string value from the direction
    private String directionToString() {
        return direction;
    }

    // Helper method to get a (row, col) string value from the location
    private String locationToString() {
        if (row != UNSET)
        {
            return "(" + row + ", " + col + ")";
        }
        return "(unset location";
    }

    // toString value for this Ship
    @Override
    public String toString() {
        return directionToString() + "ship of length " + length + " at " + locationToString();
    }
}
