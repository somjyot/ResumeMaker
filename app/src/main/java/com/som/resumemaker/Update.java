package com.som.resumemaker;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText name,adress,email,phone,employe,job,start,end,colage,city,degree,graduation,skill,summary;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        name=(EditText)findViewById(R.id.nameupdate);
        adress=(EditText)findViewById(R.id.adressupdate);
        email=(EditText)findViewById(R.id.emailupdate);
        phone=(EditText)findViewById(R.id.phoneupdate);
        employe=(EditText)findViewById(R.id.employerupdate);
        job=(EditText)findViewById(R.id.jobupdate);
        start=(EditText)findViewById(R.id.startupdate);
        end=(EditText)findViewById(R.id.endupdate);
        colage=(EditText)findViewById(R.id.schoolupdate);
        city=(EditText)findViewById(R.id.cityupdate);
        degree=(EditText)findViewById(R.id.degreeupdate);
        graduation=(EditText)findViewById(R.id.graduationupdate);
        skill=(EditText)findViewById(R.id.skillupdate);
        summary=(EditText)findViewById(R.id.summaryupdate);
        update=(Button)findViewById(R.id.updatebtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper=new DBHelper(Update.this);
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                final boolean check=dbHelper.update(getIntent().getStringExtra("ID"),name.getText().toString(),adress.getText().toString(),phone.getText().toString(),
                        email.getText().toString(),employe.getText().toString(),job.getText().toString(),start.getText().toString(),
                        end.getText().toString(),colage.getText().toString(),city.getText().toString(),degree.getText().toString(),
                        graduation.getText().toString(),skill.getText().toString(),summary.getText().toString(),db);
                if(check==true)
                {
                    Toast.makeText(Update.this, "Resume Is Updated", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Update.this,Welcome1.class);
                    i.putExtra("ID",getIntent().getStringExtra("ID"));
                    startActivity(i);

                }
                else
                    Toast.makeText(Update.this, "Unable To Update", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
