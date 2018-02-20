package com.crash.etranzact.collapsingtoolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;

public class CustomerService extends AppCompatActivity {
    ListView listView;
    KenBurnsView kenView;
    TextView btncall;

    int[]images = {R.drawable.gtbank,
            R.drawable.diamond,
            R.drawable.ecobank,
            R.drawable.uba,
            R.drawable.stanbic,
            R.drawable.firstbank,
            R.drawable.sky,
            R.drawable.union,
            R.drawable.wema,
            R.drawable.fcmb,
            R.drawable.fidelity,
    };

        String[]names = {"07007007000","08121461142","0905536277","08121461142","0700 2255 782 6242","2347080625000","08121461142","07007007000","08121461142","0700 2255 782 6242"," 3355"};

    int[]phone = {R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        btncall =(TextView) findViewById(R.id.btncall);
        listView = (ListView) findViewById(R.id.listview);
        kenView = (KenBurnsView) findViewById(R.id.kenView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            }
            class CustomAdapter extends BaseAdapter{

                @Override
                public int getCount() {
                    return images.length;
                }

                @Override
                public Object getItem(int position) {
                    return null;
                }

                @Override
                public long getItemId(int position) {
                    return 0;
                }

                @Override
                public View getView(final int position, View convertView, ViewGroup parent) {
                    View view = getLayoutInflater().inflate(R.layout.list_item,null);

                    ImageView imageView = view.findViewById(R.id.mImageView);
                    ImageView imageView1 = view.findViewById(R.id.mImageView1);
                    TextView mTextview = view.findViewById(R.id.tv);
                    imageView.setImageResource(images[position]);
                    imageView1.setImageResource(phone[position]);
                    mTextview.setText(names[position]);

                    mTextview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ names[position]));
                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            startActivity(intent);

                        }
                    });

                    return view;
                }


            }

}
