package com.djrapp.quizbowl.jsonrpc;

import com.djrapp.quizbowl.room.Player;
import com.djrapp.quizbowl.room.Team;

import java.util.ArrayList;

public interface QuizBowl {
    Player addUser(String name);
    Team addTeam(String name);
    ArrayList<Team> getTeams();
    ArrayList<Player> getPlayers();
    int buzz(Player player);
    Player getStatus();
}
