package com.cfci.magicapp.OLDmodel;

/**
 * Created by Carlos on 06/10/2015.
 */
public class Card {

	private String name;
	private String manaCost;
	private int cmc;
	private String colour;

	private String type;
	private Util.Supertype superType;
	private Util.Type types;
	private String subTypes;
	private Util.Rarity rarity;
	private int loyalty;

	private String text;
	private String flavor;

	private String artist;
	private String number;

	private String power;
	private String toughness;

	private String layout;
	private int multiverseId;
	private String id;

	public Card(){
		this.name = Constants.NO_CARD_FOUND;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public int getCmc() {
		return cmc;
	}

	public void setCmc(int cmc) {
		this.cmc = cmc;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Util.Supertype getSuperType() {
		return superType;
	}

	public void setSuperType(Util.Supertype superType) {
		this.superType = superType;
	}

	public Util.Type getTypes() {
		return types;
	}

	public void setTypes(Util.Type types) {
		this.types = types;
	}

	public String getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(String subTypes) {
		this.subTypes = subTypes;
	}

	public Util.Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Util.Rarity rarity) {
		this.rarity = rarity;
	}

	public int getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public int getMultiverseId() {
		return multiverseId;
	}

	public void setMultiverseId(int multiverseId) {
		this.multiverseId = multiverseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
