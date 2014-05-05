package com.example.fragmenttask;

import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.ViewGroup;
import android.app.Activity;

public class FirstFragment extends Fragment{
	Button calculate;
	EditText number;
	int result;
	
	public interface myInterface{
		public void onReceiveData(int data);
	}
	
	myInterface mInstance;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup mGroup, Bundle savedInstanceState){
		View mView = inflater.inflate(R.layout.layout_firstfragment, mGroup, false);
		calculate = (Button)mView.findViewById(R.id.button1);
		number = (EditText)mView.findViewById(R.id.textSource);
		calculate.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				result=factorial();
				mInstance.onReceiveData(result);
			}
		});
		Log.d("frag1","Ui Inflated");
		return mView;
	}
	public int factorial(){
		Log.d("tagg","inside fact");
		int num = Integer.parseInt(number.getText().toString());
		int fact=1;
		for(int i=1;i<=num;i++)
			fact=fact*i;
		return fact;
	}
	
	@Override
	public void onAttach(Activity container) {
		super.onAttach(container);
		if (container instanceof myInterface){
			mInstance = (myInterface) container;
		}
		else {
			throw new ClassCastException(" - Activity does not implement the interface");
		}
	}
}
