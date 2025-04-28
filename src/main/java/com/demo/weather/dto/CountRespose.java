package com.demo.weather.dto;

public class CountRespose {
    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CountRespose(int count, String name) {
        this.count = count;
        this.name = name;
    }
}
