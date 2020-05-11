package com.example.dotsdashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class difficulty extends AppCompatActivity {


    Button btn1 , btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);


        btn1 = findViewById(R.id.easy);
        btn2 = findViewById(R.id.hard);
        Intent intent = getIntent();
        final int grid = intent.getIntExtra("grid",4);
        final int row = intent.getIntExtra("row",5);
        final int col = intent.getIntExtra("col",5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(difficulty.this , Main2Activity.class);
                intent.putExtra("nop" , 1);
                intent.putExtra("grid" , grid);
                intent.putExtra("diff" , 1);
                intent.putExtra("col" , col);
                intent.putExtra("row" , row);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(difficulty.this , Main2Activity.class);
                intent.putExtra("nop" , 1);
                intent.putExtra("grid" , grid);
                intent.putExtra("diff" , 2);
                intent.putExtra("col" , col);
                intent.putExtra("row" , row);
                startActivity(intent);
            }
        });
    }
}
