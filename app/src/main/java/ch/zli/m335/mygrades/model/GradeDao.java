package ch.zli.m335.mygrades.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("Select grade.test_title, grade.grade FROM grade WHERE subject = 'Mathematik'")
    List<Float> getAllMathGrades();

    @Query("Select avg(grade.grade) FROM grade WHERE subject = 'Mathematik'")
    Float getMathAverage();

    @Query("SELECT grade.test_title, grade.grade FROM grade WHERE subject = 'english'")
    List<Float> getAllEnglishGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Englisch'")
    Float getEnglishAverage();

    @Query("SELECT grade.test_title, grade.grade FROM grade WHERE subject = 'Französisch'")
    List<Float> getAllFrenchGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Französisch'")
    Float getFrenchAverage();

    @Query("SELECT grade.test_title, grade.grade FROM grade WHERE subject = 'Chemie'")
    List<Float> getAllChemistryGrades();

    @Query("SELECT avg(grade.grade) FROM grade WHERE subject = 'Chemie'")
    Float getChemistryAverage();

    @Insert
    void insertAll(Grade... grades);
}
