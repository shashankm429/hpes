package com.example.hpes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Exam extends Activity implements OnClickListener {
	TextView questions,score;
	Button b;
	RadioButton r1,r2;
	int result=0;
	int i=0;
	String ans="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);
		questions=(TextView)findViewById(R.id.questions);
		b=(Button)findViewById(R.id.button1);
		r1=(RadioButton)findViewById(R.id.radio0);
		r2=(RadioButton)findViewById(R.id.radio1);
		b.setOnClickListener(this);
		
		questions.setText(ExamSupport.questions[i]);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(i<4)
		{
		
		if(r1.isChecked())
		{
			ans="true";
			
		
		}
		else if(r2.isChecked())
		{
			ans="false";
		}
		if(ans.equalsIgnoreCase(ExamSupport.answers[i]))
			
		{
			result=result+1;
		}
		i=i+1;
		//score.setText("YOUR SCORE: "+result);
		questions.setText(ExamSupport.questions[i]);
		

	}
		else if(i==4)
		{
			
			if(r1.isChecked())
			{
				ans="true";
				
			
			}
			else if(r2.isChecked())
			{
				ans="false";
			}
			if(ans.equalsIgnoreCase(ExamSupport.answers[i]))
				
			{
				result=result+1;
			}
			Toast.makeText(this,result,Toast.LENGTH_LONG).show();
	}
	}

	
}
