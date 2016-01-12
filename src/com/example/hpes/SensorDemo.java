package com.example.hpes;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SensorDemo extends Activity implements SensorEventListener {

	RelativeLayout screen;
	TextView status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_demo);
		screen=(RelativeLayout)findViewById(R.id.sensor_screen);
		status=(TextView)findViewById(R.id.sensor_status);
		String ss=SENSOR_SERVICE;
		SensorManager sm=(SensorManager)getSystemService(ss);
		int type=Sensor.TYPE_ORIENTATION;
		Sensor s=sm.getDefaultSensor(type);
		sm.registerListener(this, s, sm.SENSOR_DELAY_NORMAL);
		
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
	
	float[] data=event.values;//if sensor works on 3 values then we get 3 values inside this array	, here we get 3 values
	float x= data[1];
	float z= data[0];
	float y=data[2];
	String s="Sensor status : \n";
	s+="\nX="+x;
	s+="\nY="+y;
	s+="\nZ="+z;
	status.setText(s);
	int color=Color.rgb((int)x, (int)y, (int)z);
	screen.setBackgroundColor(color);
	}

	
}
