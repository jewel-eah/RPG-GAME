package day04_rpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("냥냥펀치");
		temp.setPower(3);
		temp.setPrice(3000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("딱총나무지팡이");
		temp.setPower(10);
		temp.setPrice(8000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("빛나는 막대사탕");
		temp.setPower(12);
		temp.setPrice(8500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("병아리잠옷");
		temp.setPower(2);
		temp.setPrice(2000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("해리포터교복");
		temp.setPower(3);
		temp.setPrice(3000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("우비");
		temp.setPower(4);
		temp.setPrice(3500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("실반지");
		temp.setPower(4);
		temp.setPrice(3500);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("마이스터링");
		temp.setPower(5);
		temp.setPrice(4000);
		itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("다이아우정링");
		temp.setPower(7);
		temp.setPrice(5000);
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = MainGame.scan.nextInt();
			if (selKind == 0)
				return;
			while (true) {
				if (selKind == Item.WEAPON)
					System.out.println("=========== [무기] ============");
				else if (selKind == Item.ARMOR)
					System.out.println("=========== [방어구] ============");
				else if (selKind == Item.RING)
					System.out.println("=========== [반지] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.scan.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							Player.inven.addItem(itemList.get(i));
							int payPrice = Player.getMoney() - itemList.get(i).getPrice();
							Player.setMoney(payPrice);
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "] ");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "] ");
			System.out.print("[가격 : " + itemList.get(i).getPrice()+ "골드]");
			System.out.println("");
			count += 1;
		}
	}

}