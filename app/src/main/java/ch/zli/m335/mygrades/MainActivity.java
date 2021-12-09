package ch.zli.m335.mygrades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout mathLayout = findViewById(R.id.horizontalMath);
        final LinearLayout englishLayout = findViewById(R.id.horizontalEnglish);
        final LinearLayout frenchLayout = findViewById(R.id.horizontalFrench);
        final LinearLayout chemistryLayout = findViewById(R.id.horizontalChemistry);
        final FloatingActionButton addMarkButton = findViewById(R.id.addButtonMP);

        Intent subjectPageIntent = new Intent(MainActivity.this, SubjectPage.class);

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