package com.djrapp.quizbowl;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "player")
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private int power;
    private int correct;
    private int negative;
    private int teamId;

    public Player(String username, int power, int correct, int negative, int teamId) {
        this.username = username;
        this.power = power;
        this.correct = correct;
        this.negative = negative;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public int getPower() {
        return power;
    }
    public int getCorrect() {
        return correct;
    }
    public int getNegative() {
        return negative;
    }
    public int getTeamId() {
        return teamId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setCorrect(int correct) {
        this.correct = correct;
    }
    public void setNegative(int negative) {
        this.negative = negative;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
