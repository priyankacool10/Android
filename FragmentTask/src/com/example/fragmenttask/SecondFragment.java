package com.example.fragmenttask;

import android.app.Fragment;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;

public class SecondFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup mGroup, Bundle savedInstanceState){
		View mView = inflater.inflate(R.layout.layout_secondfragment, mGroup, false);
		return mView;
		
	}

}
