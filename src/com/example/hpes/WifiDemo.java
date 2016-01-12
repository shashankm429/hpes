package com.example.hpes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class WifiDemo extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_demo);
		tv=(TextView)findViewById(R.id.textView2);
		String wfs=Context.WIFI_SERVICE;
		WifiManager wm=(WifiManager)getSystemService(wfs);
		if(wm.isWifiEnabled())
		{
			tv.setTextColor(Color.GREEN);
			tv.setText("ON");
		}
		else
		{	tv.setTextColor(Color.RED);
			tv.setText("OFF");
		}
	}

	
}
