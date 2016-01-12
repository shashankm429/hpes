package com.example.hpes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraDemo extends Activity implements OnClickListener {
Button cam;
ImageView campic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_demo);
		cam=(Button)findViewById(R.id.cam_b1);
		campic=(ImageView)findViewById(R.id.cam_iv);
		cam.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) 
	{

		Intent cameraIntent;
		String cian=android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
		cameraIntent=new Intent(cian);
		startActivityForResult(cameraIntent, 21);
		
	}

	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent res) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, res);
			if(resultCode==RESULT_OK)
			{Bundle b=res.getExtras();
			if(b!=null)
			{Bitmap image=(Bitmap) b.get("data");
			campic.setImageBitmap(image);
		}}
	}
}
