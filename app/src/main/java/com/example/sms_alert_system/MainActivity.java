package com.example.sms_alert_system;

import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.animation.ChildrenAlphaProperty;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    Hashtable<String,String> students = new Hashtable<>();
    String rollnum,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students.put("211FA18029","6305524392");
        students.put("211FA18006","9959520328");


        EditText roll = findViewById(R.id.editTextText);
        Button absent = findViewById(R.id.button);
        Button custom = findViewById(R.id.button2);

        absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollnum = roll.getText().toString();
                if (students.containsKey(rollnum)) {
//
                    SmsManager sms = SmsManager.getDefault();
                    mobile = students.get(rollnum);
                    sms.sendTextMessage(mobile,null,"Your child is Bunked The class",null,null);

                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getApplicationContext(),"Student Details Are Missing",Toast.LENGTH_SHORT).show();
                }
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollnum = roll.getText().toString();
                if (students.containsKey(rollnum)) {
                    mobile = students.get(rollnum);
                    Intent i = new Intent(MainActivity.this,CustomMessage.class);
                    i.putExtra("mobile",mobile);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error Occured",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}