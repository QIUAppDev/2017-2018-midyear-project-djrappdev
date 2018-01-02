package com.djrapp.quizbowl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuizDao {
    @Insert
    void addTeam(Team team);

    @Insert
    void addPlayer(Player player);

    @Query("SELECT name FROM team")
    List<Team> getTeams();

    @Query("SELECT name FROM player WHERE team.name = :teamName")
    List<String> getPlayers(String teamName);

    @Update
    void updatePlayer(Player player);
}
