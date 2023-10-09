package com.angi_sh.krestiki_noliki;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    public String player1 = "", player2 ="";
    public int number_player = 1;
    public int button_number = 0;
    public Game game = new Game();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle arguments = getIntent().getExtras();
        player1 = arguments.get("player1").toString();
        if (player1.equals("crest")) player2 ="zero";
        else player2 = "crest";
        findViewById(R.id.zero1).setVisibility(INVISIBLE);
        findViewById(R.id.zero2).setVisibility(INVISIBLE);
        findViewById(R.id.zero3).setVisibility(INVISIBLE);
        findViewById(R.id.zero4).setVisibility(INVISIBLE);
        findViewById(R.id.zero5).setVisibility(INVISIBLE);
        findViewById(R.id.zero6).setVisibility(INVISIBLE);
        findViewById(R.id.zero7).setVisibility(INVISIBLE);
        findViewById(R.id.zero8).setVisibility(INVISIBLE);
        findViewById(R.id.zero9).setVisibility(INVISIBLE);

        findViewById(R.id.crest1).setVisibility(INVISIBLE);
        findViewById(R.id.crest2).setVisibility(INVISIBLE);
        findViewById(R.id.crest3).setVisibility(INVISIBLE);
        findViewById(R.id.crest4).setVisibility(INVISIBLE);
        findViewById(R.id.crest5).setVisibility(INVISIBLE);
        findViewById(R.id.crest6).setVisibility(INVISIBLE);
        findViewById(R.id.crest7).setVisibility(INVISIBLE);
        findViewById(R.id.crest8).setVisibility(INVISIBLE);
        findViewById(R.id.crest9).setVisibility(INVISIBLE);
    }
    public void onClick(View view){
        int x=0,y=0;
        switch (view.getId()){
            case R.id.empty1: x=0;y=0; button_number = 1; break;
            case R.id.empty2: x=1;y=0; button_number = 2; break;
            case R.id.empty3: x=2;y=0; button_number = 3; break;
            case R.id.empty4: x=0;y=1; button_number = 4; break;
            case R.id.empty5: x=1;y=1; button_number = 5; break;
            case R.id.empty6: x=2;y=1; button_number = 6; break;
            case R.id.empty7: x=0;y=2; button_number = 7; break;
            case R.id.empty8: x=1;y=2; button_number = 8; break;
            case R.id.empty9: x=2;y=2; button_number = 9; break;

        }
        if((number_player == 1) && (game.goPlayer1(x,y))){
            setImage(button_number, player1);
            TextView f = findViewById(R.id.text);
            f.setText("Ход вторго игрока");
            number_player = 2;
        }
        else{
            if(game.goPlayer2(x,y)){
                setImage(button_number, player2);
                TextView f = findViewById(R.id.text);
                f.setText("Ход первого игрока");
                number_player = 1;
            }
        }
        Boolean w = false;
        if (game.win() == 1) {
            w = true;
            Toast.makeText(this, "Выиграл первый игрок", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if (game.win() == 2) {
            w = true;
            Toast.makeText(this, "Выиграл второй игрок", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if ((!game.checkDraw()) && !w) {
            Toast.makeText(this, "Ничья", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    private void setImage(int number, String s){
        switch (number){
            case 1:
                findViewById(R.id.empty1).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest1).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero1).setVisibility(View.VISIBLE);
                break;
            case 2:
                findViewById(R.id.empty2).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest2).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero2).setVisibility(View.VISIBLE);
                break;
            case 3:
                findViewById(R.id.empty3).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest3).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero3).setVisibility(View.VISIBLE);
                break;
            case 4:
                findViewById(R.id.empty4).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest4).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero4).setVisibility(View.VISIBLE);
                break;
            case 5:
                findViewById(R.id.empty5).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest5).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero5).setVisibility(View.VISIBLE);
                break;
            case 6:
                findViewById(R.id.empty6).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest6).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero6).setVisibility(View.VISIBLE);
                break;
                case 7:
                findViewById(R.id.empty7).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest7).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero7).setVisibility(View.VISIBLE);
                break;
                case 8:
                findViewById(R.id.empty8).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest8).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero8).setVisibility(View.VISIBLE);
                break;
            case 9:
                findViewById(R.id.empty9).setVisibility(INVISIBLE);
                if (s.equals("crest"))findViewById(R.id.crest9).setVisibility(View.VISIBLE);
                else findViewById(R.id.zero9).setVisibility(View.VISIBLE);
                break;
        }
    }

}
