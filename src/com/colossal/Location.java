package com.colossal;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String desc;
    private final Map<String, Integer> connections;

    public Location(int locationID, String desc) {
        this.locationID = locationID;
        this.desc = desc;
        connections = new HashMap<>();
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDesc() {
        return desc;
    }

    public Map<String, Integer> getConnections() {
        return connections;
    }
}
