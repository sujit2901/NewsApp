package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText email,password,phone;
    Button Register;
    RadioButton male,female;
    CheckBox Policy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        Register=findViewById(R.id.button);
        male=findViewById(R.id.radioButton);
        female=findViewById(R.id.radioButton2);
        Policy=findViewById(R.id.checkBox);
        String Gender="";

        if (male.isChecked()){
            Gender="male";
        }
        else if(female.isChecked()){
            Gender="female";

        }
        String accept="";
        if (Policy.isChecked()){
            accept="Accept";
        }
        else{
            accept="Not Accepted";
        }
        String message=email.getText().toString()+"\n"+password.getText().toString()+"\n"+phone.getText().toString()+"\n"+Gender+"\n"+accept;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Details");
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }
}