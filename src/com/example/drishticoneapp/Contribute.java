package com.example.drishticoneapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Contribute extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contribute);
		
		WebView browser = (WebView) findViewById(R.id.webContribute);
		browser.loadUrl("http://drishticone.org/contribute.php");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contribute, menu);
		return true;
	}

}
