package com.example.amritha.bloodconnectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class newUser extends AppCompatActivity {
    EditText edname,edaddress,edmobile,edusername,edloginpasword,edid;
    Button btnsubmit;
    Spinner spinnerblood,spinnerdist,spinnertype;
    dbBlood db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        db=new dbBlood(getApplicationContext());
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        edname=(EditText)findViewById(R.id.edname);
        edaddress=(EditText)findViewById(R.id.edaddress);
        edmobile=(EditText)findViewById(R.id.edmobile);
        edusername=(EditText)findViewById(R.id.edusername);
        edloginpasword=(EditText)findViewById(R.id.edloginpasword);
        edid=(EditText)findViewById(R.id.edid);


        spinnerblood=(Spinner)findViewById(R.id.spinnerblood);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerblood.setAdapter(adapter);



        spinnerdist=(Spinner)findViewById(R.id.spinnerdist);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.blood_dist, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdist.setAdapter(adapter1);

        spinnertype=(Spinner)findViewById(R.id.spinnertype);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.blood_type, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(adapter2);



        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edname.getText().toString();
                String uaddress=edaddress.getText().toString();
                String umobile=edmobile.getText().toString();
                String uusername=edusername.getText().toString();
                String useupassword=edloginpasword.getText().toString();
                String uid=edid.getText().toString();
                String utype=spinnertype.getSelectedItem().toString();
                String udistrict=spinnerdist.getSelectedItem().toString();
                String ubloodgroup=spinnerblood.getSelectedItem().toString();

                db.add(uid,username,uaddress,umobile,uusername,useupassword,utype,udistrict,ubloodgroup);
                Toast.makeText(getApplicationContext(),"Your Registration is successfully completed!!!!!",Toast.LENGTH_LONG).show();
            }
        });
//
//




    }
}
