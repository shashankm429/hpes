package com.example.hpes;

import android.app.Activity;
import android.app.AlertDialog;

import java.io.File;
import java.io.IOException;

import com.example.hpes.Game.MyDialogHandler;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DrawerDemo extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer_demo);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		if(position==0)
		fragmentManager.beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
				.commit();
		
		else if(position==1)
			fragmentManager.beginTransaction().replace(R.id.container, MyFragment.newInstance(position + 1))
					.commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.drawer_demo, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements OnClickListener,OnSeekBarChangeListener {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		Button b1,b2,b3;
		static MediaPlayer player;
		TextView t,t1;
		SeekBar sb;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_music_player, container, false);
			b1=(Button)rootView.findViewById(R.id.button1);
			b2=(Button)rootView.findViewById(R.id.button2);
			b3=(Button)rootView.findViewById(R.id.button3);
			sb=(SeekBar)rootView.findViewById(R.id.seekBar1);
			t=(TextView)rootView.findViewById(R.id.textView2);
			t1=(TextView)rootView.findViewById(R.id.textView3);
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
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((DrawerDemo) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
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
	}
	
	public static class MyFragment extends Fragment implements OnClickListener{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static MyFragment newInstance(int sectionNumber) {
			MyFragment fragment = new MyFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public MyFragment() {
		}
		EditText et1,et2,et3;
		Button b1,b2,b3,b4;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_calculator, container, false);
			et1=(EditText)rootView.findViewById(R.id.calc_et1);
			et2=(EditText)rootView.findViewById(R.id.calc_et2);
			et3=(EditText)rootView.findViewById(R.id.calc_et3);
			b1=(Button)rootView.findViewById(R.id.calc_b1);
			b2=(Button)rootView.findViewById(R.id.calc_b2);
			b3=(Button)rootView.findViewById(R.id.calc_b3);
			b4=(Button)rootView.findViewById(R.id.calc_b4);
			b1.setOnClickListener(this);
			b2.setOnClickListener(this);
			b3.setOnClickListener(this);
			b4.setOnClickListener(this);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((DrawerDemo) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
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
	
	}

	


