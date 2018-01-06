package com.djrapp.quizbowl.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "player")
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private int score;
    private int teamId;

    public Player(String username, int teamId) {
        this.username = username;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public int getScore() {
        return score;
    }
    public int getTeamId() {
        return teamId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public void setId(int id) {
        this.id = id;
    }
}
