package com.example.sharedpreferenceszadanie5;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "ZapisaneUsawienia";

    private static final String NAME_KEY = "NAME";
    private static final String SWITCH_KEY = "SWITCH";

    private EditText imie;
    private Switch powiadomienia;
    private Button zapisz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        imie = findViewById(R.id.name);
        powiadomienia = (Switch) findViewById(R.id.powiadomienia);
        zapisz = findViewById(R.id.zapisz);


        zapisz.setOnClickListener(V ->{
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();

            editor.putString(NAME_KEY, imie.getText().toString().trim());

            Boolean stanSwitcha = powiadomienia.isChecked();

            if(stanSwitcha){
                editor.putBoolean(SWITCH_KEY, true);
            }else{
                editor.putBoolean(SWITCH_KEY, false);
            }

            editor.apply();
            Toast.makeText(SettingsActivity.this,"Zapisano!!",Toast.LENGTH_SHORT).show();
        });

    }
}