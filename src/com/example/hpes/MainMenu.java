package com.example.hpes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
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

public class MainMenu extends ListActivity {
	String[] menu={"Exam","LastMenu","Battery Broadcast","Access Student Data","Game","Dictionary","LayOut Menu","WIDGET MENU","Music Time","Calculator","Activity Life Cycle","SERVICE CP","Settings","EXIT"};
	Class [] screen={Exam.class,FinalMenu.class,MyBroadcast.class,RemoteData.class,Game.class,Dictionary.class,LayoutMenu.class,WidgetMenu.class, MusicPlayer.class,Calculator.class,MainActivity.class,ServiceDemo.class,SettingScreen.class};
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
		else
		{
			//Activity Start Code
			Intent ats=new Intent(this,screen[position]);
			startActivity(ats);
		}
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
