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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class USSDActivity extends AppCompatActivity {
    ListView ussdView;
    Button btnBack;
    KenBurnsView kenView;

    int[] images = {R.drawable.gtbank,
            R.drawable.diamond,
            R.drawable.ecobank,
            R.drawable.uba,
            R.drawable.stanbic,
            R.drawable.firstbank,
            R.drawable.sky,
            R.drawable.union,
            R.drawable.wema,
            R.drawable.fcmb,
            R.drawable.zenith,
            R.drawable.fidelity,
            R.drawable.access,

    };
    String[] names = {"*737#", "*910#", "*326#", "*919#", "*737#", "*894#", "*833#", "*737#", "*322#", "*389#", "*966#", "*770#", "*901#"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd);
        kenView = (KenBurnsView) findViewById(R.id.KenView1);
        ussdView = (ListView) findViewById(R.id.ussdView);
        btnBack = (Button) findViewById(R.id.btnBack);
        UssdAdapter ussdAdapter = new UssdAdapter();
        ussdView.setAdapter(ussdAdapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    class UssdAdapter extends BaseAdapter {

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
            View view = getLayoutInflater().inflate(R.layout.ussd_list_item, null);

            ImageView imageView = view.findViewById(R.id.bank);
            TextView textView = view.findViewById(R.id.ussd);
            imageView.setImageResource(images[position]);
            textView.setText(names[position]);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + names[position]));
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
                    String encodedHash = Uri.encode("#");
                    String ussd = "*" + encodedHash + names[position] + Uri.encode("#");
                    startActivity(intent);
                }
            });
            return view;


        }


    }

}
