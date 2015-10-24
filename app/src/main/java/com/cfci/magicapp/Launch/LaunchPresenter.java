package com.cfci.magicapp.Launch;

import android.content.Context;

import com.cfci.magicapp.R;
import com.cfci.magicapp.model.Card;
import com.cfci.magicapp.model.MagicActivity;
import com.cfci.magicapp.network.JSONParser;

import java.io.InputStream;

/**
 * Created by Carlos on 22/10/2015.
 */
public class LaunchPresenter implements ILaunchPresenter{

	private ILaunchView mView;

	public LaunchPresenter(ILaunchView launchView) {
		this.mView = launchView;
	}

	@Override
	public void initApp(MagicActivity pActivity){

		// Retrieve the cards from the JSON
		Card[] cards = JSONParser.getCards(pActivity.getResources().openRawResource(R.raw.twocards));
		pActivity.setCards(cards);

		this.mView.navigateToMainActivity();
	}
}
