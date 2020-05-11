package com.example.dotsdashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pl1 , pl2 , pl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl1 = findViewById(R.id.play1);
        pl2 = findViewById(R.id.play2);
        pl3 = findViewById(R.id.play3);
        Intent intent = getIntent();
        final int grid = intent.getIntExtra("grid",4);
        final int col = intent.getIntExtra("col",6);
        final int row = intent.getIntExtra("row",6);

        pl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , difficulty.class);
                intent.putExtra("nop" , 1);
                intent.putExtra("grid" , grid);
                intent.putExtra("col" , col);
                intent.putExtra("row" , row);
                startActivity(intent);
            }
        });

        pl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                intent.putExtra("nop" , 2);
                intent.putExtra("grid" , grid);
                intent.putExtra("col" , col);
                intent.putExtra("row" , row);
                startActivity(intent);
            }
        });

        pl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                intent.putExtra("nop" , 3);
                intent.putExtra("grid" , grid);
                intent.putExtra("col" , col);
                intent.putExtra("row" , row);
                startActivity(intent);
            }
        });


    }
}
