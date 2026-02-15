package edu.wctc;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;

    public Maze() {
        player = new Player();

        // Create rooms
        Room entrance = new Room("Entrance") {
            @Override
            public String getDescription() {
                return "You are at the entrance of the maze. There's a passage to the east and a darker corridor to the south.";
            }
        };

        Room hallway = new Room("Hallway") {
            @Override
            public String getDescription() {
                return "A long hallway with doors on either side. The air is cool.";
            }
        };

        TreasureRoom treasure = new TreasureRoom("Treasure Chamber", "Golden Chalice", 10);
        PuzzleRoom puzzle = new PuzzleRoom("Puzzle Alcove", "Ancient Coin", 5);
        SupplyRoom supply = new SupplyRoom("Supply Closet", "Rope", 3);
        ExitRoom exit = new ExitRoom("Outer Door", "Fresh air pours in from outside.");

        // Connect rooms
        entrance.setEast(hallway);
        entrance.setSouth(puzzle);

        hallway.setWest(entrance);
        hallway.setEast(treasure);
        hallway.setUp(new Room("Attic") {
            @Override
            public String getDescription() {
                return "A dusty attic with cobwebs. There might be something here.";
            }
        });
        hallway.setDown(new Room("Basement") {
            @Override
            public String getDescription() {
                return "A damp basement. The smell is strong.";
            }
        });

        treasure.setWest(hallway);
        treasure.setSouth(exit);

        puzzle.setNorth(entrance);
        puzzle.setEast(supply);

        supply.setWest(puzzle);
        supply.setEast(exit);

        exit.setNorth(treasure);
        exit.setWest(supply);

        // Starting room
        currentRoom = entrance;
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            Exitable ex = (Exitable) currentRoom;
            isFinished = true;
            return ex.exit(player);
        }
        return "This room cannot be exited.";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            Interactable it = (Interactable) currentRoom;
            return it.interact(player);
        }
        return "There is nothing to interact with here.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            Lootable lo = (Lootable) currentRoom;
            return lo.loot(player);
        }
        return "There's nothing to loot here.";
    }

    public boolean move(char dir) {
        Room next = currentRoom.getAdjoiningRoom(dir);
        if (next != null) {
            currentRoom = next;
            return true;
        }
        return false;
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }
}
