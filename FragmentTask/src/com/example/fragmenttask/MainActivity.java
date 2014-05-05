package com.example.fragmenttask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity implements FirstFragment.myInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    //Defined here because there is no way to pass result of one fragment to another.
    public void onReceiveData(int data){
    	TextView output = (TextView)findViewById(R.id.textView1);
    	if(output!=null){
    		output.setText(""+data);
    		
    	}
    }


   

}
