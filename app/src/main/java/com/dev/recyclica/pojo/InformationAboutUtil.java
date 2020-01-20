package com.dev.recyclica.pojo;

public class InformationAboutUtil {
    private String name;
    private int points;
    private int shipCounts;

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setShipCounts(int shipCounts) {
        this.shipCounts = shipCounts;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getShipCounts() {
        return shipCounts;
    }

    public InformationAboutUtil(String name, int points, int shipCounts) {
        this.name = name;
        this.points = points;
        this.shipCounts = shipCounts;
    }
}
