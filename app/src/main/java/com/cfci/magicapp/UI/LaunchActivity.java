package com.cfci.magicapp.UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import com.cfci.magicapp.R;

import butterknife.Bind;

/**
 * Created by Carlos on 20/10/2015.
 */
public class LaunchActivity extends Activity {

	@Bind(R.anim.enter_from_left) int enfl;
	@Bind(R.anim.exit_from_left) int exfl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		InitAppTask task = new InitAppTask();
		task.execute();
	}

	private void doPageTransitionAnimationRighttoLeft() {

		Display display = ((WindowManager) 	getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		if ((display.getRotation() == Surface.ROTATION_0) ||
				(display.getRotation() == Surface.ROTATION_180))
		{
			overridePendingTransition(enfl, exfl);
		}
	}

	private class InitAppTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... String) {
			try {
				// Thread will sleep for 2 seconds
				Thread.sleep(2 * 1000);
			} catch (Exception e) {

			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {

			Intent i = new Intent(LaunchActivity.this, MainActivity.class);
			startActivity(i);
			doPageTransitionAnimationRighttoLeft();
			finish();
		}
	}
}
