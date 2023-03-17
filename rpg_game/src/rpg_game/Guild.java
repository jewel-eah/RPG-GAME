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
		Unit temp = new Unit("����", 2, 100, 10, 5, 0);
		this.guildList.add(temp);
		temp = new Unit("����", 3, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("����", 8, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("����", 1, 70, 5, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("����", 4, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("����", 1, 120, 11, 7, 0);
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
		System.out.println("[ ��� : " + Player.getMoney() + " ]");
		System.out.println("============= [����] =================");
		for (int i = 0; i < this.guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "��]");
			System.out.print(" [�̸� : " + guildList.get(i).getName() + "]");
			System.out.print(" [���� : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [ü�� : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[���ݷ� : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [���� : " + guildList.get(i).getDef() + "]");
			System.out.println(" [��Ƽ�� : " + guildList.get(i).isParty() + "]");
			System.out.println("");
			System.out.println("======================================");
		}
	}

	public void printNonPartyUser() {
		System.out.println("======== [ �߰������� ���� ] ========");
		for (int i = 0; i < this.guildList.size(); i++) {
			if (!guildList.get(i).isParty()) {
				System.out.print("[" + (i + 1) + "��]");
				System.out.print(" [�̸� : " + guildList.get(i).getName() + "]");
				System.out.print(" [���� : " + guildList.get(i).getLevel() + "]");
				System.out.print(" [ü�� : " + guildList.get(i).getHp());
				System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
				System.out.print("[���ݷ� : " + guildList.get(i).getAtt() + "]");
				System.out.print(" [���� : " + guildList.get(i).getDef() + "]");
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

		String[] n1 = { "��", "��", "��", "��", "��", "��", "��" };
		String[] n2 = { "��", "��", "��", "��", "��", "��", "��" };
		String[] n3 = { "��", "��", "��", "��", "��", "��", "��" };
		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[�̸� : " + name + "]");
		System.out.print(" [���� : " + 1 + "]");
		System.out.print(" [ü�� : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[���ݷ� : " + att + "]");
		System.out.println(" [���� : " + def + "]");
		System.out.println("������ �߰��մϴ�.");
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
		System.out.println("������ ��ȣ�� �Է��ϼ��� ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).isParty()) {
			System.out.println("��Ƽ���� ����� �����Ҽ� �����ϴ�.");
		} else {
			System.out.println("=================================");
			System.out.print("[�̸� : " + guildList.get(sel - 1).getName() + "]");
			System.out.println("������ �����մϴ�.");
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
		System.out.println("================ [��Ƽ��] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "��]");
			System.out.print(" [�̸� : " + partyList[i].getName() + "]");
			System.out.print(" [���� : " + partyList[i].getLevel() + "]");
			System.out.print(" [ü�� : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[���ݷ� : " + partyList[i].getAtt() + "]");
			System.out.print(" [���� : " + partyList[i].getDef() + "]");
			System.out.println(" [��Ƽ�� : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	private void partyChange() {

		printParty();
		System.out.println("��ü�� ��ȣ�� �Է��ϼ��� ");
		int partyNum = MainGame.scan.nextInt();
		printNonPartyUser();
		System.out.println("������ ��ȣ�� �Է��ϼ��� ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].setParty(false);
		guildList.get(guildNum - 1).setParty(true);

		System.out.println("====================================");
		System.out.print("[�̸� : " + partyList[partyNum - 1].getName() + "]");
		System.out.print("���� ");
		System.out.print("[�̸� : " + guildList.get(guildNum - 1).getName() + "]");
		System.out.println("���� ��ü �մϴ�. ");
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
		System.out.println("=============== [���Ĺ��] ================");
		System.out.println("1. �̸������� ����");
		System.out.println("2. ���������� ����");
		System.out.println("0. �ڷΰ���");
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
			System.out.println("=============== [������] ================");
			System.out.println("[1.�����] [2.�����߰�] [3.��������]\n" + "[4.��Ƽ����ü] [5.��Ƽ��Ȯ��] [6.����]  [0.�ڷΰ���]");
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