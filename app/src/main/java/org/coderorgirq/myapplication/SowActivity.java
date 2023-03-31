package org.coderorgirq.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.coderorgirq.myapplication.databinding.ActivitySowBinding;

public class SowActivity extends AppCompatActivity {

    ActivitySowBinding sowActivity;
    String data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sowActivity = DataBindingUtil.setContentView(this,R.layout.activity_sow);
        //
        sowActivity= DataBindingUtil.setContentView(this,R.layout.activity_sow);
        sowActivity.button.setOnClickListener(v-> {
            data2=sowActivity.editText.getText().toString();
            sender(data2);
        });
        Intent receivedIntent = getIntent();
        sowActivity.textView.setText(receivedIntent.getStringExtra("message"));

    }

    private void sender(String x) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("message2", x);
        startActivity(intent);
    }
}