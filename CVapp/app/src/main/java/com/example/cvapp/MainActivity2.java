package com.example.cvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView a = findViewById(R.id.userName);
        TextView b = findViewById(R.id.userAge);
        TextView c = findViewById(R.id.userJob);
        TextView d = findViewById(R.id.userNum);
        TextView e = findViewById(R.id.userEmail);

        final String[] num = new String[1];
        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num[0] = d.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ Uri.encode(num[0])));
                startActivity(intent);
            }
        });


        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("theName");
        int age = bundle.getInt( "theAge");
        String job = bundle.getString("theJob");
        int number = bundle.getInt("theNum");
        String email = bundle.getString("theEmail");

        a.setText(name);
        b.setText(age + "");
        c.setText(job);
        d.setText(number + "");
        e.setText(email);

    }
}