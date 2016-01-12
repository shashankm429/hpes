package com.example.hpes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemo extends Activity implements OnClickListener{

	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_demo);
		b1=(Button)findViewById(R.id.sd_start);
		b2=(Button)findViewById(R.id.sd_stop);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent sts=new Intent(this,MyService.class);
		switch(v.getId()){
		case R.id.sd_start:
			startService(sts);
			break;
		case R.id.sd_stop:
			stopService(sts);
			break;
		}
		
		
	}


}
