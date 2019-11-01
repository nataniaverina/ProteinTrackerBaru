package com.example.proteintracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button helpBtn = (Button) findViewById(R.id.helpButton);
        helpBtn.setOnClickListener(helpButtonListener);

        TextView textView = (TextView) findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button) findViewById(R.id.button1);

        textView.setText(R.string.test_untuk_update_view);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEditText = (EditText) findViewById(R.id.editText1);
                Log.d("Proteintracker", myEditText.getText().toString());
            }
        });

        if (savedInstanceState != null) {
            Log.d("ProteinTracker", savedInstanceState.getString("abc"));
        }
        SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin",null);
        Button btnLogin = (Button)findViewById(R.id.login);
        btnLogin.setOnClickListener(myBtnLoginClick);
        if (statusLogin != null)
        {
            btnLogin.setText("Logout");
        }
        else
        {
            btnLogin.setText("Login");
        }
    }

    private View.OnClickListener helpButtonListener = new View.OnClickListener()
    {
        @Override
        public void onClick (View view) {
            Intent intent = new Intent(MainActivity.this,HelpActivity.class);
            Bundle b = new Bundle();
            EditText myEditText = (EditText) findViewById(R.id.editText1);
            b.putString("helpString", myEditText.getText().toString()) ;
            intent.putExtras(b);
            startActivity(intent);
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("abc","test");
        super.onSaveInstanceState(outState);
    }

    public void GoToFragment(View view) {
        Intent intent = new Intent(MainActivity.this, Main2FragmentActivity.class);
        startActivity(intent);
    }

    public void GoToMahasiswa1(View view) {
        Intent intent = new Intent(MainActivity.this, Mahasiswa1Activity.class);
        startActivity(intent);
    }

    public class MainActiviy extends AppCompatActivity
    {
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button btnSetting = (Button)findViewById(R.id.btnSetting);
            btnSetting.setOnClickListener(myBtnSettingClick);
        }
        private View.OnClickListener myBtnSettingClick = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            };
        };
    }

    public static class SettingProteinTracker extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_setting_protein_tracker);
            setHasOptionsMenu(true);
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            int id = item.getItemId();
            if(id == android.R.id.home)
            {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
    private View.OnClickListener myBtnLoginClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin", null);
            SharedPreferences.Editor edit = prefs.edit();

            Button btnLogin = (Button) findViewById(R.id.login);
            if (statusLogin != null) {
                edit.putString("isLogin", null);
                btnLogin.setText("Login");
            } else {
                edit.putString("isLogin", "Admin");
                btnLogin.setText("Logout");
            }
            edit.commit();
        }
    };
}




