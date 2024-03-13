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

        textHello = findViewById(R.id.textHello);
        EditText enteredName = findViewById(R.id.enterName);

        MainViewModel mainViewModel
                = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getNameEntered()
                .observe(this, s -> textHello.setText("Hello " + s + "!"));

        Button buttonToEnterName = findViewById(R.id.buttonToEnterName);
        buttonToEnterName.setOnClickListener(v -> {
            mainViewModel.setNameEntered(enteredName.getText().toString());
            enteredName.setText("");
        });

        TextView counter = findViewById(R.id.counter);

        mainViewModel.getCount()
                .observe(this, aLong -> counter.setText("Counter = " + aLong));

        View.OnClickListener l = v -> {
            mainViewModel.count++;
            mainViewModel.setCount(mainViewModel.count);
        };

        Button counterButton = findViewById(R.id.counterButton);
        counterButton.setOnClickListener(l);


    }
}