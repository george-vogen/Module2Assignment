package edu.wctc;

public class PuzzleRoom extends Room implements Interactable {
    private boolean solved = false;
    private String reward;
    private int rewardPoints;

    public PuzzleRoom(String name, String reward, int rewardPoints) {
        super(name);
        this.reward = reward;
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String getDescription() {
        if (!solved) {
            return "You enter a room with strange markings on the wall. There appears to be a puzzle to solve.";
        } else {
            return "The puzzle's markings have been altered, and a small compartment is open.";
        }
    }

    @Override
    public String interact(Player player) {
        if (solved) {
            return "You've already solved the puzzle here.";
        }
        solved = true;
        player.addToInventory(reward);
        player.addToScore(rewardPoints);
        return "You solve the puzzle and discover: " + reward + ". You gain " + rewardPoints + " points.";
    }
}
