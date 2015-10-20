package com.cfci.magicapp.network;

import android.content.Context;

import com.cfci.magicapp.R;
import com.cfci.magicapp.model.Card;
import com.cfci.magicapp.model.Constants;
import com.cfci.magicapp.model.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by Carlos on 06/10/2015.
 */
public class JSONParser {

	public static String retrieveData(InputStream result) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(result));
		String line;

		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	/*Receiving the name of a card(parameter) the method returns a Card object. If the card isn't there its name will be Constants.NO_CARD_FOUND*/
	public static Card getCard(Context pContext, String cardName) {
		// TODO: Check if I can avoid to sent as a parameter the Context
		Card newCard = new Card();
		JSONObject cardData = null;
		try {
			cardData = new JSONObject(JSONParser.retrieveData(pContext.getResources().openRawResource(R.raw.allcards)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		if (cardData.length() < 0) {
			/*TODO: Define what are we going to do if the JSON file is empty*/
		} else {
			try {
				Iterator x = cardData.keys();
				boolean found = false;
				while ((x.hasNext()) && (!found)) {
					String key = (String) x.next();
					if (key.equals(cardName)) {
						found = true;
						newCard = parseData((JSONObject) cardData.get(key));
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (newCard.getName() == Constants.NO_CARD_FOUND)
			return null;
		else
			return newCard;
	}

	public static Card[] getCards(Context pContext) {

		Card[] cards = null;
		JSONObject cardData = null;
		try {
			cardData = new JSONObject(JSONParser.retrieveData(pContext.getResources().openRawResource(R.raw.twocards)));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		if (cardData.length() < 0) {
			/*TODO: Define what are we going to do if the JSON file is empty*/
		} else {
			try {
				cards = new Card[cardData.length()];
				Iterator x = cardData.keys();
				int i=0;
				while (x.hasNext()) {
					String key = (String) x.next();
					Card newCard = parseData((JSONObject) cardData.get(key));

					cards[i] = newCard;
					i++;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return cards;
	}

	private static Card parseData(JSONObject jsonObject) {
		Card data = new Card();
		JSONArray jsonArray = null;

		try {
			if (jsonObject.has("name")) {
				data.setName(jsonObject.getString("name"));
			} else {
				data.setName("");
			}
			if (jsonObject.has("manaCost")) {
				data.setManaCost(jsonObject.getString("manaCost"));
			} else {
				data.setManaCost("0");
			}
			if (jsonObject.has("cmc")) {
				data.setCmc(Integer.parseInt(jsonObject.getString("cmc")));
			} else {
				data.setCmc(0);
			}
			if (jsonObject.has("colors")) {
				jsonArray = jsonObject.getJSONArray("colors");
				data.setColour((String) jsonArray.get(0));
			} else {
				data.setColour("");
			}
			if (jsonObject.has("type")) {
				data.setType(jsonObject.getString("type"));
			} else {
				data.setType("");
			}
			if (jsonObject.has("supertypes")) {
				jsonArray = jsonObject.getJSONArray("supertypes");
				data.setSuperType(Util.Supertype.fromJSON((String) jsonArray.get(0)));
			} else {
				data.setSuperType(Util.Supertype.BASIC);
			}
			if (jsonObject.has("types")) {
				jsonArray = jsonObject.getJSONArray("types");
				data.setTypes(Util.Type.fromJSON((String) jsonArray.get(0)));
			} else {
				data.setTypes(Util.Type.LAND);
			}
			if (jsonObject.has("subtypes")) {
				jsonArray = jsonObject.getJSONArray("subtypes");
				data.setTypes(Util.Type.fromJSON((String) jsonArray.get(0)));
			} else {
				data.setSubTypes("");
			}
			if (jsonObject.has("rarity")) {
				jsonArray = jsonObject.getJSONArray("rarity");
				data.setRarity(Util.Rarity.fromJSON((String) jsonArray.get(0)));
			} else {
				data.setRarity(Util.Rarity.COMMON);
			}
			if (jsonObject.has("text")) {
				data.setText(jsonObject.getString("text"));
			} else {
				data.setText("");
			}
			if (jsonObject.has("flavor")) {
				data.setFlavor(jsonObject.getString("flavor"));
			} else {
				data.setFlavor("");
			}
			if (jsonObject.has("artist")) {
				data.setArtist(jsonObject.getString("artist"));
			} else {
				data.setArtist("");
			}
			if (jsonObject.has("number")) {
				data.setNumber(jsonObject.getString("number"));
			} else {
				data.setNumber("0");
			}
			if (jsonObject.has("power")) {
				data.setPower(jsonObject.getString("power"));
			} else {
				data.setPower("N/A");
			}
			if (jsonObject.has("toughness")) {
				data.setToughness(jsonObject.getString("toughness"));
			} else {
				data.setToughness("N/A");
			}
			if (jsonObject.has("layout")) {
				data.setLayout(jsonObject.getString("layout"));
			} else {
				data.setLayout("");
			}
			if (jsonObject.has("multiverseid")) {
				data.setMultiverseId(Integer.parseInt(jsonObject.getString("multiverseid")));
			} else {
				data.setMultiverseId(0);
			}
			if (jsonObject.has("id")) {
				data.setId(jsonObject.getString("id"));
			} else {
				data.setId("");
			}
				/*Specific fields*/
			if (jsonObject.has("loyalty")) {
				data.setId(jsonObject.getString("loyalty"));
			} else {
				data.setId("");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return data;
	}
}
