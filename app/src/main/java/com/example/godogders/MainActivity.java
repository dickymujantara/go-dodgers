package com.example.godogders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlayers;
    private ArrayList<Player> listPlayer = new ArrayList<>();
    private String title = "Go Dodgers!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvPlayers = findViewById(R.id.rv_player);
        rvPlayers.setHasFixedSize(true);
        listPlayer.addAll(PlayersData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
        ListPlayerAdapter listPlayerAdapter = new ListPlayerAdapter(listPlayer);
        rvPlayers.setAdapter(listPlayerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        clickedMenuAction(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void clickedMenuAction(int selectedMenu){
        if (selectedMenu == R.id.about_me) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
