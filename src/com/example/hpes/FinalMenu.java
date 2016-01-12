package com.example.hpes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FinalMenu extends ListActivity {
	String[] menu={"Sensors","Camera","WIFI DEMO","Bt demo","Android Menu","Fake Missed Call","EXIT"};
	Class [] screen={SensorDemo.class,CameraDemo.class,WifiDemo.class,BTDemo.class,MenuDemo.class};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ArrayAdapter<String> ad;
		ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
		setListAdapter(ad);
		apnaWelcomeDialog();
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ci=menu[position];
		if(ci.equals("EXIT"))
		{
			apnaExitDialog();
		}
		else if(ci.equals("Fake Missed Call"))
		{
			fakeMissedCall();
		}
		else
		{
			//Activity Start Code
			Intent ats=new Intent(this,screen[position]);
			startActivity(ats);
		}
	}
	void fakeMissedCall()
	{
		Notification.Builder nb=new Notification.Builder(this);
		nb.setContentTitle("Narendra Modi");
		nb.setContentText("31 missed call");
		nb.setSmallIcon(android.R.drawable.stat_notify_missed_call);
		Intent i=new Intent(this,FinalMenu.class);
		PendingIntent pi=PendingIntent.getActivity(this, 0, i, 0);
		nb.setContentIntent(pi);
		nb.setAutoCancel(true);
		Notification n=nb.build();
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.notify(0,n);
	}
	void apnaToast(String msg)
	{	int duration=Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this, msg, duration);
		t.show();
	}
	
	void apnaWelcomeDialog()
	{	
		SharedPreferences s;
		s=PreferenceManager.getDefaultSharedPreferences(this);
		boolean ws=s.getBoolean("welcome_switch", false);
		String wt=s.getString("welcome_text", "Hello");
		if(ws==true)
		{
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		b.setTitle("HPES");
		b.setIcon(R.drawable.ic_launcher);
		b.setMessage(wt);
		b.setPositiveButton("START",null);
		AlertDialog ad=b.create();
		ad.show();
	}
	}
	class MyDialogHandler implements OnClickListener
	{

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			finish();
		}
		
	}
	void apnaExitDialog()
	{
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		b.setTitle("Exit App");
		b.setIcon(R.drawable.star);
		b.setMessage("Do You Want To Exit ?");
		b.setPositiveButton("Yes",new MyDialogHandler());
		b.setNegativeButton("No",null);
		AlertDialog ad=b.create();
		ad.show();
	}
}
