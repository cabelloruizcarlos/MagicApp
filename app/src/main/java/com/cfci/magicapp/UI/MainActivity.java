package com.cfci.magicapp.UI;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cfci.magicapp.R;
import com.cfci.magicapp.ODLadapters.TestAdapter;
import com.cfci.magicapp.OLDmodel.Card;
import com.cfci.magicapp.OLDnetwork.JSONParser;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by eca on 06/10/15.
 */
public class MainActivity extends Activity {

	@Bind(R.id.main_text) TextView textView;

	private Card[] mCards;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		/*Code to test the Database*/
		TestAdapter mDbHelper = new TestAdapter(getApplicationContext());
		mDbHelper.createDatabase();
		mDbHelper.open();
		Cursor testdata = mDbHelper.getTestData();
		mDbHelper.close();

		/*Code to test the time to retrieve one card*/
		/*If I ve all the cards in an array it takes no time*/
		mCards = JSONParser.getCards(getApplicationContext());
		/*Getting it directly from the JSON takes ages
		Card newCard = JSONParser.getCard(getApplicationContext(), "Air Elemental");*/
		Card newCard = getCard("Air Elemental");
		if (newCard != null)
			textView.setText(newCard.getName());

		Toast.makeText(getApplicationContext(), "Its done!!!", Toast.LENGTH_SHORT).show();
	}

	private Card getCard(String name) {

		Card card = null;
		boolean found=false;
		for (int i=0;((i<mCards.length) && (!found));i++)
			if (mCards[i].getName().equals(name)){
				found =true;
				card = mCards[i];
			}
		return card;
	}
}
