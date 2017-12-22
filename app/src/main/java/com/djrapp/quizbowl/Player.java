package com.djrapp.quizbowl;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity()
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private int power;
    private int correct;
    private int negative;

    public Player(int id, String userName, int power, int correct, int negative) {
        this.id = id;
        this.userName = userName;
        this.power = power;
        this.correct = correct;
        this.negative = negative;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }
}
