package com.example.hpes;

import com.example.hpes.MainMenu.MyDialogHandler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener {
	
	EditText et;
	TextView score,jumble;
	Button b;
	int result=0;
	int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		et=(EditText)findViewById(R.id.editText1);
		SharedPreferences fs=getSharedPreferences("tcdata", 0);
		String ld=fs.getString("last_temp", "");
		score=(TextView)findViewById(R.id.textView1);
		jumble=(TextView)findViewById(R.id.textView2);
		b=(Button)findViewById(R.id.button1);
		jumble.setText(GameSupport.jumble[i]);
		b.setOnClickListener(this);
		et.setText(ld);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(i<4)
		{
		
		if(et.getText().toString().trim().equalsIgnoreCase(GameSupport.words[i]))
		{
			result=result+1;
		
		}
		
		i=i+1;
		score.setText("YOUR SCORE: "+result);
		jumble.setText(GameSupport.jumble[i]);
		et.setText("");

	}
		else if(i==4)
		{
			
			if(et.getText().toString().trim().equalsIgnoreCase(GameSupport.words[i]))
			{
				result=result+1;
			
			}
			//apnaExitDialog(result);
			Intent sp=new Intent(this,Score.class);
			sp.putExtra("userscore", String.valueOf(result));
			startActivityForResult(sp,10);
		}
		

	}
	class MyDialogHandler implements android.content.DialogInterface.OnClickListener
	{

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			finish();
		}

		
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b=data.getExtras();
		String response=b.getString("res");
		if(response.equals("CLOSE"))
		{
			finish();
		}
		else if(response.equals("PLAY"))
		{
			result=0;
			i=0;
			jumble.setText(GameSupport.jumble[i]);
			et.setText("");
			
		}
	}
	void apnaExitDialog(int result)
	{
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		b.setTitle("Thank You");
		b.setIcon(R.drawable.star);
		b.setMessage("Your Score is: "+result);
		b.setPositiveButton("Ok",new MyDialogHandler());
	//	b.setNegativeButton("No",null);
		AlertDialog ad=b.create();
		ad.show();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		String temp=et.getText().toString();
		SharedPreferences fs=getSharedPreferences("tcdata", 0);
		SharedPreferences.Editor editor=fs.edit();
		editor.putString("last_temp", temp);
		editor.commit();
		super.onDestroy();
	}
}
