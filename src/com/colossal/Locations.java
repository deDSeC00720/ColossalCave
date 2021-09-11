package com.colossal;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        FileWriter locationsFile = null;
        FileWriter connFile = null;
//        try {
//            locationsFile = new FileWriter("locations.txt");
//            connFile = new FileWriter("connections.txt");
//            for (Location location : locations.values()) {
//                locationsFile.write(location.getLocationID() + "," + location.getDesc() + "\n");
//                for (String connection : location.getConnections().keySet()) {
//                    connFile.write(location.getLocationID() + "," + connection + "," + location.getConnections().get(connection) + "\n");
//                }
//            }
//        } finally {
//            if (locationsFile != null) {
//                locationsFile.close();
//            }
//            if (connFile != null) {
//                connFile.close();
//            }
//        }
    }

    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int locationID = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String desc = scanner.nextLine();
                System.out.println(locationID + " " + desc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

//        locations.put(0, new Location(0, "Exit"));
//        locations.put(1, new Location(1, "You are standing at the end of the road before a small brick building"));
//        locations.put(2, new Location(2, "You are at the top of the hill"));
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
//        locations.put(4, new Location(4, "You are in a valley beside a stream"));
//        locations.put(5, new Location(5, "You are in the forest"));
//
//        locations.get(1).addConnection("W", 2);
//        locations.get(1).addConnection("E", 3);
//        locations.get(1).addConnection("S", 4);
//        locations.get(1).addConnection("N", 5);
//
//        locations.get(2).addConnection("N", 5);
//
//        locations.get(3).addConnection("W", 1);
//
//        locations.get(4).addConnection("N", 1);
//        locations.get(4).addConnection("W", 2);
//
//        locations.get(5).addConnection("S", 1);
//        locations.get(5).addConnection("W", 2);
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
