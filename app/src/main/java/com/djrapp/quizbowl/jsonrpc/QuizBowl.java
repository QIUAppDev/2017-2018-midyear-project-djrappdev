package com.djrapp.quizbowl.jsonrpc;

import com.djrapp.quizbowl.room.*;

public interface QuizBowl {
    Player addPlayer(Player player);
    int getPoints(Team team);
    int getPoints(Player player);

    
}
