package com.som.resumemaker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView namev,adressv,summaryv,workv,educationv,skillv,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        namev=(TextView)findViewById(R.id.nameview);
        adressv=(TextView)findViewById(R.id.adressview);
        summaryv=(TextView)findViewById(R.id.summaryview);
        workv=(TextView)findViewById(R.id.workview);
        educationv=(TextView)findViewById(R.id.educationview);
        skillv=(TextView)findViewById(R.id.skillview);
        contact=(TextView)findViewById(R.id.contactview);
        DBHelper dataBaseHelper=new DBHelper(this);
        SQLiteDatabase db=dataBaseHelper.getReadableDatabase();
        Cursor cursor=dataBaseHelper.view(getIntent().getStringExtra("ID"),db);
        cursor.moveToFirst();
        String name=cursor.getString(1);
        namev.setText(name);
        String cont=cursor.getString(3)+" * "+cursor.getString(4);
        contact.setText(cont);
        adressv.setText(cursor.getString(2));
        summaryv.setText(cursor.getString(14));
        String work=cursor.getString(5)+" At "+cursor.getString(6)+"\n"+
                "From "+cursor.getString(7)+" to "+cursor.getString(8)+"\n";
        workv.setText(work);
        String education=cursor.getString(9)+","+cursor.getString(10)+"\n"
                +cursor.getString(11)+","+cursor.getString(12);
        educationv.setText(education);
        skillv.setText(cursor.getString(13));
    }
}
