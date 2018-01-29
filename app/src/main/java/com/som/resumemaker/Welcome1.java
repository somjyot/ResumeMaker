package com.som.resumemaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Welcome1 extends AppCompatActivity {
    Button view,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);
        view=(Button)findViewById(R.id.viewbtn);
        update=(Button)findViewById(R.id.updatebtn);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Welcome1.this,ViewActivity.class);
                i.putExtra("ID",getIntent().getStringExtra("ID"));
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Welcome1.this,Update.class);
                i.putExtra("ID",getIntent().getStringExtra("ID"));
                startActivity(i);

            }
        });
    }
}
