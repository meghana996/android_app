package com.example.sois.health_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    EditText Name;
    Button search;
    ListView list;
    TextView signout;
    List item;
    String Age1;
    String Gender1;
    String Weight1;
    String Height1;
    String Bloodgroup1;
    DbHelper database;
    ArrayAdapter<String> adapter;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Name = (EditText) findViewById(R.id.editText13);
        search = (Button) findViewById(R.id.button7);
        list = (ListView) findViewById(R.id.mylist);
        signout = (TextView) findViewById(R.id.textView3);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                searchButtonClick();
            }
        });

        item = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        list.setAdapter(adapter);
    }

    private void searchButtonClick() {
        String searchInoutText = Name.getText().toString();
        database = new DbHelper(getApplicationContext());
        Age1 = database.fetchByID(searchInoutText);
        Gender1 = database.fetchByID1(searchInoutText);
        Height1 = database.fetchByID2(searchInoutText);
        Weight1 = database.fetchByID3(searchInoutText);
        Bloodgroup1 = database.fetchByID4(searchInoutText);
        if (Age1 != null) {
            Toast.makeText(getApplicationContext(), Age1, Toast.LENGTH_LONG).show();
            adapter.add(Age1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (Gender1 != null) {
            Toast.makeText(getApplicationContext(), Gender1, Toast.LENGTH_LONG).show();
            adapter.add(Gender1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (Height1 != null) {
            Toast.makeText(getApplicationContext(), Height1, Toast.LENGTH_LONG).show();
            adapter.add(Height1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (Weight1 != null) {
            Toast.makeText(getApplicationContext(), Weight1, Toast.LENGTH_LONG).show();
            adapter.add(Weight1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (Bloodgroup1 != null) {
            Toast.makeText(getApplicationContext(), Bloodgroup1, Toast.LENGTH_LONG).show();
            adapter.add(Bloodgroup1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
    }
}