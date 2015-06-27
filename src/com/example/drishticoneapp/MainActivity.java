package com.example.drishticoneapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	
	LinearLayout layout;
	Button btnContinue,btnLeft,btnRight;
	int images[] = new int[4];
	int imagePoint=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        images[0]=(R.drawable.main_act1);
        images[1]=R.drawable.main_act2;
        images[2]=R.drawable.main_act3;
        images[3]=R.drawable.main_act4;
        
        layout = (LinearLayout)findViewById(R.id.mainInner);
        layout.setBackgroundResource(images[imagePoint]);
        
        btnContinue = (Button)findViewById(R.id.cont);
        btnContinue.setBackgroundColor(Color.GRAY);
       
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        
        btnLeft.setBackgroundResource(R.drawable.left);
        btnRight.setBackgroundResource(R.drawable.right);
        
        btnLeft.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(imagePoint==0)
					imagePoint=3;
				else
					imagePoint--;
				layout.setBackgroundResource(images[imagePoint]);
			}
		});
        btnRight.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(imagePoint==3)
					imagePoint=0;
				else
					imagePoint++;
				layout.setBackgroundResource(images[imagePoint]);
			}
		});
        
        btnContinue.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent open = new Intent(MainActivity.this,MainMenu.class);
        		startActivity(open);
			}
		});
        
    }

    
    protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
