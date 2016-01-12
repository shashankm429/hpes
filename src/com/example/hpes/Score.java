package com.example.hpes;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity implements android.view.View.OnClickListener{
	String res="CLOSE";
	TextView score,tv2;
	Button exit,retry;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		score=(TextView)findViewById(R.id.game_score);
		tv2=(TextView)findViewById(R.id.textView2);
		Intent ri=getIntent();
		Bundle b=ri.getExtras();
		String rscore=b.getString("userscore");
		score.setText(rscore);
		SharedPreferences fs=getSharedPreferences("scoredata", 0);
		String ld=fs.getString("high_score", "0");
		exit=(Button)findViewById(R.id.score_b1);
		retry=(Button)findViewById(R.id.score_b2);
		exit.setOnClickListener(this);
		retry.setOnClickListener(this);
		if(Integer.parseInt(score.getText().toString())>Integer.parseInt(ld))
		{
			tv2.setText("Bravo ! High Score");
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.score_b1)
		{
			//Exit
			finish();
			
			
		}
		else if(v.getId()==R.id.score_b2)
		{
			//Start New Game
			res="PLAY";
			finish();
		}
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i=new Intent();
		i.putExtra("res", res);
		setResult(RESULT_OK,i);
		super.finish();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		String temp=score.getText().toString();
		SharedPreferences fs=getSharedPreferences("scoredata", 0);
		SharedPreferences.Editor editor=fs.edit();
		editor.putString("high_score", temp);
		editor.commit();
		super.onDestroy();
	}

	
}
