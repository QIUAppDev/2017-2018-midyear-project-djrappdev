package com.djrapp.quizbowl;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "team")
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int power;
    private int correct;
    private int negative;

    public Team(String name, int power, int correct, int negative) {
        this.name = name;
        this.power = power;
        this.correct = correct;
        this.negative = negative;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
}
