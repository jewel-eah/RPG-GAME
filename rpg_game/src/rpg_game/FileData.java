package rpg_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
	void save() throws IOException {
		FileWriter fout = null;
		String path = "gameData.txt";

		fout = new FileWriter(path);
		ArrayList<Unit> temp = Player.getGuildList();
		String gameData = "";
		gameData += Player.getMoney();
		gameData += "\r\n";
		gameData += temp.size();
		gameData += "\r\n";
		for (int i = 0; i < temp.size(); i++) {
			gameData += temp.get(i).getName();
			gameData += "/";
			gameData += temp.get(i).getLevel();
			gameData += "/";
			gameData += temp.get(i).getMaxHp();
			gameData += "/";
			gameData += temp.get(i).getAtt();
			gameData += "/";
			gameData += temp.get(i).getDef();
			gameData += "/";
			gameData += temp.get(i).getExp();
			gameData += "/";
			gameData += temp.get(i).isParty();
			gameData += "\r\n";
			if (temp.get(i).getWeapon() == null) {
				gameData += temp.get(i).getWeapon();
			} else {
				Item item = temp.get(i).getWeapon();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;

			}
			gameData += "/";
			if (temp.get(i).getArmor() == null) {
				gameData += temp.get(i).getArmor();
			} else {
				Item item = temp.get(i).getArmor();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;

			}
			gameData += "/";
			if (temp.get(i).getRing() == null) {
				gameData += temp.get(i).getRing();
			} else {
				Item item = temp.get(i).getRing();
				String weaponData = "";
				weaponData += item.getKind();
				weaponData += ",";
				weaponData += item.getName();
				weaponData += ",";
				weaponData += item.getPower();
				weaponData += ",";
				weaponData += item.getPrice();
				gameData += weaponData;
			}
			gameData += "\r\n";
		}
		gameData += Player.getItemSize();
		gameData += "\r\n";
		for (int i = 0; i < Player.getItemSize(); i++) {
			Item item = Player.getItemList().get(i);

			gameData += item.getKind();
			gameData += "/";
			gameData += item.getName();
			gameData += "/";
			gameData += item.getPower();
			gameData += "/";
			gameData += item.getPrice();
			gameData += "\r\n";
		}
		System.out.println(gameData);
		fout.write(gameData, 0, gameData.length());
		fout.close();

	}

	void loadData() throws IOException {
		File file = null;
		FileReader reader = null;
		BufferedReader br = null;
		String path = "gameData.txt";
		file = new File(path);
		if (file.exists()) {
			reader = new FileReader(path);
			br = new BufferedReader(reader);
			String money = br.readLine();
			Player.setMoney(Integer.parseInt(money));
			String guildSize = br.readLine();
			int size = Integer.parseInt(guildSize);
			// 메소드 처리 
			Player.guild.guildList.clear();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				String unitData = br.readLine();
				String[] unitArr = unitData.split("/");
				String name = unitArr[0];
				int level = Integer.parseInt(unitArr[1]);
				int maxhp = Integer.parseInt(unitArr[2]);
				int att = Integer.parseInt(unitArr[3]);
				int def = Integer.parseInt(unitArr[4]);
				int exp = Integer.parseInt(unitArr[5]);
				boolean party = Boolean.parseBoolean(unitArr[6]);
				Unit temp = new Unit(name, level, maxhp, att, def, exp, party);
				Player.guild.guildList.add(temp);
			// 여기까지용 	
				// ==================== item =======================
				String itemData = br.readLine();
				String itemArr[] = itemData.split("/");
				if (itemArr[0].equals("null")) {
					Player.getGuildList().get(i).setWeapon(null);
				} else {
					String[] weapon = itemArr[0].split(",");
					int itemKind = Integer.parseInt(weapon[0]);
					String itemName = weapon[1];
					int itemPower = Integer.parseInt(weapon[2]);
					int itemPrice = Integer.parseInt(weapon[3]);
					Item item = new Item();
					item.setItem(itemKind, itemName, itemPower, itemPrice);
					Player.getGuildList().get(i).setWeapon(item);
				}
				if (itemArr[1].equals("null")) {
					Player.getGuildList().get(i).setArmor(null);
				} else {
					String[] armor = itemArr[1].split(",");
					int itemKind = Integer.parseInt(armor[0]);
					String itemName = armor[1];
					int itemPower = Integer.parseInt(armor[2]);
					int itemPrice = Integer.parseInt(armor[3]);
					Item item = new Item();
					item.setItem(itemKind, itemName, itemPower, itemPrice);
					Player.getGuildList().get(i).setArmor(item);
				}
				if (itemArr[2].equals("null")) {
					Player.getGuildList().get(i).setRing(null);
				} else {
					String[] ring = itemArr[2].split(",");
					int itemKind = Integer.parseInt(ring[0]);
					String itemName = ring[1];
					int itemPower = Integer.parseInt(ring[2]);
					int itemPrice = Integer.parseInt(ring[3]);
					Item item = new Item();
					item.setItem(itemKind, itemName, itemPower, itemPrice);
					Player.getGuildList().get(i).setRing(item);
				}

			}
			// ===================== item ============================
			String invenSize = br.readLine();
			System.out.println(invenSize);
			int inSize = Integer.parseInt(invenSize);

			Player.getInventory().itemList.clear();
			for (int i = 0; i < inSize; i++) {
				String invenDate = br.readLine();
				String[] invenArr = invenDate.split("/");
				int itemKind = Integer.parseInt(invenArr[0]);
				String itemName = invenArr[1];
				int itemPower = Integer.parseInt(invenArr[2]);
				int itemPrice = Integer.parseInt(invenArr[3]);
				Item item = new Item();
				item.setItem(itemKind, itemName, itemPower, itemPrice);
//				Player.inven.itemList.add(item);
			}

		}
	}

}