package com.elwonder.xo.model;

public class Game {
    private final Field field;
    private final  Player[] players;
    private final String name;

    public Game(String name, Field field, Player ...players) {
        this.name = name;
        this.field = field;
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

}
