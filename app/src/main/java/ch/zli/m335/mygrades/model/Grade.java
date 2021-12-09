package ch.zli.m335.mygrades.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Grade {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "test_title")
    public String testTitle;

    @ColumnInfo(name = "grade")
    public float grade;

    @ColumnInfo(name = "subject")
    public String subject;
}
