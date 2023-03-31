package org.coderorgirq.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import org.coderorgirq.myapplication.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    ActivityIntroBinding introBinding;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        introBinding = DataBindingUtil.setContentView(this, R.layout.activity_intro);
        //setContentView(R.layout.activity_intro);
        preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        editor = preferences.edit();
        //
        boolean isShowed=preferences.getBoolean("isShowed",false);
        if (isShowed) {
            startMainActivity();
        }
        introBinding.skip.setOnClickListener(v -> {
            editor.putBoolean("isShowed", true).apply();
            //commit() or apply() batter than commit()
            startMainActivity();
        });
    }

    private void startMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}