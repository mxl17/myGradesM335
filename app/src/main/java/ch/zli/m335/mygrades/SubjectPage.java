package ch.zli.m335.mygrades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectPage extends AppCompatActivity {
    TextView subjectPageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_page);

        Intent intent = getIntent();
        subjectPageTitle = findViewById(R.id.subjectPageTitle);

        switch (intent.getStringExtra("title")) {
            case "Mathematik":
                subjectPageTitle.setText("Noten Mathematik");
                break;

            case "Englisch":
                subjectPageTitle.setText("Noten Englisch");
                break;

            case "Französisch":
                subjectPageTitle.setText("Noten Französisch");
                break;

            case "Chemie":
                subjectPageTitle.setText("Noten Chemie");
                break;
        }
    }
}
