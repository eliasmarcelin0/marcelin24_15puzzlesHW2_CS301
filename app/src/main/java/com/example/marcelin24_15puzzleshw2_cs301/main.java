package com.example.marcelin24_15puzzleshw2_cs301;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        boardView boardView = findViewById(R.id.boardView);


    }

}
