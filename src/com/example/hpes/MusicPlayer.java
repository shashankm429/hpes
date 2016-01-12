package com.example.hpes;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MusicPlayer extends Activity implements OnClickListener,OnSeekBarChangeListener {
	Button b1,b2,b3;
	static MediaPlayer player;
	TextView t,t1;
	SeekBar sb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_player);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		sb=(SeekBar)findViewById(R.id.seekBar1);
		t=(TextView)findViewById(R.id.textView2);
		t1=(TextView)findViewById(R.id.textView3);
		
		if(player==null)
		{
			//player=MediaPlayer.create(this, R.raw.mymusic);
			File sdcard=Environment.getExternalStorageDirectory();
			String spath=sdcard.getPath()+"/mastkalandar.mp3";
			player= new MediaPlayer();
			try {
				player.setDataSource(spath);
				player.prepare();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		sb.setMax(player.getDuration());
		sb.setOnSeekBarChangeListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		Thread process= new Thread(){
			public void run()
			{
				while(player.getCurrentPosition()<=player.getDuration())
				{
					sb.setProgress(player.getCurrentPosition());
				
				}
			}
		};
		process.start();
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		long ms,ms1,ff;
		switch(v.getId())
		{
		
		case R.id.button1:
			if(player.isPlaying()==true)
			{
			player.seekTo(0);
			}
			player.start();
			ms=player.getDuration();
			long s=ms/1000;
			ms1=player.getCurrentPosition();
			long s1=ms1/1000;
			
			t.setText(String.valueOf(s));
		    
			break;
		case R.id.button2:
			player.pause();
			break;
		case R.id.button3:
			ff=player.getCurrentPosition()+5000;
			
			player.seekTo((int) ff);
			break;
			
		}
	}


	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		t1.setText(String.valueOf(player.getCurrentPosition()/1000));
		if(fromUser)
			player.seekTo(progress);
	}


	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
