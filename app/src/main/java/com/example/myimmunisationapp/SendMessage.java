package com.example.myimmunisationapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SendMessage extends AppCompatActivity {

    Button btnSendSMS;

    IntentFilter intentFilter;

    //broadcast receiver.....
    private BroadcastReceiver intentReceiver=new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub

            TextView SMSes=(TextView) findViewById(R.id.textView1);

            SMSes.setText(intent.getExtras().getString("sms"));

        }



    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.smsmain);
        //requesting for permission for the content provider.

        ActivityCompat.requestPermissions(SendMessage.this, new String[]{android.Manifest.permission.READ_CONTACTS},1);
        ListView listview;
        ArrayList myarray=new ArrayList();
        //---intent to filter for SMS messages received..

        intentFilter=new IntentFilter();

        intentFilter.addAction("SMS_RECEIVED_ACTION");
        listview=(ListView)findViewById(R.id.listview);
        Cursor c=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while (c.moveToNext()){
            String name=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            myarray.add(name);

        }
        listview.setAdapter(new ArrayAdapter(SendMessage.this, android.R.layout.simple_list_item_1));
        btnSendSMS=(Button) findViewById(R.id.btnSendSMS);


        btnSendSMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i=new
                        Intent(android.content.Intent.ACTION_VIEW);

                i.putExtra("address", "0701437989; 0788534375; 0752900987, 0753121769, 0703990026  ");
                i.putExtra("sms_body", "Hello parent You are informed to bring your children below two years for polio immunisation.");
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);

            }
        });
        findViewById(R.id.btncall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("0752900987");
            }
        });
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }



    @Override
    protected void onResume() {
        // TODO Auto-generated method stub

        //register the receiver

        registerReceiver(intentReceiver,intentFilter);
        super.onResume();
    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        //unregister the receiver..

        unregisterReceiver(intentReceiver);
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub

        //unregister the receiver

        unregisterReceiver(intentReceiver);
        super.onDestroy();
    }


}

