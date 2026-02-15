package edu.wctc;

public class MirrorRoom extends Room implements Lootable, Interactable {
    private boolean looted = false;
    private boolean interacted = false;
    private String itemName;
    private int itemWorth;

    public MirrorRoom(String name, String itemName, int itemWorth) {
        super(name);
        this.itemName = itemName;
        this.itemWorth = itemWorth;
    }

    @Override
    public String getDescription() {
        return "You are in a room with large mirrors on the walls. Your reflection seems to be watching you.";
    }

    @Override
    public String loot(Player player) {
        if (looted) return "You've already discovered the hidden chest and looted it already. There's nothing left.";
        looted = true;
        player.addToInventory(itemName);
        player.addToScore(itemWorth);
        return "You push against one of the mirrors and it slides open, revealing a hidden chest. You open it and find: " + itemName + ". You gain " + itemWorth + " points.";
    }

    @Override
    public String interact(Player player) {
        if (interacted) return "You've already interacted with the mirrors. Your reflection seems to be calm now.";
        interacted = true;
        return "You stare into the mirrors and see your reflection. It seems to be mimicking";
    }
}
