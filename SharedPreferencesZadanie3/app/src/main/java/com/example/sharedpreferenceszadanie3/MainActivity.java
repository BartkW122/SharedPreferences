package com.example.sharedpreferenceszadanie3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.invoke.VarHandle;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DATA_KEY = "UserInputData";
    private int licznik;
    private TextView iloscWejsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String savedData = prefs.getString(DATA_KEY, "0");

        licznik = Integer.valueOf(savedData);
        licznik += 1;
        iloscWejsc = findViewById(R.id.iloscWejsc);

        iloscWejsc.setText(String.valueOf(licznik));

        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();

        editor.putString(DATA_KEY, String.valueOf(licznik));

        editor.apply();
    }
}