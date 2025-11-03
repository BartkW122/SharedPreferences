package com.example.sharedpreferenceszadanie5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "ZapisaneUsawienia";

    private static final String NAME_KEY = "NAME";
    private static final String SWITCH_KEY = "SWITCH";

    private Button ustawienia;
    private TextView wpisaneImie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ustawienia = findViewById(R.id.ustawienia);
        wpisaneImie = findViewById(R.id.wpisaneImie);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        wpisaneImie.setText(prefs.getString(NAME_KEY,"Witaj, gościu!"));

        if(prefs.getBoolean(SWITCH_KEY,true)){
            Toast.makeText(MainActivity.this,"Witaj, "+prefs.getString(NAME_KEY,""),Toast.LENGTH_SHORT).show();
        }

        ustawienia.setOnClickListener(V->{
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);

            startActivity(intent);
        });
    }
}