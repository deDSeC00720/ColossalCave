package com.colossal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "Exit"));
        locations.put(1, new Location(1, "Location 1"));
        locations.put(2, new Location(2, "Location 2"));
        locations.put(3, new Location(3, "Location 3"));
        locations.put(4, new Location(4, "Location 4"));
        locations.put(5, new Location(5, "Location 5"));

        int currentLocation = 1;
        while (true) {
            System.out.println(locations.get(currentLocation).getDesc());
            if (currentLocation == 0) {
                break;
            }
            currentLocation = scanner.nextInt();
            if (!locations.containsKey(currentLocation)) {
                System.out.println("Wrong Input");
            }
        }
    }
}
