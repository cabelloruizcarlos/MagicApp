package com.cfci.magicapp.OLDmodel;

/**
 * Created by Carlos on 06/10/2015.
 */
public class Util {

	public enum Type {
		INSTANT,
		SORCERY,
		ARTIFACT,
		CREATURE,
		ENCHANTMENT,
		LAND,
		PLANESWALKER;

		public static Type fromJSON(String state) {
			switch (state) {
				case "Instant":
					return INSTANT;
				case "Sorcery":
					return SORCERY;
				case "Artifact":
					return ARTIFACT;
				case "Creature":
					return CREATURE;
				case "Enchantment":
					return ENCHANTMENT;
				case "Land":
					return LAND;
				case "Planeswalker":
					return PLANESWALKER;
				default:
					return LAND;
			}
		}
	}

	public enum Supertype {
		BASIC,
		LEGENDARY,
		SNOW,
		WORLD,
		ONGOING;

		public static Supertype fromJSON(String state) {
			switch (state) {
				case "Basic":
					return BASIC;
				case "Legendary":
					return LEGENDARY;
				case "Snow":
					return SNOW;
				case "World":
					return WORLD;
				case "Ongoing":
					return ONGOING;
				default:
					return BASIC;
			}
		}
	}

	public enum Rarity {
		COMMON,
		UNCOMMON,
		RARE,
		MYTHICRARE,
		SPECIAL,
		BASICLAND;

		public static Rarity fromJSON(String state) {
			switch (state) {
				case "Common":
					return COMMON;
				case "Uncommon":
					return UNCOMMON;
				case "Rare":
					return RARE;
				case "Mythic Rare":
					return MYTHICRARE;
				case "Special":
					return SPECIAL;
				case "Basic Land":
					return BASICLAND;
				default:
					return COMMON;
			}
		}
	}
}

