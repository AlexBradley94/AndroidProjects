package com.example.multipleactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listPeople;

    /*public void goToNext(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("age", 25);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPeople = findViewById(R.id.listPeople);

        final ArrayList<String> myFriends = new ArrayList<String>();

        myFriends.add("Charlie");
        myFriends.add("Josh");
        myFriends.add("Joe");
        myFriends.add("Jess");
        myFriends.add("Ben");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        listPeople.setAdapter(arrayAdapter);

        listPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Name", myFriends.get(position));
                startActivity(intent);
            }
        });
    }
}
