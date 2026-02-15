package edu.wctc;

public class RatDen extends Room implements Lootable, Interactable {
    private boolean looted = false;
    private boolean interacted = false;
    private String itemName;
    private int itemWorth;

    public RatDen(String name, String itemName, int itemWorth) {
        super(name);
        this.itemName = itemName;
        this.itemWorth = itemWorth;
    }

    @Override
    public String getDescription() {
        return "You enter a dark, foul-smelling den filled with rats scurrying around.";
    }

    @Override
    public String loot(Player player) {
        if (looted) return "You've already looted this room. There's nothing left.";
        looted = true;
        player.addToInventory(itemName);
        player.addToScore(itemWorth);
        return "You manage to catch a rat and take its tail as a trophy; however, you feel a bit sick and lose " + Math.abs(itemWorth) + " points.";
    }

    @Override
    public String interact(Player player) {
        if (interacted) return "You've already interacted with the rats. They seem to have calmed down.";
        interacted = true;
        return "The rats hiss and scatter as you walk around. You feel uneasy.";
    }
}
