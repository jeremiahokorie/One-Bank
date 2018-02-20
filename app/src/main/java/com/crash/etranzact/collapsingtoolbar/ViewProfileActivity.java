package com.crash.etranzact.collapsingtoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewProfileActivity extends AppCompatActivity {
   TextView username;
    TextView Bankname;
    ImageView IvImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        username = (TextView) findViewById(R.id.username);
        Bankname = (TextView) findViewById(R.id.Bankname);
        IvImage = (ImageView) findViewById(R.id.IvImage);

        Intent intent = getIntent();
        String string = intent.getStringExtra("Name");
        String str = intent.getStringExtra("Bank");

        username.setText(string);
        Bankname.setText(str);


    }
}
