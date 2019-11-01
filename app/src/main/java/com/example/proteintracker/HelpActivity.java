package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView txtView = findViewById(R.id.textView2);
        txtView.setText("test");

        Bundle b = getIntent().getExtras();
        String tmpString = b.getString("helpText");

        txtView.setText((tmpString));

        //myTextView.setText("Some Help Text");
        //setContentView(txtView);
    }
}
