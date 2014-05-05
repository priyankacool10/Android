package com.example.jsonparsertask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;



import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
//import android.widget.ListAdapter;
import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
import android.widget.SimpleAdapter;
 
public class MainActivity extends ListActivity {
 
    // Progress Dialog
   private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    //JSONParser jParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> noticesList;
 
    // url to get all products list
    private static String url_all_notices = "http://192.168.43.165/get_notices.php";
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_NOTICE = "notice";
    private static final String TAG_NOTICES = "notices";
    private static final String TAG_TITLE = "title";
    private static final String TAG_DESC = "description";
    private static  String title=null;
    private static  String description=null;
    
   
    // products JSONArray
    JSONArray products = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
 
        // Hashmap for ListView
        noticesList = new ArrayList<HashMap<String, String>>();
 
        // Loading products in Background Thread
        new LoadAllNotices().execute();
 
        // Get listview
        ListView lv = getListView();
 
        // on seleting single product
        // launching Edit Product Screen
        lv.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            
                // Starting new intent
                Intent in = new Intent(getApplicationContext(),
                        ShowNotice.class);
                // sending pid to next activity
                in.putExtra(TAG_TITLE, title);
                in.putExtra(TAG_DESC, description);
                // starting new activity and expecting some response back
                startActivityForResult(in, 100);
            }
        });
 
    }
 
    // Response from Edit Product Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
 
    }
 
    /**
     * Background Async Task to Load all product by making HTTP Request
     * */
    class LoadAllNotices extends AsyncTask<String, String, String> {
 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
            
        }
 
        /**
         * getting All notices from url
         * */
        protected String doInBackground(String... args) {
            
            String str=null;
            HttpResponse response;
            HttpClient myClient = new DefaultHttpClient();
            HttpPost myConnection = new HttpPost(url_all_notices);
            
            try {
            	response = myClient.execute(myConnection);
            	str = EntityUtils.toString(response.getEntity(), "UTF-8");
            	Log.d("response", str);
            } catch(ClientProtocolException e) {
            	e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            JSONObject json,myObj;
        	JSONArray jsonArray,myArray;
        	String TAG="JSON Data";
            
            
            try {
        		json = new JSONObject(str);
        		jsonArray = json.getJSONArray(TAG_NOTICES);
        		for(int j=0;j<jsonArray.length();j++){
        			myObj = jsonArray.getJSONObject(j);
        			int success = myObj.getInt(TAG_SUCCESS);
        		 
        			if (success == 1) {
        				myArray = myObj.getJSONArray(TAG_NOTICE);
        				for (int i = 0 ; i < myArray.length() ; i++)
        				{
        					JSONObject myObj2 = myArray.getJSONObject(i);
        					title = myObj2.getString("title");
        					Log.d(TAG, "Title: "+title);
        					
        					description = myObj2.getString("description");
        					Log.d(TAG, "Description: "+description);
        					
        					 // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();
     
                            // adding each child node to HashMap key => value
                            map.put(TAG_TITLE, title);
                            map.put(TAG_DESC, description);
                            noticesList.add(map);
        					
        				}
        			}else{
        				Log.d(TAG,"Not Successfull");
        			}
        		}
        		
        	}
        	catch(JSONException e)
        	{
        		e.printStackTrace();
        		
        	}
        	
            return null;
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                   ListAdapter adapter = new SimpleAdapter(
                            MainActivity.this, noticesList,
                            R.layout.list_item, new String[] { TAG_TITLE,
                                    TAG_DESC},
                            new int[] { R.id.title, R.id.description });
                    // updating listview
                    setListAdapter(adapter);
                }
            });
 
        }
 
    }
}