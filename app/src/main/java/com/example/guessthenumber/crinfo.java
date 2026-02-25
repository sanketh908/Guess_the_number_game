package com.example.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class crinfo extends AppCompatActivity {
    public Button sub;
    EditText attt ,range;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crinfo);
        sub =findViewById(R.id.sel);
        range=findViewById(R.id.rang);
        attt=findViewById(R.id.at);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tr=attt.getText().toString();
                String rn=range.getText().toString();
                if(!tr.isEmpty()&&!rn.isEmpty())
                {
                    int t=Integer.parseInt(tr);
                    int r=Integer.parseInt(rn);
                    Intent i=new Intent(crinfo.this,maingame.class);
                    i.putExtra("num",r);
                    i.putExtra("mode","CUSTOM MODE");
                    i.putExtra("attempt",t);
                    i.putExtra("rule","guess the random number between  0 to"+r);
                    Log.d("successfully","ok");
                    startActivity(i);

                }

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}