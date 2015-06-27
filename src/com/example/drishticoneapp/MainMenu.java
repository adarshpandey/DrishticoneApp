package com.example.drishticoneapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainMenu extends Activity {

	Button homeBtn,studentActBtn,galleryBtn,contributeBtn,techblogBtn,aboutBtn;
	LinearLayout layout;
	ScrollView scroll ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		/*
		layout = (LinearLayout)findViewById(R.id.mainMenuLayout);
		scroll = (ScrollView)findViewById(R.id.scrollMain);
		
		homeBtn = (Button)findViewById(R.id.Home);
		galleryBtn = (Button)findViewById(R.id.Gallery);
		studentActBtn = (Button)findViewById(R.id.StuAct);
		contributeBtn = (Button)findViewById(R.id.Contribute);
		techblogBtn = (Button)findViewById(R.id.Tech);
		aboutBtn = (Button)findViewById(R.id.About);
		
		scroll.addView(homeBtn);
		scroll.addView(galleryBtn);
		scroll.addView(studentActBtn);
		scroll.addView(contributeBtn);
		scroll.addView(techblogBtn);
		scroll.addView(aboutBtn);
		*/
		
		homeBtn = (Button)findViewById(R.id.Home);
		homeBtn.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				Intent open = new Intent(MainMenu.this,ListArticles.class);
        		startActivity(open);
			}
		});
		
		aboutBtn = (Button)findViewById(R.id.About);
		aboutBtn.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				Intent open = new Intent(MainMenu.this,About.class);
        		startActivity(open);
			}
		});
		
		studentActBtn = (Button)findViewById(R.id.StuActivity);
		studentActBtn.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				Intent open = new Intent(MainMenu.this,StuAct.class);
        		startActivity(open);
			}
		});
		
		contributeBtn = (Button)findViewById(R.id.Contribute);
		contributeBtn.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				Intent open = new Intent(MainMenu.this,Contribute.class);
        		startActivity(open);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		
		return true;
	}

}
