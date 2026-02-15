package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Maze!");

        while (!maze.isFinished()) {
            System.out.println();
            System.out.println(maze.getCurrentRoomDescription());
            System.out.println("Exits: " + maze.getCurrentRoomExits());
            System.out.print("Enter command (n/s/e/w/u/d to move, i=interact, l=loot, x=exit, v=inventory): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                System.out.println("No command entered.");
                continue;
            }
            char cmd = input.charAt(0);
            switch (cmd) {
                case 'n': case 's': case 'e': case 'w': case 'u': case 'd':
                    boolean moved = maze.move(cmd);
                    if (!moved) System.out.println("You can't move that way.");
                    break;
                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    System.out.println(maze.exitCurrentRoom());
                    break;
                case 'v':
                    System.out.println("Inventory: " + maze.getPlayerInventory());
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }

        System.out.println("Game over! Your final score is: " + maze.getPlayerScore());
        scanner.close();
    }
}
