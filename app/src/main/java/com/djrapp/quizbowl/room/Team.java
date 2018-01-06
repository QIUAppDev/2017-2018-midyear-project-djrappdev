package com.djrapp.quizbowl.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "team")
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int score;

    public Team(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setId(int id) {
        this.id = id;
    }
}
