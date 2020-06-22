package com.example.myapp.presentation.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.myapp.R;
import com.example.myapp.SheredPref;
import com.example.myapp.intro.IntroActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progress_horizontal);
        progressBar.setProgress(100);

        boolean isShow = new SheredPref(this).isShown();

        if(!isShow){
            startActivity(new Intent(this, IntroActivity.class));
        }


    }
}
