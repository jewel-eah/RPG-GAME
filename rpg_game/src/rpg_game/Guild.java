package rpg_game;

import java.util.ArrayList;

public class Guild {
	private final int PARTY_SIZE = 4;
	public ArrayList<Unit> guildList = new ArrayList<>();
	private Unit[] partyList;

	public ArrayList<Unit> getGuildList() {
		return (ArrayList<Unit>) this.guildList.clone();
	}

	public void setGuild() {
		Unit temp = new Unit("보석", 2, 100, 10, 5, 0);
		this.guildList.add(temp);
		temp = new Unit("지은", 3, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("도하", 8, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("진경", 1, 70, 5, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("세린", 4, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("예지", 1, 120, 11, 7, 0);
		this.guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			guildList.get(i).setParty(true);
		}
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < this.guildList.size(); i++) {
			if (this.guildList.get(i).isParty() == true) {
				this.partyList[n] = this.guildList.get(i);
				n += 1;
			}
		}
	}

	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[ 골드 : " + Player.getMoney() + " ]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < this.guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
			System.out.println("======================================");
		}
	}

	public void printNonPartyUser() {
		System.out.println("======== [ 추가가능한 길드원 ] ========");
		for (int i = 0; i < this.guildList.size(); i++) {
			if (!guildList.get(i).isParty()) {
				System.out.print("[" + (i + 1) + "번]");
				System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
				System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
				System.out.print(" [체력 : " + guildList.get(i).getHp());
				System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
				System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
				System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
				System.out.println("");
				System.out.println("======================================");
			}
		}
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	private void buyUnit() {
		System.out.println(Player.getMoney());
		if (Player.getMoney() < 5000)
			return;

		String[] n1 = { "나", "정", "이", "차", "우", "민", "박" };
		String[] n2 = { "하", "도", "규", "서", "지", "예", "유" };
		String[] n3 = { "연", "현", "민", "나", "아", "율", "은" };
		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.setMoney(-5000);
	}

	private void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).isParty()) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel - 1).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + partyList[i].getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	private void partyChange() {

		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printNonPartyUser();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].setParty(false);
		guildList.get(guildNum - 1).setParty(true);

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(guildNum - 1).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private void printSortMenu() {
		System.out.println("=============== [정렬방법] ================");
		System.out.println("1. 이름순으로 정렬");
		System.out.println("2. 레벨순으로 정렬");
		System.out.println("0. 뒤로가기");
		int sel = MainGame.scan.nextInt();
		if(sel == 1) {
			sortUserByName();
		}
//		else if (sel == 2) {
//			sortUserByLevel();
//		}
		else if (sel == 0) {
			return;
		}
	}
	
	private void sortUserByName() {
		for(int i=0; i<guildList.size(); i++) {
			Unit unit = this.guildList.get(i);
			String name = unit.getName();
			int index = i;
		
			for(int j=0; i<guildList.size(); i++) {
				Unit nextUnit = this.guildList.get(j);
				
				if(name.compareTo(nextUnit.getName()) > 0) {
					name = nextUnit.getName();
					index = j;
				}
			}
			
			Unit temp = guildList.get(i);
			this.guildList.set(i, guildList.get(index));
			this.guildList.set(index, temp);
		}
		
		printAllUnitStaus();
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.파티원확인] [6.정렬]  [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 5) {
				printParty();
			} else if (sel == 6) {
				printSortMenu();
			} else if (sel == 0) {
				break;
			}
		}
	}

}