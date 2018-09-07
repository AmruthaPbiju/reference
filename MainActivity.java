package com.example.amritha.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText rolno,name,branch;
    Button btnsubmit;
    dbstudent db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new dbstudent(getApplicationContext());
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        rolno=(EditText)findViewById(R.id.edrolno);

        name=(EditText)findViewById(R.id.edname);

        branch=(EditText)findViewById(R.id.edbranch);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stuNo=rolno.getText().toString();
                String stuName=name.getText().toString();
                String stuBranch=branch.getText().toString();

                db.studentinfo(stuNo,stuName,stuBranch);
                Toast.makeText(MainActivity.this,"Successfully Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
