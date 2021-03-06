package com.colossal;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedWriter locationsFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter connFile = new BufferedWriter(new FileWriter("connections.txt"))) {
            for (Location location : locations.values()) {
                locationsFile.write(location.getLocationID() + "," + location.getDesc() + "\n");
                for (String connection : location.getConnections().keySet()) {
                    if (!connection.equalsIgnoreCase("Q")) {
                        connFile.write(location.getLocationID() + "," + connection + "," + location.getConnections().get(connection) + "\n");
                    }
                }
            }
        }
    }

    static {
        try (BufferedReader locationsFile = new BufferedReader(new FileReader("locations_big.txt"))) {
            String line;
            while ((line = locationsFile.readLine()) != null) {
                System.out.println(line);
                String[] data = line.split(",");
                int locationID = Integer.parseInt(data[0]);
                String desc = data[1];
                locations.put(locationID, new Location(locationID, desc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader connFile = new BufferedReader(new FileReader("connections_big.txt"))) {
            String line;
            while ((line = connFile.readLine()) != null) {
                System.out.println(line);
                String[] data = line.split(",");
                int locationID = Integer.parseInt(data[0]);
                String direction = data[1];
                int connectionID = Integer.parseInt(data[2]);

                locations.get(locationID).addConnection(direction, connectionID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        locations.putAll(m);
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
