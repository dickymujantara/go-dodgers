package com.example.godogders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ImageView imgPlayer;
    TextView name,nickname,noPlayer,playerPos,batting,throwings,heightPlayer,weightPlayer,playerAge;
    private String title = "Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setActionBarTitle(title);

        imgPlayer = findViewById(R.id.player_img);
        name = findViewById(R.id.player_name);
        nickname  = findViewById(R.id.player_nickname);
        noPlayer  = findViewById(R.id.player_num);
        playerPos  = findViewById(R.id.player_pos);
        batting = findViewById(R.id.player_bat);
        throwings = findViewById(R.id.player_throw);
        heightPlayer = findViewById(R.id.player_height);
        weightPlayer = findViewById(R.id.player_weight);
        playerAge = findViewById(R.id.player_age);

        getDetailData();
    }

    private void getDetailData(){
        Intent intent = getIntent();

        Glide.with(this)
                .load(intent.getIntExtra("playerImg",0))
                .into(imgPlayer);

            name.setText(intent.getStringExtra("playerName"));
            nickname.setText(intent.getStringExtra("playerNickname"));
            noPlayer.setText("#92");
            playerPos.setText( getPos(intent.getStringExtra("playerPos")));
            playerAge.setText(String.valueOf(intent.getIntExtra("playerAge",0)));
            batting.setText(getHand(intent.getCharExtra("playerBat",'E')));
            throwings.setText(getHand(intent.getCharExtra("playerThrow",'E')));
            weightPlayer.setText(String.valueOf(intent.getIntExtra("playerWeight",0)) + " lbs");
            heightPlayer.setText(intent.getStringExtra("playerHeight"));
    }

    protected String getPos(String pos){
        String namePos = "";

        switch (pos){
            case "P":
                namePos = "Pitcher";
                break;
            case "C":
                namePos = "Catcher";
                break;
            case "1B":
                namePos = "First Baseman";
                break;
            case "2B":
                namePos = "Second Baseman";
                break;
            case "3B" :
                namePos = "Third Baseman";
                break;
            case "SS":
                namePos = "Shortstop";
                break;
            case "LF":
                namePos = "Left Field";
                break;
            case "CF" :
                namePos = "Center Field";
                break;
            case "RF":
                namePos = "Right Field";
                break;
        }

        return namePos;
    }

    protected String getHand(char hand){
     String getHand = "";

     if (hand == 'R'){
         getHand = "Right";
     }else{
         getHand = "Left";
     }

     return getHand;
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

}
