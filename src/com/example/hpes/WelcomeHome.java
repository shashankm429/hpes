package com.example.hpes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WelcomeHome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_home);
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(5000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					Intent i =new Intent("com.example.hpes.MAINMENU");
					startActivity(i);
					finish();
				}
			}
		};
		timer.start();
	}

	
}
