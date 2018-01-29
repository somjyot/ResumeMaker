package com.som.resumemaker;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText name,email,phone,pass;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText)findViewById(R.id.nameregistration);
        email=(EditText)findViewById(R.id.emailregistration);
        phone=(EditText)findViewById(R.id.phoneregistration);
        pass=(EditText)findViewById(R.id.passregistration);
        reg=(Button)findViewById(R.id.regbtn);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            DataBaseHelper dataBaseHelper=new DataBaseHelper(Registration.this);
                SQLiteDatabase db=dataBaseHelper.getWritableDatabase();
            boolean response=dataBaseHelper.insertData(name.getText().toString(),email.getText().toString(),pass.getText().toString(),
                    phone.getText().toString(),db);
                if(response==true)
                {
                    Intent i=new Intent(Registration.this,MainActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(Registration.this, "Unable To insert", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
