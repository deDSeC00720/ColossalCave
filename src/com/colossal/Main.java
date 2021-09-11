package com.colossal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
//    private static final Map<Integer, Location> locations = new HashMap<>();
    private static final Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
