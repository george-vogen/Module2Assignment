package edu.wctc;

public class TreasureRoom extends Room implements Lootable {
    private boolean looted = false;
    private String treasureName;
    private int treasureValue;

    public TreasureRoom(String name, String treasureName, int treasureValue) {
        super(name);
        this.treasureName = treasureName;
        this.treasureValue = treasureValue;
    }

    @Override
    public String getDescription() {
        if (!looted) {
            return "You see a glittering chest in the center of the room.\n" +
                    "It looks like it might contain something valuable.";
        } else {
            return "The empty chest sits in the center of the room, its contents gone.";
        }
    }

    @Override
    public String loot(Player player) {
        if (looted) {
            return "You already looted the treasure here.";
        }
        looted = true;
        player.addToInventory(treasureName);
        player.addToScore(treasureValue);
        return "You open the chest and find: " + treasureName + ". You gain " + treasureValue + " points.";
    }
}
