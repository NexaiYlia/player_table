package com.nexai.service;

import com.github.javafaker.Faker;
import com.nexai.model.Player;

import java.util.List;
import java.util.Random;

public class PlayerTableCreator {

    public static List<Player> createListOfPlayers(List<Player> players, Faker faker, Random random) {

        for (int i = 0; i < 15000; i++) {
            String name = faker.name().fullName();
            int points = random.nextInt(150000) + 1;
            int age = random.nextInt(18, 55);
            players.add(new Player(name, points, age));
        }
        return players;
    }

    public static List<Player> sortListOfPlayers(List<Player> players) {

        players.sort((p1, p2) -> Integer.compare(p2.getNumberOfPoints(), p1.getNumberOfPoints()));
        return players;
    }
}

