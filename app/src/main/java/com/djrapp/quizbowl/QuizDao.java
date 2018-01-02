package com.djrapp.quizbowl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao {
    @Insert
    void addTeam(Team team);

    @Insert
    void addPlayer(Player player);

    @Query("SELECT name FROM team")
    List<Team> getTeams();

    @Query("SELECT name FROM player WHERE teamId IS :teamId")
    List<String> getPlayers(int teamId);

}
