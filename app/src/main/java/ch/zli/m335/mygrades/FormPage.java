package ch.zli.m335.mygrades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import ch.zli.m335.mygrades.model.AppDatabase;
import ch.zli.m335.mygrades.model.Grade;
import ch.zli.m335.mygrades.model.GradeDao;

public class FormPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_page);

        Button submitForm = findViewById(R.id.submitForm);
        Spinner subjectSpinner = findViewById(R.id.subjectSpinner);
        EditText testTitle = findViewById(R.id.testTitle);
        EditText gradeValue = findViewById(R.id.gradeValue);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mygrades").allowMainThreadQueries().build();
        GradeDao gradeDao = db.gradeDao();

        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade grade = new Grade();
                grade.grade = Float.parseFloat(String.valueOf(gradeValue.getText()));
                grade.subject = subjectSpinner.getSelectedItem().toString();
                grade.testTitle = String.valueOf(testTitle.getText());

                gradeDao.insertAll(grade);

                Intent intent = new Intent(FormPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
