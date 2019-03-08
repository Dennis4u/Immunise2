package com.example.myimmunisationapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyMenuActivity extends ListActivity {


    String[] menu={};
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_menu_activity);
        ListView lstvw=getListView();
        lstvw.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstvw.setTextFilterEnabled(true);
        menu=getResources().getStringArray(R.array.Menu_array);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,menu));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modifySettings=new Intent(MyMenuActivity.this,SettingsActivity2.class);
                startActivity(modifySettings);
            }
        });

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n" + "Perform Sync:\t" + sharedPrefs.getBoolean("perform_sync", false));
        builder.append("\n" + "Sync Intervals:\t" + sharedPrefs.getString("sync_interval", "-1"));
        builder.append("\n" + "Name:\t" + sharedPrefs.getString("full_name", "Not known to us"));
        builder.append("\n" + "Email Address:\t" + sharedPrefs.getString("email_address", "No EMail Address Provided"));
        builder.append("\n" + "Customized Notification Ringtone:\t" + sharedPrefs.getString("notification_ringtone", ""));
        builder.append("\n\nClick on Settings Button at bottom right corner to Modify Your Prefrences");

        TextView settingsTextView = (TextView) findViewById(R.id.settingsContent);
        settingsTextView.setText(builder.toString());



    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if(position==0){
            Intent intent= new Intent(getBaseContext(),RegisterActivity.class);
            startActivity(intent);
        }
        else if(position==1){
            Intent intent2=new Intent(getBaseContext(),Notifier.class);
            startActivity(intent2);
        }
        else if(position==2){
            Intent intent2=new Intent(getBaseContext(),SendMessage.class);
            startActivity(intent2);
        }
        else if(position==3){
            Intent intent3=new Intent(getBaseContext(),Alarm.class);
            startActivity(intent3);
        }
        else if(position==4){
            Intent intent4=new Intent(getBaseContext(),EmailActivity.class);
            startActivity(intent4);
        }
        else if(position==5){
            Intent intent5=new Intent(getBaseContext(),SendMessage.class);
            startActivity(intent5);
        }
        super.onListItemClick(l, v, position, id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
