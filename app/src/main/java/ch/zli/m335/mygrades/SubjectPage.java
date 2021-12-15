package ch.zli.m335.mygrades;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ch.zli.m335.mygrades.model.AppDatabase;
import ch.zli.m335.mygrades.model.Grade;
import ch.zli.m335.mygrades.model.GradeDao;

public class SubjectPage extends AppCompatActivity {
    TextView subjectPageTitle;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_page);

        final FloatingActionButton addMarkButton = findViewById(R.id.addButtonSP);

        Intent intent = getIntent();
        subjectPageTitle = findViewById(R.id.subjectPageTitle);
        linearLayout = findViewById(R.id.gradesLinearLayout);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mygrades").allowMainThreadQueries().build();
        GradeDao gradeDao = db.gradeDao();

        List<Grade> allMathGrades = gradeDao.getAllMathGrades();
        List<Grade> allEnglishGrades = gradeDao.getAllEnglishGrades();
        List<Grade> allFrenchGrades = gradeDao.getAllFrenchGrades();
        List<Grade> allChemistryGrades = gradeDao.getAllChemistryGrades();



        switch (intent.getStringExtra("title")) {
            case "Mathematik":
                subjectPageTitle.setText("Noten Mathematik");

                for (int i = 0; i < allMathGrades.size(); i++) {
                    TextView testDetail = new TextView(this);
                    testDetail.setText(allMathGrades.get(i).testTitle + "\t\t\t" + allMathGrades.get(i).grade);
                    testDetail.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    testDetail.setPadding(0,20,0,0);
                    linearLayout.addView(testDetail);
                }
                break;

            case "Englisch":
                subjectPageTitle.setText("Noten Englisch");
                for (int i = 0; i < allEnglishGrades.size(); i++) {
                    TextView testDetail = new TextView(this);
                    testDetail.setText(allEnglishGrades.get(i).testTitle + "\t\t\t" + allEnglishGrades.get(i).grade);
                    testDetail.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    testDetail.setPadding(0,20,0,0);
                    linearLayout.addView(testDetail);
                }
                break;

            case "Französisch":
                subjectPageTitle.setText("Noten Französisch");
                for (int i = 0; i < allFrenchGrades.size(); i++) {
                    TextView testDetail = new TextView(this);
                    testDetail.setText(allFrenchGrades.get(i).testTitle + "\t\t\t" + allFrenchGrades.get(i).grade);
                    testDetail.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    testDetail.setPadding(0,20,0,0);
                    linearLayout.addView(testDetail);
                }
                break;

            case "Chemie":
                subjectPageTitle.setText("Noten Chemie");
                for (int i = 0; i < allChemistryGrades.size(); i++) {
                    TextView testDetail = new TextView(this);
                    testDetail.setText(allChemistryGrades.get(i).testTitle + "\t\t\t" + allChemistryGrades.get(i).grade);
                    testDetail.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    testDetail.setPadding(0,20,0,0);
                    linearLayout.addView(testDetail);
                }
                break;
        }

        addMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMark = new Intent(SubjectPage.this, FormPage.class);
                startActivity(addMark);
            }
        });
    }
}
