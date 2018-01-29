package com.som.resumemaker;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Resume extends AppCompatActivity {
    EditText name,adress,email,phone,employe,job,start,end,colage,city,degree,graduation,skill,summary;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        name=(EditText)findViewById(R.id.nameresume);
        adress=(EditText)findViewById(R.id.adressresume);
        email=(EditText)findViewById(R.id.emailresume);
        phone=(EditText)findViewById(R.id.phoneresume);
        employe=(EditText)findViewById(R.id.employerresume);
        job=(EditText)findViewById(R.id.jobresume);
        start=(EditText)findViewById(R.id.startresume);
        end=(EditText)findViewById(R.id.endresume);
        colage=(EditText)findViewById(R.id.schoolresume);
        city=(EditText)findViewById(R.id.cityresume);
        degree=(EditText)findViewById(R.id.degreeresume);
        graduation=(EditText)findViewById(R.id.graduationresume);
        skill=(EditText)findViewById(R.id.skillresume);
        summary=(EditText)findViewById(R.id.summaryresume);
        submit=(Button)findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dataBaseHelper=new DBHelper(Resume.this);
                SQLiteDatabase db=dataBaseHelper.getWritableDatabase();

                boolean response=dataBaseHelper.resume(getIntent().getStringExtra("ID"),name.getText().toString(),adress.getText().toString(),phone.getText().toString(),
                        email.getText().toString(),employe.getText().toString(),job.getText().toString(),start.getText().toString(),
                        end.getText().toString(),colage.getText().toString(),city.getText().toString(),degree.getText().toString(),
                        graduation.getText().toString(),skill.getText().toString(),summary.getText().toString(),db);
                if(response==true)
                {
                    Toast.makeText(Resume.this, "Resume is created", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Resume.this,Welcome1.class);
                    i.putExtra("ID",getIntent().getStringExtra("ID"));
                    startActivity(i);
                    //Toast.makeText(Resume.this, getIntent().getStringExtra("ID"), Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(Resume.this, "Unable TO insert", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
