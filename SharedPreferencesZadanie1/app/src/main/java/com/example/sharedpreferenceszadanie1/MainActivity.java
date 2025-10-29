package com.example.sharedpreferenceszadanie1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DATA_KEY = "UserInputData";

    private EditText dataInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataInput = findViewById(R.id.dataInput);
        saveButton = findViewById(R.id.saveButton);

        // --- Logika zapisu ---
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Uzyskaj dostęp do SharedPreferences i jego Editora
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();

                // 2. Włóż dane do Editora
                editor.putString(DATA_KEY, dataInput.getText().toString());

                // 3. Zapisz zmiany
                editor.apply();

                Toast.makeText(MainActivity.this, "Dane zapisane!", Toast.LENGTH_SHORT).show();
            }
        });


        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String savedData = prefs.getString(DATA_KEY, "Brak zapisanych danych.");

        dataInput.setText(savedData);

        Toast.makeText(MainActivity.this, "Dane wczytane!", Toast.LENGTH_SHORT).show();

    }

}