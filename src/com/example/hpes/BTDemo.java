package com.example.hpes;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BTDemo extends Activity {

	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_btdemo);
		tv=(TextView)findViewById(R.id.textView2bt);
		BluetoothAdapter bta=BluetoothAdapter.getDefaultAdapter();
		if(bta!=null)
		{
			boolean on_off_status=bta.isEnabled();
			if(on_off_status==true)
			{
				tv.setText("ON");
			}
			else
			{
				tv.setText("OFF");
			}
		}
		else
		{
			Toast.makeText(this, "No NEELA DAANT", Toast.LENGTH_LONG).show();
		}
	}


}
