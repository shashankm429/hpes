package com.example.hpes;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LayoutMenu extends ListActivity {
	String[] menu={"TabDemo","DrawerDemo","FrameDemo","TableDemo","LinearDemo","EXIT"};
	Class [] screen={TabDemo.class,DrawerDemo.class,FrameDemo.class,TableDemo.class,LinearDemo.class,SeeekBarDemo.class,CheckBoxDemo.class};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ArrayAdapter<String> ad;
		ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
		setListAdapter(ad);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ci=menu[position];
		if(ci.equals("EXIT"))
		{
			finish();
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

}
