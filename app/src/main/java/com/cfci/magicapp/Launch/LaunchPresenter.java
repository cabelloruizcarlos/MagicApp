package com.cfci.magicapp.Launch;

/**
 * Created by Carlos on 22/10/2015.
 */
public class LaunchPresenter implements ILaunchPresenter{

	private ILaunchView mView;

	public LaunchPresenter(ILaunchView launchView) {
		this.mView = launchView;
	}

	@Override
	public void initApp(){
		this.mView.navigateToMainActivity();
	}
}
