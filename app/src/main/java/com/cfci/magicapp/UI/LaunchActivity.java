package com.cfci.magicapp.UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import com.cfci.magicapp.Launch.ILaunchView;
import com.cfci.magicapp.Launch.LaunchPresenter;
import com.cfci.magicapp.R;

/**
 * Created by Carlos on 20/10/2015.
 */
public class LaunchActivity extends Activity implements ILaunchView {

	private final int SPLASH_DISPLAY_LENGTH = 5000;
	LaunchPresenter mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		// Give to the Presenter a reference to the View
		mPresenter = new LaunchPresenter(this);
		mPresenter.initApp();
	}

	public void doTransitionAnimationRighttoLeft() {

		Display display = ((WindowManager) 	getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		if ((display.getRotation() == Surface.ROTATION_0) ||
				(display.getRotation() == Surface.ROTATION_180))
			overridePendingTransition(R.anim.enter_from_left, R.anim.exit_from_left);
	}

	@Override
	public void navigateToMainActivity(){

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(LaunchActivity.this, MainActivity.class);
				startActivity(i);
				doTransitionAnimationRighttoLeft();
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}
