package ch.zli.m335.mygrades.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("Select * FROM grade WHERE subject = 'Mathematik'")
    List<Grade> getAllMathGrades();

    @Query("Select avg(grade.grade) FROM grade WHERE subject = 'Mathematik'")
    Float getMathAverage();

    @Query("SELECT * FROM grade WHERE subject = 'english'")
    List<Grade> getAllEnglishGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Englisch'")
    Float getEnglishAverage();

    @Query("SELECT * FROM grade WHERE subject = 'Französisch'")
    List<Grade> getAllFrenchGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Französisch'")
    Float getFrenchAverage();

    @Query("SELECT * FROM grade WHERE subject = 'Chemie'")
    List<Grade> getAllChemistryGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Chemie'")
    Float getChemistryAverage();

    @Insert
    void insertAll(Grade... grades);
}
