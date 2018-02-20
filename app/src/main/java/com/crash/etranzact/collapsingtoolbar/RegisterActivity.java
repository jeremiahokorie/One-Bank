package com.crash.etranzact.collapsingtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class RegisterActivity extends AppCompatActivity {
  KenBurnsView view;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      //view = (KenBurnsView) findViewById(R.id.view);
    }
}
