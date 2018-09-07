package com.example.amritha.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Selection extends AppCompatActivity {
EditText edsel;
    Button btnsel;
    TextView name,branch;
    dbstudent db;
    String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        btnsel=(Button)findViewById(R.id.btnsearch);
        edsel=(EditText)findViewById(R.id.edselrolno);
        name=(TextView)findViewById(R.id.nameview);
        branch=(TextView)findViewById(R.id.branchview);
        db=new dbstudent (getApplicationContext());
        btnsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selid=edsel.getText().toString();
                Cursor cursor=db.select(selid);
                if (cursor.getCount()!=0)
                {
                    try{
                        if(cursor.moveToFirst()){
                            a=cursor.getString(cursor.getColumnIndex("name"));
                            b=cursor.getString(cursor.getColumnIndex("branch"));


                        }

                        name.setText(a);
                        branch.setText(b);
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
