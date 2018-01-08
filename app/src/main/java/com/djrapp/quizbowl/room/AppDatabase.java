package com.djrapp.quizbowl.room;

import android.arch.persistence.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    public abstract QuizBowlDao quizDao();

}
