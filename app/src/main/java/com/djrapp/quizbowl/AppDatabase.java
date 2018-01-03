package com.djrapp.quizbowl;

import android.arch.persistence.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    public abstract QuizDao quizDao();

}
