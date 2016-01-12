package com.example.hpes;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SeeekBarDemo extends Activity implements OnSeekBarChangeListener {
	TextView status;
	SeekBar sb;
	AutoCompleteTextView actv;
	String[] act={"INDIA", "INDONESIA", "IRELAND", "IRAN"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seeek_bar_demo);
		sb=(SeekBar)findViewById(R.id.seekBar1);
		sb.setMax(100);
		sb.setOnSeekBarChangeListener(this);
		actv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> ad;
		ad=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,act);
		actv.setAdapter(ad);
		status=(TextView)findViewById(R.id.textView2);
		Thread process= new Thread(){
			public void run()
			{
				for(int i=0;i<=100;i++)
				{
					sb.setProgress(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		process.start();
	}
		

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		String td= "Status" +progress;
		status.setText(td);
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Seek Start", 1000).show();
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Seek Stop", 1000).show();
	}

	
}
