package com.example.dotsdashes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    lev1 lev;
    lev2 le;
    lev3 l;
    Button btn;
    TextView play3,play1,play2;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final int players = intent.getIntExtra("nop" , 2);
        final int grid = intent.getIntExtra("grid",4);
        final int row = intent.getIntExtra("row",5);
        final int col = intent.getIntExtra("col",5);

        int diff = intent.getIntExtra("diff" , 1);

        if(grid==3) {
            setContentView(R.layout.activity_main2);
        }
        else if(grid==4){
            setContentView(R.layout.grid4);
        }
        else if(grid==5){
            setContentView(R.layout.gridc);
        }
        play1 = (TextView)findViewById(R.id.textView5);
        play2 = (TextView)findViewById(R.id.textView4);
        play3 = (TextView)findViewById(R.id.textView);
        btn = findViewById(R.id.btn_undo);
        if(players==3){
            play3.setVisibility(View.VISIBLE);
        }else if(players==1){
            play2.setText("| = Device");
        }

        lev = findViewById(R.id.lev1);
        le = findViewById(R.id.lev2);
        l = findViewById(R.id.lev3);
        if(grid==3) {
            lev.setnop(players);
            lev.setDiff(diff);
        }
        else if(grid==4){
            le.setnop(players);
            le.setDiff(diff);
        }
        else if(grid==5){
            l.setnop(players);
            l.setDiff(diff);
            l.setrc(row,col);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(grid==3) {
                    lev.undomove();
                    lev.postInvalidate();

                }
                else if(grid==4){
                    le.undomove();
                    le.postInvalidate();
                }
                else if(grid==5){
                    l.undomove();
                    l.postInvalidate();
                }
            }
        });

    }


}
