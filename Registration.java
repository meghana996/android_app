package com.example.sois.health_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText Name;
    EditText Email;
    EditText Password;
    EditText Phone_no;
    Button OK;
    Button Back;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name=(EditText)findViewById(R.id.editText6);
        Email=(EditText)findViewById(R.id.editText7);
        Password=(EditText)findViewById(R.id.editText8);
        Phone_no=(EditText)findViewById(R.id.editText9);
        OK=(Button)findViewById(R.id.button4);
        Back=(Button)findViewById(R.id.button5);

        db=new DbHelper(this);

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=Name.getText().toString();
                String s2=Email.getText().toString();
                String s3=Password.getText().toString();
                String s4=Phone_no.getText().toString();

                boolean IsInserted=db.Insert(s1,s2,s3,s4);
                if(IsInserted==true)
                {
                    Toast.makeText(getApplicationContext(),"data is inserted ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"data is not inserted ",Toast.LENGTH_LONG).show();
                }

            }

        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
