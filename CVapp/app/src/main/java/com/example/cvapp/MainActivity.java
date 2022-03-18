package com.example.cvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    Button next;
    EditText name,age,job,phoneNum,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.Name);
        age = findViewById(R.id.Age);
        job = findViewById(R.id.Job);
        phoneNum = findViewById(R.id.PhoneNumber);
        email = findViewById(R.id.Email);

        Intent info = new Intent(MainActivity.this, MainActivity2.class);


        next = findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "your info", Toast.LENGTH_SHORT).show();

                String n = name.getText().toString();
                int a = Integer.parseInt(age.getText().toString());
                String j = job.getText().toString();
                int p = Integer.parseInt(phoneNum.getText().toString());
                String e = email.getText().toString();

                info.putExtra("theName", n);
                info.putExtra("theAge", a);
                info.putExtra("theJob", j);
                info.putExtra("theNum", p);
                info.putExtra("theEmail", e);

                startActivity(info);

            }
        });

        name.addTextChangedListener(textWatcher);
        age.addTextChangedListener(textWatcher);
        job.addTextChangedListener(textWatcher);
        phoneNum.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String n = name.getText().toString().trim();
            String a = age.getText().toString().trim();
            String j = job.getText().toString().trim();
            String p = phoneNum.getText().toString().trim();
            String e = email.getText().toString().trim();

            next.setEnabled(!n.isEmpty() && !a.isEmpty() && !j.isEmpty() && !p.isEmpty() && !e.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}


