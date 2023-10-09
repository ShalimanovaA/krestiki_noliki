package com.angi_sh.krestiki_noliki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        String player1 = "";
        //Toast.makeText(this, "+", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.crest:
                player1 = "crest";
                break;
            case R.id.zero:
                player1 = "zero";
                break;
        }
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("player1", player1);
        startActivity(intent);
    }
}