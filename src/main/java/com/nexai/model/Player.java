package com.nexai.model;

import java.util.Objects;

public class Player {

    private String name;
    private int numberOfPoints;
    private int age;

    public Player(String name, int numberOfPoints, int age) {
        this.name = name;
        this.numberOfPoints = numberOfPoints;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", numberOfPoints=").append(numberOfPoints);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return numberOfPoints == player.numberOfPoints && age == player.age && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + numberOfPoints;
        result = 31 * result + age;
        return result;
    }
}
