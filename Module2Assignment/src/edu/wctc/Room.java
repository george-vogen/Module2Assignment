package edu.wctc;

public abstract class Room {
    public String name;
    public Room north;
    public Room south;
    public Room east;
    public Room west;
    public Room up;
    public Room down;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char dir) {
        switch (Character.toLowerCase(dir)) {
            case 'n': return north;
            case 's': return south;
            case 'e': return east;
            case 'w': return west;
            case 'u': return up;
            case 'd': return down;
            default: return null;
        }
    }

    public String getExits() {
        StringBuilder sb = new StringBuilder();
        if (north != null) sb.append("n ");
        if (south != null) sb.append("s ");
        if (east != null) sb.append("e ");
        if (west != null) sb.append("w ");
        if (up != null) sb.append("u ");
        if (down != null) sb.append("d ");
        String exits = sb.toString().trim();
        return exits.isEmpty() ? "No exits." : exits;
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char dir) {
        return getAdjoiningRoom(dir) != null;
    }

    public void setNorth(Room r) { this.north = r; }
    public void setSouth(Room r) { this.south = r; }
    public void setEast(Room r) { this.east = r; }
    public void setWest(Room r) { this.west = r; }
    public void setUp(Room r) { this.up = r; }
    public void setDown(Room r) { this.down = r; }
}
