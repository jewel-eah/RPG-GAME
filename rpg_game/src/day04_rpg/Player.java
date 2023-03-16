package day04_rpg;

import java.util.ArrayList;

public class Player {
	private static int money;
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();

	public Player() {
		money = 100000;
		guild.setGuild();
	}

	public static int getMoney(){
		return money;
	}
	
	public static void setMoney(int setMoney) {
		money = setMoney;
	}
	
	public void guildMenu() {
		guild.guildMenu();
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.guildList;
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.guildList.size();
	}

	static public int getItemSize() {
		return inven.itemList.size();
	}
}