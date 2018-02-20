package com.crash.etranzact.collapsingtoolbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class slideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    //list of images
    public int[]list_images={
            R.drawable.circle1,
            R.drawable.circle2,
            R.drawable.circle1,
    };
//list of Tites
    public String[]titles = {"1Bank","Smart Locator","OneBank.Com"};

    //list of discription
    public String[]description= {"Information is key with 1Bank get to Know your Bank better.",
            "get all service offered by your Bank without traveling to your bank \n easy and saves time",
            "Launch into the world of possibilities"};

    //list of background colors
    public int[]color = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,40,89),

    };

    public slideAdapter (Context context){
        this.context=context;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout)view.findViewById(R.id.slidelinear);
        ImageView imgslide = (ImageView) view.findViewById(R.id.sliding);
        TextView txtslide = (TextView)view.findViewById(R.id.titletext);
        TextView txtdescr = (TextView)view.findViewById(R.id.textdescription);

        layoutslide.setBackgroundColor(color[position]);
        imgslide.setImageResource(list_images[position]);
        txtslide.setText(titles[position]);
        txtdescr.setText(description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
