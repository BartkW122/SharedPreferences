package com.example.sharedpreferenceszadanie2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DATA_KEY = "SwitchValueData";
    private Switch aSwitch;
    private boolean stanSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switch1);

        SharedPreferences preferences =getSharedPreferences(PREFS_NAME,MODE_PRIVATE);

        aSwitch.setChecked(preferences.getBoolean(DATA_KEY,false));

        Toast.makeText(MainActivity.this, "Stan switch został wczytany", Toast.LENGTH_SHORT).show();

        aSwitch.setOnCheckedChangeListener((buttonView, isChecked)->{
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME,MODE_PRIVATE).edit();

            if(isChecked){
                stanSwitch = true;
            }else{
                stanSwitch = false;
            }

            editor.putBoolean(DATA_KEY,stanSwitch);

            editor.apply();

            Toast.makeText(MainActivity.this, "Stan switch zsotal zapisany", Toast.LENGTH_SHORT).show();
        });
    }
}