package com.example.pabji.appturistica.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pabji.appturistica.R;
import com.example.pabji.appturistica.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,mainFragment).commit();
    }
}
