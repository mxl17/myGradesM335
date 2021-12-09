package ch.zli.m335.mygrades.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Grade.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GradeDao gradeDao();
}
