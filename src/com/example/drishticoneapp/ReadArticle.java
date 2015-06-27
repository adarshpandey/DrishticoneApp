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
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ReadArticle extends Activity {

	TextView text;
	String articleUrl,articleName;
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_article);
		
		text = (TextView)findViewById(R.id.txtArticle);
		layout = (LinearLayout)findViewById(R.id.innerLinear);
		
		Bundle bundle = getIntent().getExtras();
		articleUrl = bundle.getString("article url");
		articleName = bundle.getString("article name");
		
		new Article().execute();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_article, menu);
		return true;
	}
	
	
	////            inner class for loading article       /////////////
	
	class Article extends AsyncTask<String, String, String> 
	{
		String articleContent = "";
		protected void onPreExecute()
		{
			//layout.setVisibility(View.VISIBLE);
			text.setText("Loading");
			return;
		
		}
		
		protected String doInBackground(String... arg0) 
		{
	    	try
	    	{
	    	HttpClient httpClient = new DefaultHttpClient();
	        HttpContext localContext = new BasicHttpContext();
	        HttpGet httpGet = new HttpGet(articleUrl);
	        HttpResponse response = httpClient.execute(httpGet, localContext);

	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                response.getEntity().getContent()));

	        String line = reader.readLine();
	        
	        while(line.indexOf("col-md-6")==-1)
	        	line = reader.readLine();
	        
	        while(line.indexOf("col-md-3")==-1)
	        	{
	        	
	        	articleContent += line + "\n";
	        	line = reader.readLine();
	        	}
	    	
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
			text.setText(Html.fromHtml(articleContent));
		}
		
		
	}

}
