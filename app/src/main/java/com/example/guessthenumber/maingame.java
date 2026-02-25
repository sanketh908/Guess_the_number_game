package com.example.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Scanner;



public class maingame extends AppCompatActivity {
    Random rand=new Random();
    int win=0;
    public String mode="";
    public int r,rang;
    public EditText t;
    public String relus;
    public TextView rul;

    public TextView m;
 public int attemt =0;
    public TextView a;


    public TextView hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maingame);
        t=findViewById(R.id.ans);
        m=findViewById(R.id.modedisplay);
        Intent i=getIntent();
         attemt=i.getIntExtra("attempt",0);
         rang=i.getIntExtra("num",0);
         mode=i.getStringExtra("mode");
        relus=i.getStringExtra("rule");
        m=findViewById(R.id.modedisplay);
        rul=findViewById(R.id.rule);




        hint=findViewById(R.id.hint);

        r=rand.nextInt(rang)+1;


        Button s=findViewById(R.id.submit);
         a=findViewById(R.id.attm);
        m.setText(mode);
        a.setText("YOU HAVE "+attemt+" ATTEMPTS TO TRY");
        rul.setText(relus);
        s.setOnClickListener(v ->checkguess());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void checkguess()
    {




       String guss=t.getText().toString();

        if(!guss.isEmpty())
        {

            attemt--;
            a.setText("YOU HAVE "+attemt+" ATTEMPTS TO TRY");
            int num=Integer.parseInt(guss);
            if(num==r)
            {
                Intent i=new Intent(maingame.this,Congratulations_screen.class);
                startActivity(i);
                win=1;
            }
            else if(num<r)
            {
                hint.setText("The number is larger than "+num);
            }
            else {
                hint.setText("The number is smaller than "+num);
            }
            if(attemt<=0&& win==0 )
            {
                Intent i=new Intent(maingame.this,lost_Screen.class);

                    i.putExtra("num", r);
                    Log.d("activity","ok");
                    startActivity(i);



            }
        }
        else {
            hint.setText("Enter a number !!");
        }
    }











}