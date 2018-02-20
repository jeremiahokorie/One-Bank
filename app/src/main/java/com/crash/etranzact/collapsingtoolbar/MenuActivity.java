package com.crash.etranzact.collapsingtoolbar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class MenuActivity extends AppCompatActivity {
    private Intent googleMap;
    CardView btnBanks;
    CardView customerbtn;
    CardView Mapbtn;
    CardView ussd;
    ImageButton btnGallery;
    CardView btnUpload;
    KenBurnsView view;
    TextView btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //view =(KenBurnsView)findViewById(R.id.view);

        btnBanks = (CardView) findViewById(R.id.banks);
        customerbtn = (CardView) findViewById(R.id.customerbtn);
        Mapbtn = (CardView) findViewById(R.id.btnMap);
        ussd = (CardView) findViewById(R.id.ussd);
        btnGallery = (ImageButton) findViewById(R.id.gallery);
        btnlogout = (TextView) findViewById(R.id.btnlogout);

        btnUpload = (CardView) findViewById(R.id.btnUpload);

        btnBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        customerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, CustomerService.class);
                startActivity(i);
            }
        });
        Mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               googleMap = new Intent(Intent.ACTION_VIEW);
                googleMap.setData(Uri.parse("geo:0,0?q=le louvre,France"));
                googleMap.setData(Uri.parse("geo:11.085541, 7.719945 Zaria,Nigeria"));
                startActivity(googleMap);
            }
        });
        ussd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ussd = new Intent(MenuActivity.this, USSDActivity.class);
                startActivity(ussd);
            }
        });
    }

    public void btnUpload(View view) {
        Intent Add = new Intent(MenuActivity.this, UploadProfile.class);
        startActivity(Add);
    }
    public  void btnlogout (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

}
