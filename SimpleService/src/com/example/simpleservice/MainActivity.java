package com.example.simpleservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
///import android.content.Intent;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        Button play,stop;
        play = (Button)findViewById(R.id.button1);
        play.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View view){
        		Intent myIntent = new Intent(MainActivity.this, MyService.class);
        		startService(myIntent);
        	}
        });
        
        stop=(Button)findViewById(R.id.button2);
        stop.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View view){
        		Intent myIntent = new Intent(MainActivity.this, MyService.class);
        		stopService(myIntent);
        	}
        });

    }


}
