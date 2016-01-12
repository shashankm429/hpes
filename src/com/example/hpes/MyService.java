package com.example.hpes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service
{
//Implementation of Started Service and Not bounded service
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "SERVICE CREATED",1000).show();
	}
	@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			// TODO Auto-generated method stub
		Toast.makeText(this, "START CREATED",1000).show();
			return super.onStartCommand(intent, flags, startId);
			
		}
	@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
		Toast.makeText(this, "DESTROYED",1000).show();
			super.onDestroy();
		}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
