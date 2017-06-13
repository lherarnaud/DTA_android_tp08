package com.example.admin.dta_android_tp8;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButtonClassic = (Button)findViewById(R.id.send_classic_button);
        Button sendButtonSmsManager = (Button)findViewById(R.id.send_direct_button);

        final EditText ctl_edit_number = (EditText) findViewById(R.id.sender_number);
        final EditText ctl_edit_message = (EditText) findViewById(R.id.message_body);


        sendButtonClassic.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String phoneNumber = ctl_edit_number.getText().toString();
                String smsBody = ctl_edit_message.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
                intent.putExtra("sms_body", smsBody);
                startActivity(intent);
            }
        });

        sendButtonSmsManager.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String phoneNumber = ctl_edit_number.getText().toString();
                String smsBody = ctl_edit_message.getText().toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null);
            }
        });
    }
}
