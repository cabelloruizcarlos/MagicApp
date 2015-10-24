package com.cfci.magicapp.model;

import android.app.Activity;

/**
 * Created by Carlos on 24/10/2015.
 */
public class MagicActivity extends Activity {

	protected Card[] mCards;

	public Card[] getCards() {
		return mCards;
	}

	public void setCards(Card[] mCards) {
		this.mCards = mCards;
	}
}