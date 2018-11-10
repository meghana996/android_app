package com.example.sois.health_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button Login;
    Button Registartion;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email=(EditText)findViewById(R.id.editText);
        Password=(EditText)findViewById(R.id.editText2);
        Login=(Button)findViewById(R.id.button2);
        Registartion=(Button)findViewById(R.id.button3);
        db=new DbHelper(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=Email.getText().toString();
                String p=Password.getText().toString();
                boolean validate=db.validate(e,p);
                if(validate==true){
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getApplicationContext(),Details.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"NOT SUCCESSFULL",Toast.LENGTH_LONG).show();
                }

            }
        });

        Registartion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });
    }
}
