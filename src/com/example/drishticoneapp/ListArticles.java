package com.example.drishticoneapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ListArticles extends Activity {

	TextView textView = null;
	String url = "http://drishticone.org/article1.php";
	String Urlsource = null;
	Thread read;
	ArrayList<String> articles = new ArrayList<String>();
	ArrayList<Button> btnArticles = new ArrayList<Button>();
	LinearLayout layout;
	ScrollView scrollArticles;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//scrollArticles = (ScrollView)findViewById(R.id.scrollViewReadArticle);
		setContentView(R.layout.activity_list_articles);
		
		textView = (TextView )findViewById(R.id.txt);
        textView.setText("");
        //scrollArticles.addView(textView);
        layout = (LinearLayout)findViewById(R.id.container);
        
        try
        {
        	new Source().execute();
        }
        catch(Exception e)
        {
        	System.out.println(""+e.toString());
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_articles, menu);
		return true;
	}
	
		
	////////      inner class        /////////////////
	
	class Source extends AsyncTask<String, String, String> implements View.OnClickListener
	{
		String text = "";
		protected void onPreExecute()
		{
			layout.setVisibility(View.VISIBLE);
			
			return;
		
		}
		
		protected String doInBackground(String... arg0) 
		{
	    	try
	    	{
	    	HttpClient httpClient = new DefaultHttpClient();
	        HttpContext localContext = new BasicHttpContext();
	        HttpGet httpGet = new HttpGet(url);
	        HttpResponse response = httpClient.execute(httpGet, localContext);
	        String result = null;

	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                response.getEntity().getContent()));

	        String line = reader.readLine();
	        int i=0;
	        while(line!=null)
	        	{
	        	++i;
	        	result += line + "\n";
	        	line = reader.readLine();
	        	}
	    	Urlsource = result;
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		Log.e(url, "Error:((" + e.getMessage());
	    		Log.e(url, "More Error:((" + e.toString());
	    	}
	    	
	    	
	    	///             creating  articles  list            ///////////////
	    	
	    	
	    	text = "Articles...\n\n";
	    	//int nArticles = 0;
	    	try
	    	{
	    		Scanner scan = new Scanner(Urlsource);	
	    		String inputLine = scan.nextLine();
	    		inputLine = scan.nextLine();
	    		int i=0;
	    		
	    		while (inputLine!=null)
	    		{
	    			i++;
	    			if(inputLine.indexOf("<b>Latest Articles</b>")>-1)
	    			{
	    				
	    				while(inputLine.indexOf("<a href")==-1) 
	    					inputLine = scan.nextLine();
	    				
	    				while(inputLine.indexOf("<a href")>-1)
	    				{
	    					
	    			        String newArticleText = "";
	    					
	    			        String s = inputLine;
	    					int x=1;
	    					while(inputLine.charAt(x)!='>') 
	    						x++;
	    					x++;
	    					
	    					while(inputLine.charAt(x)!='<') 
	    					{
	    						newArticleText += inputLine.charAt(x);
	    						x++;
	    					}
	    					
	    					articles.add(newArticleText);
	    					
	    					inputLine = scan.nextLine();
	    				}
	    				break;
	    			}
	    			inputLine = scan.nextLine();
	    		}
	    		
	    		scan.close();
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		Log.e(new String(), "You error is :"+e.toString());
	    	}
	    	
	    	
		return null;
			
		}
		
		protected void onPostExecute(String result)
		{
			
			textView.setText(Html.fromHtml("<h2><b>Latest Articles - \n</b></h2>"));
			LinearLayout inner = (LinearLayout)findViewById(R.id.innerContainer);
			for(int i=0;i<articles.size();i++)
			{
				//textView.append("\n\n" + articles.get(i));
				Button newArtButton = new Button(getApplicationContext());
				newArtButton.setText(articles.get(i));
				newArtButton.setOnClickListener(this);
				btnArticles.add(newArtButton);
				inner.addView(newArtButton);
			}
			
			
		}
		
		public void onClick(View v)
		{
			Button clicked = (Button)v;
			int index = btnArticles.indexOf(clicked)+1;
	
			String url = "http://drishticone.org/article" + index + ".php";
			
			Intent open = new Intent(ListArticles.this,ReadArticle.class);
			open.putExtra("article name", articles.get(index-1));
			open.putExtra("article url", url);
			startActivity(open);
			
			
		}
	}



}

