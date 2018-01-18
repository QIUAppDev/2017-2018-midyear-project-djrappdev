package com.djrapp.quizbowl.room;

public class Player {
    private String username;
    private int score;
    private String teamId;
    private int gameMaster;

    public Player() {
    }
    public Player(String username, String teamId, int gameMaster) {
        this.username = username;
        this.teamId = teamId;
        this.gameMaster = gameMaster;
        score = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(int gameMaster) {
        this.gameMaster = gameMaster;
    }
}