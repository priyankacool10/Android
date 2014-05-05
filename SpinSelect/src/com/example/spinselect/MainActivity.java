package com.example.spinselect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;



public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
	String spinnerText,meditText1,meditText2;
	EditText myEdit1=null;
	EditText myEdit2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_spin);
        Spinner myspinner=(Spinner)findViewById(R.id.spinner1);
        /*ArrayAdapter<CharSequence> myadapter = new ArrayAdapter<CharSequence>(this,R.array.contact_type,android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        myspinner.setAdapter(myadapter);*/
        myspinner.setOnItemSelectedListener(this);
        myEdit1 = (EditText)findViewById(R.id.editText1);
        myEdit2 = (EditText)findViewById(R.id.editText2);
        
        
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
    	spinnerText = ((TextView)view).getText().toString();
    	Log.d("TAG","You selected"+spinnerText);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){
    	spinnerText="Type of Contact";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void sendData(View view){
    	meditText1 = myEdit1.getText().toString();
    	meditText2 = myEdit2.getText().toString();
    	Intent myIntent = new Intent(this,second_Activity.class);
    	myIntent.putExtra("spinnerText",spinnerText);
    	myIntent.putExtra("meditText1",meditText1);
    	myIntent.putExtra("meditText2",meditText2);
    	startActivity(myIntent);
    }

}
