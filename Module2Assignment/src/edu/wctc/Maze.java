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
                return "You are at the entrance of the maze. There's a passage to the east. Good luck on your travels!";
            }
        };

        Room hallway = new Room("Hallway") {
            @Override
            public String getDescription() {
                return "A long hallway with doors on either side. The air is cool.";
            }
        };

        TreasureRoom treasure = new TreasureRoom("Treasure Chamber", "Golden Chalice", 25);
        PuzzleRoom puzzle = new PuzzleRoom("Puzzle Alcove", "Ancient Coin", 5);
        SupplyRoom supply = new SupplyRoom("Supply Closet", "Rope", 3);
        ExitRoom exit = new ExitRoom("Outer Door", "Fresh air pours in from outside.");
        // Additional rooms
        RatDen ratDen = new RatDen("Rat Den", "Rat tail", -5);
        DeadEnd deadEnd = new DeadEnd("Dead End");
        MirrorRoom mirror = new MirrorRoom("Mirror Room", "Small diamond", 15);
        TrophyRoom trophy = new TrophyRoom("Trophy Room", "Jeweled Crown", 50);

        // Connect rooms
        // Changed the layout to create a more complex maze with more branching paths
        entrance.setEast(hallway);

        hallway.setWest(entrance);
        hallway.setEast(supply);
        hallway.setNorth(ratDen);
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

        ratDen.setSouth(hallway);
        ratDen.setEast(treasure);

        treasure.setWest(ratDen);
        treasure.setSouth(supply);
        treasure.setNorth(deadEnd);

        deadEnd.setSouth(treasure);

        supply.setNorth(treasure);
        supply.setWest(hallway);
        supply.setSouth(mirror);
        supply.setEast(exit);

        exit.setWest(supply);

        mirror.setNorth(supply);
        mirror.setSouth(puzzle);

        puzzle.setNorth(mirror);
        puzzle.setEast(trophy);

        trophy.setWest(puzzle);

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
