package com.djrapp.quizbowl.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface QuizDao {
    @Insert
    void addTeam(Team team);

    @Insert
    void addPlayer(Player player);

    @Query("SELECT name FROM team")
    Team[] getTeams();

    @Query("SELECT name FROM player WHERE team.name = :teamName")
    String[] getPlayers(String teamName);

    @Query("SELECT score FROM team WHERE team.name = :teamName")
    int getTeamScore(String teamName);

    @Query("SELECT score FROM player WHERE player.name = :playerName")
    int getPlayerScore(String playerName);

    @Update
    void updatePlayer(Player player);

    @Update
    void updateTeam(Team team);
}
