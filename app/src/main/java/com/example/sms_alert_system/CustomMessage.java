package com.example.sms_alert_system;

import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CustomMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_message);

        Button send = findViewById(R.id.button3);
        EditText content = findViewById(R.id.editTextText2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                SmsManager sms = SmsManager.getDefault();
                String mobile = i.getStringExtra("mobile");
                String message = content.getText().toString();
                sms.sendTextMessage(mobile,null,message,null,null);
                Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_SHORT).show();
            }
        });
    }
}