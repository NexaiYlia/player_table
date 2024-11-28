package com.nexai;

import com.github.javafaker.Faker;
import com.nexai.exception.CustomException;
import com.nexai.model.Player;
import com.nexai.service.ExcelFileCreator;
import com.nexai.service.PlayerTableCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random();

        List<Player> playersList = PlayerTableCreator.createListOfPlayers(players, faker, random);
        PlayerTableCreator.sortListOfPlayers(playersList);
        try {
            ExcelFileCreator.createFile(playersList);
        } catch (IOException e) {
            throw new CustomException("Input operation was failed");
        }

    }
}