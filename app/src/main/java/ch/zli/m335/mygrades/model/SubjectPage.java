package ch.zli.m335.mygrades.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ch.zli.m335.mygrades.R;

public class SubjectPage extends AppCompatActivity {
    TextView subjectPageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_page);

        final FloatingActionButton addMarkButton = findViewById(R.id.addButtonSP);

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

        addMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMark = new Intent(SubjectPage.this, FormPage.class);
                startActivity(addMark);
            }
        });
    }
}
