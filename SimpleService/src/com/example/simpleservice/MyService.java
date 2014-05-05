package com.example.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
//import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service{
	String tag="MyService";
	MediaPlayer mp;
	
	@Override
	public IBinder onBind(Intent intent){
		return null;
	}
	@Override
	public void onCreate(){
		super.onCreate();
		mp = MediaPlayer.create(getApplicationContext(), R.raw.song);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		mp.start();
		return START_STICKY;
	}
	
	@Override
	public void onDestroy(){
		mp.release();
		super.onDestroy();
	}

}
