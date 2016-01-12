package com.example.hpes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class Dictionary extends Activity implements OnClickListener {

	Button b;
	TextView tv,tv1,tv2,tv3;
	AutoCompleteTextView actv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		actv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> ad;
		ad=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,DictionarySupport.word);
		
		actv.setAdapter(ad);
		tv=(TextView)findViewById(R.id.textView2);
		tv1=(TextView)findViewById(R.id.textView3);
		tv2=(TextView)findViewById(R.id.textView4);
		tv3=(TextView)findViewById(R.id.textView5);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int i;
		String str=actv.getText().toString();
		for(i=0;i<4;i++)
		{
			if((str.compareToIgnoreCase((DictionarySupport.word[i])))==0)
		{
				tv.setText(DictionarySupport.word[i]);
		tv1.setText(DictionarySupport.meaning[i]);
		tv2.setText(DictionarySupport.detail[i]);
		tv3.setText("");
		break;
		}
						
		}
		if(i==4)
		{
			tv1.setText("");
			tv.setText("");
			tv2.setText("");
			tv3.setText("No results found , go online");
			tv3.setTextColor(Color.RED);
		}
	}

	
}
