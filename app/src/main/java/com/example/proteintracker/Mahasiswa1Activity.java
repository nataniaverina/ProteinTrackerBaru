package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mahasiswa1Activity extends AppCompatActivity implements Mahasiswa1Fragment.SendMessage{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa1);

        Button btnPress2 = findViewById(R.id.btnMhsFragmen);
        btnPress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                Mahasiswa1Fragment mahasiswa1Fragment = Mahasiswa1Fragment.newInstance("test","test2");
                ft2.replace(R.id.forTest, mahasiswa1Fragment);
                ft2.commit();
            }
        });
    }

    @Override
    public void SendData(String Message) {
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        Mahasiswa2Fragment mahasiswa2Fragment = Mahasiswa2Fragment.newInstance(Message,"test2");
        ft2.replace(R.id.forTest, mahasiswa2Fragment);
        ft2.commit();
    }
}
