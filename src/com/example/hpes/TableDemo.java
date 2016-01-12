package com.example.hpes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TableDemo extends Activity implements OnClickListener{
	
	Button one,two,three,four,five,six,seven,eight,nine,zero,divide,multiply,plus,minus,equal,dot;
	EditText et;
	long n1=0,n2=0;
	char symb=' ';
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_demo);
		 et=(EditText)findViewById(R.id.result);
		one=(Button)findViewById(R.id.one);
		 two=(Button)findViewById(R.id.two);
		 three=(Button)findViewById(R.id.three);
		 four=(Button)findViewById(R.id.four);
		 five=(Button)findViewById(R.id.five);
		 six=(Button)findViewById(R.id.six);
		 seven=(Button)findViewById(R.id.seven);
		 eight=(Button)findViewById(R.id.eight);
		 nine=(Button)findViewById(R.id.nine);
		 zero=(Button)findViewById(R.id.zero);
		 divide=(Button)findViewById(R.id.divide);
		 dot=(Button)findViewById(R.id.dot);
		 equal =(Button)findViewById(R.id.equal);
		 multiply =(Button)findViewById(R.id.multiply);
		 plus=(Button)findViewById(R.id.plus);
		 minus=(Button)findViewById(R.id.minus);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);
		dot.setOnClickListener(this);
		multiply.setOnClickListener(this);
		divide.setOnClickListener(this);
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		equal.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
	
		switch(v.getId())
		{
		case R.id.plus:
			et.append(plus.getText().toString());
			break;
		case R.id.minus:
			et.append(minus.getText().toString());
			break;
		case R.id.multiply:
			et.append(multiply.getText().toString());
			break;
		case R.id.divide:
			et.append(divide.getText().toString());
			break;
		case R.id.dot:
			et.append(dot.getText().toString());
			
			break;
		case R.id.one:
			et.append(one.getText().toString());
			break;
		case R.id.two:
			et.append(two.getText().toString());
			break;
		case R.id.three:
			et.append(three.getText().toString());
			break;
		case R.id.four:
			et.append(four.getText().toString());
			break;
		case R.id.five:
			et.append(five.getText().toString());
			break;
		case R.id.six:
			et.append(six.getText().toString());
			break;
		case R.id.seven:
			et.append(seven.getText().toString());
			break;
		case R.id.eight:
			et.append(eight.getText().toString());
			break;
		case R.id.nine:
			et.append(nine.getText().toString());
			break;
		case R.id.zero:
			et.append(zero.getText().toString());
			break;
		case R.id.equal:
			String s=et.getText().toString();
			int i;
			int num1,num2;
			for(i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')
				{
					symb=s.charAt(i);
					
					
				}
			}
			break;
			
		}
		
	}

	
}
