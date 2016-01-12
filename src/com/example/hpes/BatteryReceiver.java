package com.example.hpes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Bundle b=arg1.getExtras();
		String l=b.getString(BatteryManager.LEVEL);
		String s=b.getString(BatteryManager.STATUS);
		String data="BATTERY ALERT : \n";
		data+="\nSTATUS:"+s;
		data+="\nLEVEL:"+l;
		Toast.makeText(arg0, data, Toast.LENGTH_LONG).show();
	}

}
