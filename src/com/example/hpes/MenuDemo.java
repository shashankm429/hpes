package com.example.hpes;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.ContextMenu.ContextMenuInfo;

public class MenuDemo extends Activity {
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo);
		b1=(Button)findViewById(R.id.md_b1);
		registerForContextMenu(b1);
		ActionBar ab=getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.omi1) {
			return true;
		}
		else if (id == R.id.omi2) {
			Intent bt=new Intent(this,BTDemo.class);
			startActivity(bt);
		}
		else if (id == R.id.omi3) {
			Intent i= new Intent(this,SettingScreen.class);
			startActivity(i);
		}
		else if (id == R.id.omi4) {
			finish();
		}
		else
		{
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.my_context_menu, menu);
		menu.setHeaderTitle("Button Menu :");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.cmi1) {
			return true;
		}
		else if (id == R.id.cmi2) {
			return true;
		}
		else if (id == R.id.cmi3) {
			Intent i= new Intent(this,SettingScreen.class);
			startActivity(i);
		}
		else if (id == R.id.cmi4) {
			finish();
		}
		else
		{
			finish();
		}
		return super.onContextItemSelected(item);
	}
}
