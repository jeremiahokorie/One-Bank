package com.crash.etranzact.collapsingtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class NewMenu extends AppCompatActivity {
    KenBurnsView kenBurnsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_menu);
        kenBurnsView = (KenBurnsView) findViewById(R.id.kenburns);
    }
}
