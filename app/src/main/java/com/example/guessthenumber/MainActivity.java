package com.example.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public Button e;
    public Button m;
    public  Button h;
   public  Button c;
   public  Button cus;
public Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        h=findViewById(R.id.hardmode);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,maingame.class);
                i.putExtra("num", 100);
                i.putExtra("mode","HARD MODE");
                i.putExtra("attempt",8);
                i.putExtra("rule","Guess the random number between  0 to 100 ");
                Log.d("activity","ok");
                startActivity(i);
            }
        });
        m=findViewById(R.id.midmode);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,maingame.class);
                i.putExtra("num", 50);
                i.putExtra("mode","MEDIUM MODE");
                i.putExtra("attempt",7);
                i.putExtra("rule","Guess the random number between  0 to 50");
                Log.d("activity","ok");
                    startActivity(i);

            }
        });
         e=findViewById(R.id.easymode);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,maingame.class);
                i.putExtra("num", 10);
                i.putExtra("mode","EASY MODE");
                i.putExtra("attempt",5);
                i.putExtra("rule","Guess the random number between  0 to 10");
                Log.d("activity","ok");
                startActivity(i);
            }

        });
        exit=findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MY_massage.class);
                startActivity(i);
            }
        });
         c =findViewById(R.id.close);
         c.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity( new Intent(MainActivity.this,HOME_SCREEN.class) );
             }
         });
         cus=findViewById(R.id.cr);
         cus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,crinfo.class));
             }
         });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }



    public void playgame(View v)
    {

        v.setEnabled(false);
        Button b=(Button) v;
        b.setText("Work in progress");



    }




}