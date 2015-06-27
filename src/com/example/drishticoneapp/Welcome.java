package com.example.drishticoneapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.RelativeLayout;

public class Welcome extends Activity {

	RelativeLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		layout = (RelativeLayout)findViewById(R.id.welcomeLayout);
		layout.setBackgroundResource(R.drawable.welcome);
		
		Thread wait = new Thread()
		{
			public void run()
			{
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					Log.e(new String(), "Error : " + e.toString());
				}
				finally
				{
					Intent endWelcome = new Intent(Welcome.this,MainActivity.class);
					startActivity(endWelcome);
				}
			}
		};
		wait.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
