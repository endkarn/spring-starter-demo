package com.example.demo.dto;

public class KeyMapModel {
    public String key;
    public String map;

    public KeyMapModel(String key, String map) {
        this.key = key;
        this.map = map;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
