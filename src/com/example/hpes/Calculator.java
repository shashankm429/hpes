package com.example.hpes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements OnClickListener {
	
	EditText et1,et2,et3;
	Button b1,b2,b3,b4;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		et1=(EditText)findViewById(R.id.calc_et1);
		et2=(EditText)findViewById(R.id.calc_et2);
		et3=(EditText)findViewById(R.id.calc_et3);
		
		b1=(Button)findViewById(R.id.calc_b1);
		b2=(Button)findViewById(R.id.calc_b2);
		b3=(Button)findViewById(R.id.calc_b3);
		b4=(Button)findViewById(R.id.calc_b4);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String i1=et1.getText().toString();
		String i2=et2.getText().toString();
		int a=0,b=0;
		float result = 0;
		a=Integer.parseInt(i1);
		b=Integer.parseInt(i2);
		switch(v.getId())
		{
		case R.id.calc_b1:
			//ADD
			result=a+b;
			break;
		case R.id.calc_b2:
			//SUBTRACT
			result=a-b;
			break;
		case R.id.calc_b3:
			//MULTIPLY
			result=a*b;
			break;
		case R.id.calc_b4:
			//DIVIDE
			if(b==0)
			{
				result=0;
			}
			else
				{
				result=a/b;
				}
			break;
			
				
		}
		et3.setText(String.valueOf(result));
		
	}
}
