package com.djrapp.quizbowl.jsonrpc;

import com.djrapp.quizbowl.room.Player;
import com.djrapp.quizbowl.room.Team;

import java.util.ArrayList;

public interface QuizBowl {
    Player addUser(String name, String teamId, int gameMaster);
    Team addTeam(String name);
    ArrayList<Team> getTeams();
    ArrayList<Player> getPlayers();
    void buzz(Player player);
    void clearBuzz();
    int checkBuzz();
    Player getWhoBuzzed();
    void addPoints(int points,Player player);
    void setLobbyState();
    void setEndState();
    int getLobbyState();
    int getEndState();
}
