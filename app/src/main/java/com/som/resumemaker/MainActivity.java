package com.som.resumemaker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.loginbtn);
        signin=(TextView)findViewById(R.id.signbtn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Registration.class);
                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
                SQLiteDatabase db=dataBaseHelper.getReadableDatabase();
                Cursor cursor=dataBaseHelper.search(email.getText().toString(),db);
                DBHelper dbHelper=new DBHelper(MainActivity.this);
                SQLiteDatabase dbb=dbHelper.getReadableDatabase();
                cursor.moveToFirst();

                if(cursor.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Email", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ( cursor.getString(3).equals(password.getText().toString()))
                    {
                        Cursor check=dbHelper.view(cursor.getString(0),dbb);
                        check.moveToFirst();
                        if (check.getCount() == 0) {
                            Intent i = new Intent(MainActivity.this, Welcome.class);
                            i.putExtra("ID", cursor.getString(0));
                            startActivity(i);
                        }
                        else
                            {
                            Intent j = new Intent(MainActivity.this, Welcome1.class);
                            j.putExtra("ID", cursor.getString(0));
                            startActivity(j);
                            }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
