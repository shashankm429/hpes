package com.example.hpes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		apnaToast("ON CREATE CALLED");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void open(View v)
	{
		Intent i=new Intent(this,Next.class);
		startActivity(i);
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		apnaToast("DESTROY CALLED");
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		apnaToast("START CALLED");
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		apnaToast("RESTART CALLED");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		apnaToast("RESUME CALLED");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		apnaToast("PAUSE CALLED");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		apnaToast("STOP CALLED");
	}
	void apnaToast(String msg)
	{	int duration=Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this, msg, duration);
		t.show();
	}
	
	}

