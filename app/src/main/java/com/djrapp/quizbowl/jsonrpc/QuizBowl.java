package com.djrapp.quizbowl.jsonrpc;

import com.djrapp.quizbowl.room.Player;
import com.djrapp.quizbowl.room.Team;

import java.util.ArrayList;

public interface QuizBowl {
    Player addUser(String name, String team);
    Team addTeam(Team name);
    ArrayList<Team> getTeams();
    ArrayList<Player> getPlayers();
    int buzz(Player player);
    Player getStatus();
}
