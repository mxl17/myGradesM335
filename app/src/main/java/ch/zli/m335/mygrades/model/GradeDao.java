package ch.zli.m335.mygrades.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("Select * FROM grade WHERE subject = 'Mathematik'")
    List<Grade> getAllMath();

    @Query("Select avg(grade.grade) FROM grade WHERE subject = 'Mathematik'")
    Float getMathAverage();

    @Query("SELECT * FROM grade WHERE subject = 'english'")
    List<Grade> getAllEnglish();

    @Insert
    void insertAll(Grade... grades);
}
