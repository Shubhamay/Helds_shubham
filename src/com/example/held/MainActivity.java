package com.example.held;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView txt = (TextView) findViewById(R.id.custom_font);
        Typeface font = Typeface.createFromAsset(getAssets(), "IndieFlower.ttf");
        txt.setTypeface(font);
        
        new DownloadMusicfromInternet().execute();
    }

    private void makeGetRequest() {
    	 
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://139.162.1.137/api/users/create?phone=12345678&name=foo"); 
                                
        HttpResponse response;
        try {
            response = client.execute(request);
             
            Log.e("Response",response.toString());
            
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    class DownloadMusicfromInternet extends AsyncTask<String, String, String> {
    	 
        // Show Progress bar before downloading Music
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Shows Progress Bar Dialog and then call doInBackground method
            
        }

        // Download Music File from Internet
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            makeGetRequest();
			return null;
            
        }

        // While Downloading Music File
        protected void onProgressUpdate(String... progress) {
            // Set progress percentage
            
        }

    }

}
