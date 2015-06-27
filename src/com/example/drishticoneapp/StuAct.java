package com.example.drishticoneapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class StuAct extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stu);
		
		WebView browser = (WebView) findViewById(R.id.webStuActivity);
		browser.loadUrl("http://drishticone.org/student_activity.php");
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stu, menu);
		return true;
	}

}
