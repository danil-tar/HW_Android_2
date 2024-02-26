package com.example.hw_android_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {

    private TextView textHello;
    private Editable enteredNameText;
    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHello = findViewById(R.id.textHello);

        EditText enteredName = findViewById(R.id.enterName);
        enteredNameText = enteredName.getText();

        Button buttonToEnterName = findViewById(R.id.buttonToEnterName);
        buttonToEnterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textHello.setText("Hello " + enteredNameText);
            }
        });
        
        TextView counter = findViewById(R.id.counter);
        View.OnClickListener l = v -> {
            count++;
            String valueOfCount = String.valueOf(count);
            counter.setText("Counter = " + valueOfCount);
        };

        Button counterButton = findViewById(R.id.counterButton);
        counterButton.setOnClickListener(l);

    }
}