package com.djrapp.quizbowl.room;

public class Player {
    private String username;
    private int score;
    private String teamId;
    private int gameMaster;

    public Player(String username, String teamId, int gameMaster) {
        this.username = username;
        this.teamId = teamId;
        this.gameMaster = gameMaster;
        score = 0;
    }

}