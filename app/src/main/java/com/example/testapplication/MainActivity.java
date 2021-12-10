package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Room> list;
    RoomAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.room_list);
        LinearLayoutManager m = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(m);

        list = new ArrayList<>();
        list.add(new Room(1, "Program", null, null, null));
        list.add(new Room(2, "Java", null, null, null));
        list.add(new Room(3, "Girl Friend", null, null, null));
        list.add(new Room(4, "Marriage with cousin", null, null, null));
        list.add(new Room(5, "Robotics", null, null, null));

        adapter = new RoomAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        //list = dao.load();
        adapter = new RoomAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        SearchView sView = findViewById(R.id.search);
        sView.setQueryHint("Name of room");
        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) { 
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void SignUp(View view)
    {

        Intent i = new Intent(this, SignUp.class);
        i.putExtra("id", list.size());
        startActivity(i);
    }
}