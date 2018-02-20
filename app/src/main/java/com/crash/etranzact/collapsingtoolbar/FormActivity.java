package com.crash.etranzact.collapsingtoolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.bridge.Bridge;
import com.afollestad.bridge.BridgeException;
import com.afollestad.bridge.Callback;
import com.afollestad.bridge.Request;
import com.afollestad.bridge.Response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class FormActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    EditText fName, LName, Email, HAddress, Mphone, UserType, pswd;
    TextView Dob;
    TextView BackToLogin;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ShowdialogTvClick();

        fName = (EditText) findViewById(R.id.fName);
        LName = (EditText) findViewById(R.id.etLName);
        Email = (EditText) findViewById(R.id.etEmail);
        HAddress = (EditText) findViewById(R.id.etAddress);
        Mphone = (EditText) findViewById(R.id.etPhone);
        Dob = (TextView) findViewById(R.id.etDOB);
        UserType = (EditText) findViewById(R.id.userType);
        pswd = (EditText) findViewById(R.id.etPassword);
        BackToLogin = (TextView) findViewById(R.id.login);
        Submit = (Button) findViewById(R.id.btnSubmit);


        Submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.d("vvvvvvvvvvvvvvv", "ffffffffffffffffffff");

                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(FormActivity.this);
                    progressDialog.setCanceledOnTouchOutside(true);
                    progressDialog.getWindow().addFlags(Window.FEATURE_NO_TITLE);
                    progressDialog.setMessage("Please Wait....");
                    progressDialog.show();
                }
                try {
                    Integer.parseInt(Mphone.getText().toString());
                    Integer.parseInt(Dob.getText().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


                if (!fName.getText().toString().isEmpty() && !LName.getText().toString().isEmpty() && !Email.getText().toString().isEmpty() && !Mphone.getText().toString().isEmpty() && !Dob.getText().toString().isEmpty() && !pswd.getText().toString().isEmpty() && !UserType.getText().toString().isEmpty()) {
                    Log.d("hhhhhhhhh", "mmmmmmmmmmmmmmmm");
                    try {
                        JSONObject jsonobj = new JSONObject();
                        jsonobj.put("firstName", fName.getText().toString());
                        jsonobj.put("lastName", LName.getText().toString());
                        jsonobj.put("email", Email.getText().toString());
                        jsonobj.put("phone", Mphone.getText().toString());
                        jsonobj.put("password", pswd.getText().toString());
                        jsonobj.put("dob", Dob.getText().toString());
                        jsonobj.put("userType", UserType.getText().toString());
                        jsonobj.put("channel", "Mobile-Android");
                        String url = " http://18.217.216.141:8080/cisis/apiv1/authenticate/register";

                        Log.d("URL", url.toString());
                        Log.d("JSONOBJ", jsonobj.toString());

                        Bridge.post(url).header("Content-Type", "application/json")
                                .header("Authorization", "Basic amVycnk6dGVzdDEyMzQ=")
                                .body(jsonobj)
                                .request(new Callback() {
                                    @Override
                                    public void response(Request request, Response response, BridgeException e) {
                                        try {

                                            if (e == null && response != null) {
                                                Log.i("Response", response.toString());

                                                if (response.isSuccess()) {
                                                    try {
                                                        if (response.isSuccess()) {
                                                            Log.d("RESPONSE", response.toString());
                                                            JSONObject jsonObj = response.asJsonObject();
                                                            AlertDialog.Builder builder1 = new AlertDialog.Builder(FormActivity.this);
                                                            builder1.setMessage("Successfully Registered");
                                                            builder1.setCancelable(true);

                                                            builder1.setPositiveButton(
                                                                    "Login",
                                                                    new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int id) {
                                                                            Intent i = new Intent(FormActivity.this, MainActivity.class);
                                                                            startActivity(i);
                                                                            finish();
                                                                            dialog.cancel();
                                                                        }
                                                                    });

                                                            builder1.setNegativeButton(
                                                                    "Exit",
                                                                    new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int id) {
                                                                            dialog.cancel();
                                                                        }
                                                                    });

                                                            AlertDialog alert11 = builder1.create();
                                                            alert11.show();
                                                            Toast.makeText(getApplicationContext(), "You Have Successfully Registered  ", Toast.LENGTH_LONG).show();
                                                            progressDialog.dismiss();
//                                                            String firstName = jsonObj.getString("firstName");
//                                                            Log.d(TAG,firstName);
                                                            int respCode = jsonObj.getInt("responseCode");
                                                            if (respCode == 0) {
//                                                                Toast.makeText(getApplicationContext(), jsonObject.getString("responseMsg"), Toast.LENGTH_LONG).show();
                                                                //Toast.makeText(getApplicationContext(), "Successful login  ", Toast.LENGTH_LONG).show();
                                                            } else {
                                                                Toast.makeText(getApplicationContext(), jsonObj.getString("responseMsg"), Toast.LENGTH_LONG).show();
                                                            }
                                                        } else {
                                                            Toast.makeText(getApplicationContext(), "User already Exist  ", Toast.LENGTH_LONG).show();
                                                        }

                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }

                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else {

                    Toast.makeText(getApplicationContext(), "Please ensure that all required fields are correctly filled.", Toast.LENGTH_LONG).show();


                }
            }
        });
    }
    public void BackToLogin(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void ShowdialogTvClick() {
        Dob = (TextView) findViewById(R.id.etDOB);
        Dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) ;
        return new DatePickerDialog(this, DPickerListener, year_x, month_x, day_x);
    }

    private DatePickerDialog.OnDateSetListener DPickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            Toast.makeText(FormActivity.this, year_x + "-" + month_x + "-" + day_x + "-", Toast.LENGTH_LONG).show();

            String finalYear = String.valueOf(year_x + "-") + String.valueOf(month_x + "-") + String.valueOf(day_x);
            Dob.setText(finalYear);
        }
    };
}