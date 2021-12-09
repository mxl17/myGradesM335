package ch.zli.m335.mygrades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.List;

import ch.zli.m335.mygrades.model.AppDatabase;
import ch.zli.m335.mygrades.model.Grade;
import ch.zli.m335.mygrades.model.GradeDao;

public class MainActivity extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout mathLayout = findViewById(R.id.horizontalMath);
        final LinearLayout englishLayout = findViewById(R.id.horizontalEnglish);
        final LinearLayout frenchLayout = findViewById(R.id.horizontalFrench);
        final LinearLayout chemistryLayout = findViewById(R.id.horizontalChemistry);
        final FloatingActionButton addMarkButton = findViewById(R.id.addButtonMP);
        final TextView mathGrade = findViewById(R.id.mathGrade);

        Intent subjectPageIntent = new Intent(MainActivity.this, SubjectPage.class);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mygrades").allowMainThreadQueries().build();
        GradeDao gradeDao = db.gradeDao();

        Float mathGrades = gradeDao.getMathAverage();
        mathGrade.setText(df.format(mathGrades));

        mathLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectPageIntent.putExtra("title", "Mathematik");
                startActivity(subjectPageIntent);
            }
        });

        englishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectPageIntent.putExtra("title", "Englisch");
                startActivity(subjectPageIntent);
            }
        });

        frenchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectPageIntent.putExtra("title", "Französisch");
                startActivity(subjectPageIntent);
            }
        });

        chemistryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectPageIntent.putExtra("title", "Chemie");
                startActivity(subjectPageIntent);
            }
        });

        addMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMark = new Intent(MainActivity.this, FormPage.class);
                startActivity(addMark);
            }
        });
    }
}