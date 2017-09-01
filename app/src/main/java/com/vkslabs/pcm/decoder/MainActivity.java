package com.vkslabs.pcm.decoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		findViewById(R.id.btDecode).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						doDecode();

					}
				});

	}

	private void doDecode() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				try {
					String inputPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
							.getAbsolutePath() + "/" + "voicemail.wav";

					String outputPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
							.getAbsolutePath() + "/" + "decoded_songwav.wav";

				new PCMDecoder().decode(inputPath, outputPath, new PCMDecoder.DecodeListener() {
					@Override
					public void updateProgress(int progress) {
						Log.d(TAG, "Progress --> " + progress);
					}
				});
				} catch (Exception e) {
					Log.e(TAG, e.getMessage(), e);
				}

			}
		}).start();

	}
}
