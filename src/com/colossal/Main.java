package com.colossal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "Exit"));
        locations.put(1, new Location(1, "You are standing at the end of the road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of the hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addConnection("W", 2);
        locations.get(1).addConnection("E", 3);
        locations.get(1).addConnection("S", 4);
        locations.get(1).addConnection("N", 5);

        locations.get(2).addConnection("N", 5);

        locations.get(3).addConnection("W", 1);

        locations.get(4).addConnection("N", 1);
        locations.get(4).addConnection("W", 2);

        locations.get(5).addConnection("S", 1);
        locations.get(5).addConnection("W", 2);

        Map<String, String> vocab = new HashMap<>();
        vocab.put("QUIT", "Q");
        vocab.put("NORTH", "N");
        vocab.put("SOUTH", "S");
        vocab.put("WEST", "W");
        vocab.put("EAST", "E");

        int currentLocation = 1;
        while (true) {
            System.out.println(locations.get(currentLocation).getDesc());
            if (currentLocation == 0) {
                break;
            }
            Map<String, Integer> connections = locations.get(currentLocation).getConnections();
            System.out.print("Available Directions are ");
            for (String key: connections.keySet()) {
                System.out.print(key + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word: words) {
                    if (vocab.containsKey(word)) {
                        direction = vocab.get(word);
                        break;
                    }
                }
            }
            if (connections.containsKey(direction)) {
                currentLocation = connections.get(direction);
            }
            else {
                System.out.println("Wrong Direction");
            }
        }
    }
}
