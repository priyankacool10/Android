package com.example.simplenotification;



import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        
    }

    public void sendNotification(View view){
    	//Creating Notification Builders
    	NotificationCompat.Builder myNotificationBuilder = new NotificationCompat.Builder(this);
    	
    	//Setting Notification properties
    	myNotificationBuilder.setSmallIcon(R.drawable.ic_launcher);
    	myNotificationBuilder.setContentTitle("First Notification");
    	myNotificationBuilder.setContentText("This is a test notification");
    	int notificationid = 3452;
    	
    	// Creates an explicit intent for an Activity in your app
    	Intent myIntent = new Intent(this, ResultActivity.class);
    	myIntent.putExtra("myNotificationId", notificationid);
    	myIntent.putExtra("AnyValue", 12345);
    	//myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	
    	/* //This ensures that navigating backward from the Activity leads out of the app to Home page
    	TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    	// Adds the back stack for the Intent
    	stackBuilder.addParentStack(ResultActivity.class);
    	// Adds the Intent that starts the Activity to the top of the stack
    	stackBuilder.addNextIntent(myIntent);
    	PendingIntent myPendingIntent =
    	         stackBuilder.getPendingIntent(0,
    	            PendingIntent.FLAG_ONE_SHOT //can only be used once
    		         );
    	*/
    	PendingIntent myPendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    	
    	// start the activity when the user clicks the notification text
    	myNotificationBuilder.setContentIntent(myPendingIntent);
    	
    	//Issue the Notification
    	NotificationManager myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	myManager.notify(notificationid, myNotificationBuilder.build());
    }

}
