package com.example.p1holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mHelloButton;
    private Button mWorldButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inflar widgets
        mHelloButton = findViewById(R.id.hello_button);
        mWorldButton = findViewById(R.id.world_button);
        // Porgramacion de evento click
        mHelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this,
                        R.string.hello,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mWorldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this,
                        R.string.world,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}