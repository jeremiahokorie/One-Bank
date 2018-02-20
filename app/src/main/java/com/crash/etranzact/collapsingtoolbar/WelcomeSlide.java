package com.crash.etranzact.collapsingtoolbar;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeSlide extends AppCompatActivity {
    private ViewPager viewPager;
    private slideAdapter myAdapter;
    Button ButtonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ButtonStart =(Button) findViewById(R.id.btnStart);
        myAdapter = new slideAdapter(this);
        viewPager.setAdapter(myAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 2)

                    ((Button) findViewById(R.id.btnStart)).setVisibility(Button.VISIBLE);
                else
                    ((Button) findViewById(R.id.btnStart)).setVisibility(Button.GONE);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(WelcomeSlide.this,MainActivity.class);
                startActivity(start);
            }
        });

    }
}
