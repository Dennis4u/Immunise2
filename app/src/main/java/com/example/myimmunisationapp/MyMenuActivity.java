package com.example.myimmunisationapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

}
