package com.example.dotsdashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class grid extends AppCompatActivity {

    Button b3,b4,bc;
    EditText col,row;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        b3=findViewById(R.id.g3);
        b4=findViewById(R.id.g4);
        bc=findViewById(R.id.gc);
        col=findViewById(R.id.col);
        row=findViewById(R.id.row);



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(grid.this , MainActivity.class);
                intent.putExtra("grid" , 3);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(grid.this , MainActivity.class);
                intent.putExtra("grid" , 4);
                startActivity(intent);
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(row.getText().toString()) && !TextUtils.isEmpty(row.getText().toString()) ) {
                    if (Integer.parseInt(col.getText().toString()) < 11 && Integer.parseInt(col.getText().toString()) > 1 && Integer.parseInt(row.getText().toString()) < 11 && Integer.parseInt(row.getText().toString()) > 1) {
                        Intent intent = new Intent(grid.this, MainActivity.class);
                        intent.putExtra("grid", 5);
                        intent.putExtra("col", Integer.parseInt(col.getText().toString()));
                        intent.putExtra("row", Integer.parseInt(row.getText().toString()));
                        startActivity(intent);
                    }
                }
                else if (!TextUtils.isEmpty(row.getText().toString()) && !TextUtils.isEmpty(row.getText().toString()) ){
                    if (!(Integer.parseInt(col.getText().toString()) < 11 && Integer.parseInt(col.getText().toString()) > 1 && Integer.parseInt(row.getText().toString()) < 11 && Integer.parseInt(row.getText().toString()) > 1)) {
                        Toast t = Toast.makeText(grid.this, "Enter in range specified!!!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
                else{
                    Toast t = Toast.makeText(grid.this , "Enter the Fields First!!!",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                    t.show();
                }
            }
        });
    }
}
