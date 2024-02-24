package com.example.hw_android_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textHello;
    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText enteredName = findViewById(R.id.enterName);
        textHello = findViewById(R.id.textHello);

        Button counterButton = findViewById(R.id.counterButton);
        TextView counter = findViewById(R.id.counter);


        Editable enteredNameText = enteredName.getText();
        Button buttonToEnterName = findViewById(R.id.buttonToEnterName);

        buttonToEnterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnteredName(enteredNameText);
            }
        });

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                count++;
                String valueOfCount = String.valueOf(count);
                counter.setText("Counter = " + valueOfCount);
            }
        });

    }

    private void setEnteredName(Editable enteredNameText) {
        textHello.setText("Hello " + enteredNameText);
    }
}