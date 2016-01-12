package com.example.hpes;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingScreen extends PreferenceActivity 
{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.pref);
}
}
