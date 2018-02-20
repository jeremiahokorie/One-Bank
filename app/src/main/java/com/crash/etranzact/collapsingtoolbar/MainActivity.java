package com.crash.etranzact.collapsingtoolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.bridge.BasicAuthentication;
import com.afollestad.bridge.Bridge;
import com.afollestad.bridge.BridgeException;
import com.afollestad.bridge.Callback;
import com.afollestad.bridge.Request;
import com.afollestad.bridge.Response;
import com.flaviofaria.kenburnsview.KenBurnsView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    EditText User, Pass, channel;
    CardView Login;
    TextView Register;
    KenBurnsView kenview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText) findViewById(R.id.etUser);
        Pass = (EditText) findViewById(R.id.etPass);
        Login = (CardView) findViewById(R.id.cardView);
        Register = (TextView) findViewById(R.id.tvRegister);
        kenview = (KenBurnsView) findViewById(R.id.kenview);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("YYYYYYYYYYYYYYYYYY", "SUCCESbhhhhhhhhhhhhhhhhS");

                try {

                    if (!User.getText().toString().isEmpty() && !Pass.getText().toString().isEmpty()) {

                        if (progressDialog == null) {
                            progressDialog = new ProgressDialog(MainActivity.this);
                            progressDialog.setCanceledOnTouchOutside(true);
                            progressDialog.getWindow().addFlags(Window.FEATURE_NO_TITLE);
                            progressDialog.setMessage("Authenticating...");
                            progressDialog.show();
                        }

                        try {
                            JSONObject json = new JSONObject();
                            json.put("identifier", User.getText().toString());
                            json.put("password", Pass.getText().toString());
                            json.put("channel", "Mobile-Android");
                            String url = " http://18.217.216.141:8080/cisis/apiv1/authenticate/login";
                            //BasicAuthentication auth = BasicAuthentication.create("jerry", "test1234");

                            Bridge.post(url).header("Content-Type", "application/json")
                                    .header("Authorization", "Basic amVycnk6dGVzdDEyMzQ=")
                                    .body(json)
                                    .request(new Callback() {
                                        @Override
                                        public void response(Request request, Response response, BridgeException e) {
                                            try {
                                                if (e == null && response != null) {

                                                    if (response.isSuccess()) {

                                                        try {

                                                            if (response.isSuccess()) {
                                                                Log.d("RESPONSE", response.toString());
                                                                JSONObject jsonObj = response.asJsonObject();
                                                                int respCode = jsonObj.getInt("responseCode");
                                                                if (respCode == 0) {
                                                                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                                                    startActivity(intent);
                                                                    Toast.makeText(getApplicationContext(), "You are now loged in", Toast.LENGTH_LONG).show();

                                                                } else {
                                                                    Toast.makeText(getApplicationContext(), jsonObj.getString("responseMsg"), Toast.LENGTH_LONG).show();

                                                                }
                                                                // getApplicationContext();

                                                            } else {
                                                                Toast.makeText(getApplicationContext(), "Incorrect Username or password", Toast.LENGTH_LONG).show();
                                                            }
                                                        } catch (Exception ex) {

                                                            ex.printStackTrace();
                                                        }
                                                        String responseContent = response.asString();
                                                        Log.v("Success", responseContent);
                                                    } else {
                                                        Log.v("error", response.toString());
                                                    }
                                                } else {
                                                    e.printStackTrace();

                                                }
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        progressDialog.show();
                        Log.d("login failed", "Username and Password Required");
                        Toast.makeText(getApplicationContext(), "Username and Password Required", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void Registerbtn(View view) {
        Intent i = new Intent(this, FormActivity.class);
        startActivity(i);
    }

}
