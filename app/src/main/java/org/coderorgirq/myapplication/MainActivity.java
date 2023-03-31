package org.coderorgirq.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.coderorgirq.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainActivity;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivity.button.setOnClickListener(v-> {
            data=mainActivity.editText.getText().toString();
            sender(data);
        });
        Intent receivedIntent = getIntent();
        mainActivity.textView.setText(receivedIntent.getStringExtra("message2"));
    }

    private void sender(String x) {
        Intent intent = new Intent(this, SowActivity.class);
        intent.putExtra("message", x);
        startActivity(intent);
    }
}