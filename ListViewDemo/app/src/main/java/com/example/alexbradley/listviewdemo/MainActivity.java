package com.example.alexbradley.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> myFamily = new ArrayList<String>(asList("Mark", "Kate", "Hannah", "Alex", "Emilia", "Harley"));

        //Can add new entries using .add();
        //myFamily.add("Mark");
        //myFamily.add("Kate");
        //myFamily.add("Hannah");
        //myFamily.add("Alex");
        //myFamily.add("Emilia");
        //myFamily.add("Harley");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, myFamily.get(i) + " tapped", Toast.LENGTH_LONG).show();
            }
        });
    }
}
