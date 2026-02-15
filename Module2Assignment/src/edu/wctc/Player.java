package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int score;
    private List<String> inventory;

    public Player() {
        score = 0;
        inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        if (item != null && !item.isEmpty()) {
            inventory.add(item);
        }
    }

    public void addToScore(int points) {
        score += points;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        }
        return String.join(", ", inventory);
    }

    public int getScore() {
        return score;
    }
}
