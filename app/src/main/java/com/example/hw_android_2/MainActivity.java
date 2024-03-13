package com.example.hw_android_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel
                = new ViewModelProvider(this).get(MainViewModel.class);

        textHello = findViewById(R.id.textHello);
        EditText enteredName = findViewById(R.id.enterName);

        textHello.setText("Hello " + mainViewModel.nameEntered + "!");

        Button buttonToEnterName = findViewById(R.id.buttonToEnterName);
        buttonToEnterName.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mainViewModel.nameEntered = enteredName.getText().toString();
                textHello.setText("Hello " + mainViewModel.nameEntered + "!");
                enteredName.setText("");
            }
        });

        TextView counter = findViewById(R.id.counter);
        counter.setText("Counter = " + mainViewModel.count);

        View.OnClickListener l = v -> {
            mainViewModel.count++;
            String valueOfCount = String.valueOf(mainViewModel.count);
            counter.setText("Counter = " + valueOfCount);
        };

        Button counterButton = findViewById(R.id.counterButton);
        counterButton.setOnClickListener(l);

    }
}