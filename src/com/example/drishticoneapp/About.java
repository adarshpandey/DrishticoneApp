package com.example.drishticoneapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.TextView;

public class About extends Activity {

	WebView browser;
	TextView aboutText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		aboutText = (TextView)findViewById(R.id.about);
		
		WebView browser = (WebView) findViewById(R.id.webAbout);
		browser.loadUrl("http://drishticone.org/aboutus.php");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
	
	class AboutText extends AsyncTask<String, String, String> 
	{
		String articleContent = "";
		protected void onPreExecute()
		{
			//layout.setVisibility(View.VISIBLE);
			aboutText.setText("Loading");
			return;
		
		}
		
		protected String doInBackground(String... arg0) 
		{
	    	try
	    	{
	    		
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		Log.e(new String(), "Error:((" + e.getMessage());
	    		Log.e(new String(), "More Error:((" + e.toString());
	    	}
	    	
	    	
		return null;
			
		}
		
		protected void onPostExecute(String result)
		{
			//layout.setVisibility(View.GONE);
			aboutText.setText("");
		}
		
		
	}

}
