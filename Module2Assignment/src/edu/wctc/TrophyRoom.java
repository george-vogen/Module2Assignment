package edu.wctc;

public class TrophyRoom extends Room implements Lootable {
    private boolean looted = false;
    private String trophyName;
    private int trophyValue;

    public TrophyRoom(String name, String trophyName, int trophyValue) {
        super(name);
        this.trophyName = trophyName;
        this.trophyValue = trophyValue;
    }

    @Override
    public String getDescription() {
        if (!looted) {
            return "You have entered the Trophy Room. The walls are adorned with trophies and awards from past adventurers. There is a sense of accomplishment in the air. You see a magnificent trophy displayed on a pedestal in the center of the room. It looks like it holds great value.";
        } else {
            return "The Trophy Room is now empty, with the central trophy missing. The other trophies seem to be just for show, and you can't help but feel a sense of pride for having claimed the main prize.";
        }
    }

    @Override
    public String loot(Player player) {
        if (looted) return "You've already taken the trophy from this room. The other trophies seem to be just for show.";
        looted = true;
        player.addToInventory(trophyName);
        player.addToScore(trophyValue);
        return "You take the trophy: " + trophyName + ". You gain " + trophyValue + " points.";
    }
}
