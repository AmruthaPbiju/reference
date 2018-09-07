package com.example.amritha.bloodconnectapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class donorsearch extends AppCompatActivity {
    Spinner spinnerblood,spinnerdist;
    dbBlood db;
    Button btnsearchblood,btnseachdonor;
    TextView edseachname,edseachadrs,edseachmob;
    String dname,daddress,dmob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorsearch);
        db=new dbBlood(getApplicationContext());
        spinnerblood=(Spinner)findViewById(R.id.spinnerblood);
        edseachname=(TextView) findViewById(R.id.edseachname);
        edseachadrs=(TextView) findViewById(R.id.edseachadrs);
        edseachmob=(TextView) findViewById(R.id.edseachmob);
        btnseachdonor=(Button)findViewById(R.id.btnseachdonor);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerblood.setAdapter(adapter);
      //  String selectedItem=spinnerdist.getSelectedItem().toString();


        btnseachdonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchblood=spinnerblood.getSelectedItem().toString();
                Cursor cursor=db.searchdonor(searchblood);
                if (cursor.getCount()!=0)
                {
                    try{
                        if(cursor.moveToFirst()){
                            dname=cursor.getString(cursor.getColumnIndex("name"));
                            daddress=cursor.getString(cursor.getColumnIndex("address"));
                            dmob=cursor.getString(cursor.getColumnIndex("mobile"));


                        }
                        edseachname.setText(dname);
                        edseachadrs.setText(daddress);
                        edseachmob.setText(dmob);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
