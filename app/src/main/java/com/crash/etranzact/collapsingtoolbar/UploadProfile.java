package com.crash.etranzact.collapsingtoolbar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.crash.etranzact.collapsingtoolbar.R.id.etBank;
import static com.crash.etranzact.collapsingtoolbar.R.id.etName;
import static com.crash.etranzact.collapsingtoolbar.R.id.gallery;

public class UploadProfile extends AppCompatActivity {
    private static final int CALLREQ = 1;
    private Uri uri = null;
    ImageButton imageButton;
    Button UploadButton;
    EditText Name, Bank;
    Button Viewprofile;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_profile);

        imageButton = (ImageButton) findViewById(R.id.gallery);
        UploadButton = (Button) findViewById(R.id.UploadButton);
        Name = (EditText) findViewById(etName);
        Bank = (EditText) findViewById(R.id.etBank);
        Viewprofile = (Button) findViewById(R.id.Viewprofile);
        btnBack = (Button)findViewById(R.id.btnBack);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(Intent.ACTION_GET_CONTENT);
                camera.setType("image/*");
                startActivityForResult(camera, CALLREQ);
            }
        });

        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Name.getText().toString().isEmpty() && !Bank.getText().toString().isEmpty()) {

                    String string = Name.getText().toString();
                    String str = Bank.getText().toString();


                    Intent i = new Intent(getApplicationContext(), ViewProfileActivity.class);
                    i.putExtra("Name", string);
                    i.putExtra("Bank", str);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all required fields", Toast.LENGTH_LONG).show();
                }


            }
        });
//
//        Viewprofile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent view = new Intent(UploadProfile.this,ViewProfileActivity.class);
//                startActivity(view);
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALLREQ && resultCode == RESULT_OK) {
            uri = data.getData();
            imageButton.setImageURI(uri);
        }
    }

    public void Viewprofile(View view) {
        Intent viewprofile = new Intent(getApplicationContext(), ViewProfileActivity.class);
        startActivity(viewprofile);
    }
    public void btnBack (View view){
        finish();
    }
}
