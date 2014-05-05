package com.example.pascaltask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

	public class Sender extends Activity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_sender);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.sender, menu);
	        return true;
	    }
	    public void click(View view){
	    	EditText mEditText1 = (EditText)findViewById(R.id.editText1);
	    	String first = mEditText1.getText().toString();
	    	EditText mEditText2 = (EditText)findViewById(R.id.editText2);
	    	String last = mEditText2.getText().toString();
	    	EditText mEditText3 = (EditText)findViewById(R.id.editText3);
	    	int age = Integer.parseInt(mEditText3.getText().toString());
	    	EditText mEditText4 = (EditText)findViewById(R.id.editText4);
	    	float sal = Float.parseFloat(mEditText4.getText().toString());
	    	Employee obj = new Employee(first, last,age, sal);
	    	myparcel mParcel = new myparcel(obj);
	    	Intent mIntent = new Intent(this, Reciever.class);
	    	mIntent.putExtra("myparcel", mParcel);
	    	startActivity(mIntent);
	    }
	    
	}


