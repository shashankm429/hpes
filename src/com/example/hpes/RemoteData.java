package com.example.hpes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RemoteData extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote_data);
	
ContentResolver cr=getContentResolver();
Cursor c=cr.query(StudentContract.URI, null, null, null, null);
		
		
		
		String records="Student Records : ";
		while(c.moveToNext())
		{
		records+="\n"+c.getString(StudentLookup.getColumnIndex(StudentLookup.R_NO))+"\t"+c.getString(StudentLookup.getColumnIndex(StudentLookup.S_NAME));
		}
		apnaDialog(records);
	}
	void apnaDialog(String msg)
	{
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		b.setTitle("DATABASE App");
		b.setIcon(R.drawable.ic_launcher);
		b.setMessage(msg);
		b.setPositiveButton("Ok",null);
		
		AlertDialog ad=b.create();
		ad.show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.remote_data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
