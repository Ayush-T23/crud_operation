package com.example.crud_operation;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name,contact,dob;
    Button insert ,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        delete=findViewById(R.id.btndelete);
        insert=findViewById(R.id.btninsert);
        DBHelper DB=new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText= name.getText().toString();
                String contactText= contact.getText().toString();
                String dobText= dob.getText().toString();

                Boolean checkinsertdata= DB.insertuserdata(nameText,contactText,dobText);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this,"new entry inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"new entry  not inserted",Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText= name.getText().toString();

                Boolean deletedata= DB.deletedata(nameText);
                if(deletedata==true)
                {
                    Toast.makeText(MainActivity.this," entry deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this," entry  not deleted",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}