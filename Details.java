package com.example.sois.health_care;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    EditText name;
    EditText Age;
    EditText Gender;
    EditText Weight;
    EditText Height;
    EditText Bloodgroup;
    Button Save;
    Button Next;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name=(EditText)findViewById(R.id.editText3);
        Age=(EditText)findViewById(R.id.editText4);
        Gender=(EditText)findViewById(R.id.editText5);
        Weight=(EditText)findViewById(R.id.editText10);
        Height=(EditText)findViewById(R.id.editText11);
        Bloodgroup=(EditText)findViewById(R.id.editText12);
        Save=(Button)findViewById(R.id.button);
        Next=(Button)findViewById(R.id.button6);

        db=new DbHelper(this);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=name.getText().toString();
                String s2=Age.getText().toString();
                String s3=Gender.getText().toString();
                String s4=Weight.getText().toString();
                String s5=Height.getText().toString();
                String s6=Bloodgroup.getText().toString();

                boolean IsInserted=db.InsertData(s1,s2,s3,s4,s5,s6);
                if (IsInserted==true){
                    Toast.makeText(getApplicationContext(),"DATA INSERTED",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"DATA NOT INSERTED",Toast.LENGTH_LONG).show();
            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Search.class);
                startActivity(i);
            }
        });

    }
}
