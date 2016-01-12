package com.example.hpes;

import android.app.Activity;
import android.database.CursorJoiner.Result;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidCalculator extends Activity implements OnClickListener{

	Button[] b=new Button[10];
	Button bc,badd,bsub,bmul,bdiv,beq,bdec;
	TextView tv;
	float num1=0,res=0;
	String operation="";
	int flag=0,flag1=0;
	boolean mark=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView)findViewById(R.id.ca_tv1);
		int[] id={R.id.ca_0,R.id.ca_1,R.id.ca_2,R.id.ca_3,R.id.ca_4,R.id.ca_5,R.id.ca_6,R.id.ca_7,R.id.ca_8,R.id.ca_9};
		for(int i=0;i<10;i++)
			b[i]=(Button)findViewById(id[i]);
		bc=(Button)findViewById(R.id.ca_c);
		bdec=(Button)findViewById(R.id.ca_dec);
		badd=(Button)findViewById(R.id.ca_add);
		bsub=(Button)findViewById(R.id.ca_sub);
		bmul=(Button)findViewById(R.id.ca_mul);
		bdiv=(Button)findViewById(R.id.ca_div);
		beq=(Button)findViewById(R.id.ca_eq);
		for(int i=0;i<10;i++)
			b[i].setOnClickListener(this);
		bdiv.setOnClickListener(this);
		badd.setOnClickListener(this);
		bsub.setOnClickListener(this);
		bmul.setOnClickListener(this);
		bdec.setOnClickListener(this);
		beq.setOnClickListener(this);
		bc.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		if(!(tv.getText().toString()).equalsIgnoreCase("Infinity") && !(tv.getText().toString()).equalsIgnoreCase("Nan"))
		{
			switch (v.getId()) {
			case R.id.ca_c:
				num1=0;
				flag=0;
				operation="";
				res=0;
				flag1=0;
				mark=false;
				tv.setText("0");
				break;
			case R.id.ca_eq:
				result();
				break;
			case R.id.ca_add:
				flag=1;
				operate("+");
				break;
			case R.id.ca_sub:
				flag=1;
				operate("-");	
				break;
			case R.id.ca_mul:
				flag=1;
				operate("*");
				break;
			case R.id.ca_div:
				flag=1;
				operate("/");
				break;
			case R.id.ca_dec:
				addend();
				break;
			default:
				append(((Button)v).getText().toString());
				break;
			}
		}
		else
		{
			if(v.getId()==R.id.ca_c)
			{
				num1=0;
				flag=0;
				operation="";
				res=0;
				tv.setText("0");
				//break;
			}
		}
	}
	
	void addend()
	{
		if(mark!=true)
		flag1++;
		if(flag==0)
		{
			tv.setText("0.");
			flag=1;
		}
		else
		{
			String str=tv.getText().toString();
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)=='.')
				{
					alert("invalid input");
					return;
				}
			}
			tv.setText(tv.getText().toString()+'.');
		}
	}
	
	void result()
	{			
		String str=tv.getText().toString();
		flag=0;
		float num2=Float.parseFloat(str);
		if(operation.equals("+"))
		{
			num2=num1+num2;
		}
		else if(operation.equals("-"))
			num2=num1-num2;
		else if(operation.equals("*"))
			num2=num1*num2;
		else if(operation.equals("/"))
			num2=num1/num2; 
		if((num2-(int)num2)==0)
		{
			tv.setText(String.valueOf((int)num2));
		}
		else
		{
			tv.setText(String.valueOf(num2));
		}
		flag1=1;
		mark=true;
	}
	
	void resultOperand()
	{			
		String str=tv.getText().toString();
		flag=0;
		float num2=Float.parseFloat(str);
		if(operation.equals("+"))
		{
			num2=num1+num2;
		}
		else if(operation.equals("-"))
			num2=num1-num2;
		else if(operation.equals("*"))
			num2=num1*num2;
		else if(operation.equals("/"))
			num2=num1/num2; 
		if((num2-(int)num2)==0)
		{
			tv.setText(String.valueOf((int)num2));
		}
		else
		{
			tv.setText(String.valueOf(num2));
		}
		flag1=1;
		//mark=true;
	}
	
	
	private void append(String str) {
		
		// TODO Auto-generated method stub
		if(mark!=true)
		flag1++;
		if(flag==0)
		{
			tv.setText(str);
			if(!str.equalsIgnoreCase("0"))
			flag=1;
		}
		else
		{
		tv.setText(new String(tv.getText().toString()+str));
		flag=1;
		}
	}

	private void operate(String str) {
		if(flag1>=2)
			resultOperand();
		num1=Float.parseFloat(tv.getText().toString());
		operation=new String(str);
		flag=0;
	}

	void alert(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	
}