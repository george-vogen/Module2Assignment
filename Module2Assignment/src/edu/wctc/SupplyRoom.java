package edu.wctc;

public class SupplyRoom extends Room implements Lootable, Interactable {
    private boolean looted = false;
    private boolean interacted = false;
    private String supplyItem;
    private int supplyPoints;

    public SupplyRoom(String name, String supplyItem, int supplyPoints) {
        super(name);
        this.supplyItem = supplyItem;
        this.supplyPoints = supplyPoints;
    }

    @Override
    public String getDescription() {
        return "Shelves line the walls with various supplies. Some items might be useful.";
    }

    @Override
    public String loot(Player player) {
        if (looted) return "There's nothing left to loot here.";
        looted = true;
        player.addToInventory(supplyItem);
        player.addToScore(supplyPoints);
        return "You take: " + supplyItem + ". You gain " + supplyPoints + " points.";
    }

    @Override
    public String interact(Player player) {
        if (interacted) return "You've already rummaged through the supplies.";
        interacted = true;
        player.addToScore(2);
        return "You reorganize the supplies and find a small trinket. You gain 2 points.";
    }
}
