package card;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class CardLibrary {

	public ArrayList<Card> cardList;
	
	public CardLibrary() {
		cardList = new ArrayList<Card>();
		
		//Card id: 00 - Tornado
		ImageIcon image_00_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-0.png"));
		ImageIcon image_00_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-0.png"));
		
		DiceCard card_00_01 = new DiceCard();
		card_00_01.setCardImage(image_00_Small, image_00_Big);
		card_00_01.setCardID(0);
		card_00_01.setCardCondition(0, 3);
		card_00_01.actionCard(true, false, true, false, false, false, false, false);
		card_00_01.cardTxt  = "req : max 3, min 0\n"
				+ "to do: bỏ đi (số chấm trên xúc xắc) (lá bài) và rút lại (số chấm trên xúc sắc) (lá bài) ";
		cardList.add(card_00_01); //0
		
		DiceCard card_00_02 = new DiceCard();
		card_00_02.setCardImage(image_00_Small, image_00_Big);
		card_00_02.setCardID(0);
		card_00_02.setCardCondition(0, 3);
		card_00_02.actionCard(true, false, true, false, false, false, false, false);
		card_00_02.cardTxt  = "req : max 3, min 0\n"
				+ "to do: bỏ đi (số chấm trên xúc xắc) (lá bài) và rút lại (số chấm trên xúc sắc) (lá bài) ";
		cardList.add(card_00_02); //1
		
		DiceCard card_00_03 = new DiceCard();
		card_00_03.setCardImage(image_00_Small, image_00_Big);
		card_00_03.setCardID(0);
		card_00_03.setCardCondition(0, 3);
		card_00_03.actionCard(true, false, true, false, false, false, false, false);
		card_00_03.cardTxt  = "req : max 3, min 0\n"
				+ "to do: bỏ đi (số chấm trên xúc xắc) (lá bài) và rút lại (số chấm trên xúc sắc) (lá bài) ";
		cardList.add(card_00_03);//2
		
		
		//DiceCard id: 01 - Hammer 
		ImageIcon image_01_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-1.png"));
		ImageIcon image_01_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-1.png"));
		
		DiceCard card_01_01 = new DiceCard();
		card_01_01.setCardImage(image_01_Small, image_01_Big);
		card_01_01.setCardID(1);
		card_01_01.setCardCondition(0, 4);
		card_01_01.actionCard(false, false, false, false, true, false, false, false);
		card_01_01.setScaleAttack(2, 0);
		card_01_01.cardTxt = "req max 4, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù";
		cardList.add(card_01_01);//3
		
		DiceCard card_01_02 = new DiceCard();
		card_01_02.setCardImage(image_01_Small, image_01_Big);
		card_01_02.setCardID(1);
		card_01_02.setCardCondition(0, 4);
		card_01_02.actionCard(false, false, false, false, true, false, false, false);
		card_01_02.setScaleAttack(2, 0);
		card_01_02.cardTxt = "req max 4, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù";
		cardList.add(card_01_02);//4
		
		DiceCard card_01_03 = new DiceCard();
		card_01_03.setCardImage(image_01_Small, image_01_Big);
		card_01_03.setCardID(1);
		card_01_03.setCardCondition(0, 4);
		card_01_03.actionCard(false, false, false, false, true, false, false, false);
		card_01_03.setScaleAttack(2, 0);
		card_01_03.cardTxt = "req max 4, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù";
		cardList.add(card_01_03);//5
		
		
		//DiceCard id: 02 - Boomerang 
		ImageIcon image_02_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-2.png"));
		ImageIcon image_02_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-2.png"));
		
		DiceCard card_02_01 = new DiceCard();
		card_02_01.setCardImage(image_02_Small, image_02_Big);
		card_02_01.setCardID(2);
		// default condition
		card_02_01.actionCard(false, false, false, false, true, false, false, true);
		card_02_01.setScaleAttack(2, 0);
		card_02_01.cardTxt = "req max 5, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù và gây (số chấm trên xúc sắc) (sát thương) lên bản thân";
		cardList.add(card_02_01);//6
		
		DiceCard card_02_02 = new DiceCard();
		card_02_02.setCardImage(image_02_Small, image_02_Big);
		card_02_02.setCardID(2);
		// default condition
		card_02_02.actionCard(false, false, false, false, true, false, false, true);
		card_02_02.setScaleAttack(2, 0);
		card_02_02.cardTxt = "req max 5, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù và gây (số chấm trên xúc sắc) (sát thương) lên bản thân";
		cardList.add(card_02_02);//7
		
		DiceCard card_02_03 = new DiceCard();
		card_02_03.setCardImage(image_02_Small, image_02_Big);
		card_02_03.setCardID(2);
		// default condition
		card_02_03.actionCard(false, false, false, false, true, false, false, true);
		card_02_03.setScaleAttack(2, 0);
		card_02_03.cardTxt = "req max 5, min 0\r\n"
				+ "todo: gây (số chấm trên xúc sắc)*2 (sát thương) lên kẻ thù và gây (số chấm trên xúc sắc) (sát thương) lên bản thân";
		cardList.add(card_02_03);//8
		
		
		//DiceCard id: 03 - Sword 
		ImageIcon image_03_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-3.png"));
		ImageIcon image_03_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-3.png"));
				
		DiceCard card_03_01 = new DiceCard();
		card_03_01.setCardImage(image_03_Small, image_03_Big);
		card_03_01.setCardID(3);
		// default condition
		card_03_01.actionCard(false, false, false, false, true, false, false, false);
		card_03_01.setScaleAttack(1, 0);
		card_03_01.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: gây (số chấm thên xúc săc) (sát thương) lên kẻ thù";
		cardList.add(card_03_01);//9
		
		DiceCard card_03_02 = new DiceCard();
		card_03_02.setCardImage(image_03_Small, image_03_Big);
		card_03_02.setCardID(3);
		// default condition
		card_03_02.actionCard(false, false, false, false, true, false, false, false);
		card_03_02.setScaleAttack(1, 0);
		card_03_02.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: gây (số chấm thên xúc săc) (sát thương) lên kẻ thù";
		cardList.add(card_03_02);//10
				
		DiceCard card_03_03 = new DiceCard();
		card_03_03.setCardImage(image_03_Small, image_03_Big);
		card_03_03.setCardID(3);
		// default condition
		card_03_03.actionCard(false, false, false, false, true, false, false, false);
		card_03_03.setScaleAttack(1, 0);
		card_03_03.cardTxt = "req: max5, min 0\r\n"
				+ "todo: gây (số chấm thên xúc săc) (sát thương) lên kẻ thù";
		cardList.add(card_03_03);//11
		
		
		//DiceCard id: 04 - Whip 
		ImageIcon image_04_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-4.png"));
		ImageIcon image_04_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-4.png"));
				
		DiceCard card_04_01 = new DiceCard();
		card_04_01.setCardImage(image_04_Small, image_04_Big);
		card_04_01.setCardID(4);
		// default condition
		card_04_01.actionCard(false, false, false, false, true, false, false, false);
		card_04_01.setScaleAttack(-1, 5);
		card_04_01.cardTxt = "req max 5, min 0\r\n"
				+ "todo; gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ thù";
		cardList.add(card_04_01);//12
				
		DiceCard card_04_02 = new DiceCard();
		card_04_02.setCardImage(image_04_Small, image_04_Big);
		card_04_02.setCardID(4);
		// default condition
		card_04_02.actionCard(false, false, false, false, true, false, false, false);
		card_04_02.setScaleAttack(-1, 5);
		card_04_02.cardTxt = "req max 5, min 0\r\n"
				+ "todo; gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ thù";
		cardList.add(card_04_02);//13
				
		DiceCard card_04_03 = new DiceCard();
		card_04_03.setCardImage(image_04_Small, image_04_Big);
		card_04_03.setCardID(4);
		// default condition
		card_04_03.actionCard(false, false, false, false, true, false, false, false);
		card_04_03.setScaleAttack(-1, 5);
		card_04_03.cardTxt = "req max 5, min 0\r\n"
				+ "todo; gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ thù";
		cardList.add(card_04_03);//14
		
		
		//DiceCard id: 05 - Draw 2
		ImageIcon image_05_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-5.png"));
		ImageIcon image_05_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-5.png"));
				
		DiceCard card_05_01 = new DiceCard();
		card_05_01.setCardImage(image_05_Small, image_05_Big);
		card_05_01.setCardID(5);
		// default condition
		card_05_01.actionCard(false, false, true, false, false, false, false, false);
		card_05_01.setScaleDraw(0, 2);
		card_05_01.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: rút 2 lá bài từ bộ bài lên tay";
		cardList.add(card_05_01); //15
		
		DiceCard card_05_02 = new DiceCard();
		card_05_02.setCardImage(image_05_Small, image_05_Big);
		card_05_02.setCardID(5);
		// default condition
		card_05_02.actionCard(false, false, true, false, false, false, false, false);
		card_05_02.setScaleDraw(0, 2);
		card_05_02.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: rút 2 lá bài từ bộ bài lên tay";
		cardList.add(card_05_02); //16
		
		DiceCard card_05_03 = new DiceCard();
		card_05_03.setCardImage(image_05_Small, image_05_Big);
		card_05_03.setCardID(5);
		// default condition
		card_05_03.actionCard(false, false, true, false, false, false, false, false);
		card_05_03.setScaleDraw(0, 2);
		card_05_03.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: rút 2 lá bài từ bộ bài lên tay";
		cardList.add(card_05_03);//17
		
		
		//DiceCard id: 06 - Re-roll 1
		ImageIcon image_06_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-6.png"));
		ImageIcon image_06_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-6.png"));
				
		DiceCard card_06_01 = new DiceCard();
		card_06_01.setCardImage(image_06_Small, image_06_Big);
		card_06_01.setCardID(6);
		// default condition
		card_06_01.actionCard(false, false, false, true, false, false, false, false);
		card_06_01.setScaleRoll(1, -1, 0, 0);
		card_06_01.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: nhận 1 xúc sắc bất kì";
		cardList.add(card_06_01); //18
		
		DiceCard card_06_02 = new DiceCard();
		card_06_02.setCardImage(image_06_Small, image_06_Big);
		card_06_02.setCardID(6);
		// default condition
		card_06_02.actionCard(false, false, false, true, false, false, false, false);
		card_06_02.setScaleRoll(1, -1, 0, 0);
		card_06_02.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: nhận 1 xúc sắc bất kì";
		cardList.add(card_06_02); //19
		
		DiceCard card_06_03 = new DiceCard();
		card_06_03.setCardImage(image_06_Small, image_06_Big);
		card_06_03.setCardID(6);
		// default condition
		card_06_03.actionCard(false, false, false, true, false, false, false, false);
		card_06_03.setScaleRoll(1, -1, 0, 0);
		card_06_03.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: nhận 1 xúc sắc bất kì";
		cardList.add(card_06_03);//20
				
		
		//DiceCard id: 07 - Gold Paint
		ImageIcon image_07_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-7.png"));
		ImageIcon image_07_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-7.png"));
				
		DiceCard card_07_01 = new DiceCard();
		card_07_01.setCardImage(image_07_Small, image_07_Big);
		card_07_01.setCardID(7);
		card_07_01.setCardCondition(3, 5);
		card_07_01.actionCard(false, false, false, true, false, false, false, false);
		card_07_01.setScaleRoll(1, 6, 0, 0);
		card_07_01.cardTxt = "req: max 5, min 3\r\n"
				+ "todo: nhận 1 xúc sắc Hoàng kim";
		cardList.add(card_07_01); //21
		
		DiceCard card_07_02 = new DiceCard();
		card_07_02.setCardImage(image_07_Small, image_07_Big);
		card_07_02.setCardID(7);
		card_07_02.setCardCondition(3, 5);
		card_07_02.actionCard(false, false, false, true, false, false, false, false);
		card_07_02.setScaleRoll(1, 6, 0, 0);
		card_07_02.cardTxt = "req: max 5, min 3\r\n"
				+ "todo: nhận 1 xúc sắc Hoàng kim";
		cardList.add(card_07_02); //22
		
		DiceCard card_07_03 = new DiceCard();
		card_07_03.setCardImage(image_07_Small, image_07_Big);
		card_07_03.setCardID(7); 
		card_07_03.setCardCondition(3, 5);
		card_07_03.actionCard(false, false, false, true, false, false, false, false);
		card_07_03.setScaleRoll(1, 6, 0, 0);
		card_07_03.cardTxt = "req: max 5, min 3\r\n"
				+ "todo: nhận 1 xúc sắc Hoàng kim";
		cardList.add(card_07_03);//23
		
		
		//DiceCard id: 08 - Silver Paint
		ImageIcon image_08_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-8.png"));
		ImageIcon image_08_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-8.png"));
		
		DiceCard card_08_01 = new DiceCard();
		card_08_01.setCardImage(image_08_Small, image_08_Big);
		card_08_01.setCardID(8);
		card_08_01.setCardCondition(0, 2);
		card_08_01.actionCard(false, false, false, true, false, false, false, false);
		card_08_01.setScaleRoll(1, 7, 0, 0);
		card_08_01.cardTxt = "req: max 2, min 0\r\n"
				+ "todo: nhận 1 xúc sắc Bạc";
		cardList.add(card_08_01); //24
		
		DiceCard card_08_02 = new DiceCard();
		card_08_02.setCardImage(image_08_Small, image_08_Big);
		card_08_02.setCardID(8);
		card_08_02.setCardCondition(0, 2);
		card_08_02.actionCard(false, false, false, true, false, false, false, false);
		card_08_02.setScaleRoll(1, 7, 0, 0);
		card_08_02.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: nhận 1 xúc sắc Bạc";
		cardList.add(card_08_02); //25
		
		DiceCard card_08_03 = new DiceCard();
		card_08_03.setCardImage(image_08_Small, image_08_Big);
		card_08_03.setCardID(8);
		card_08_03.setCardCondition(0, 2);
		card_08_03.actionCard(false, false, false, true, false, false, false, false);
		card_08_03.setScaleRoll(1, 7, 0, 0);
		card_08_03.cardTxt = "req: max 5, min 0\r\n"
				+ "todo: nhận 1 xúc sắc Bạc";
		cardList.add(card_08_03);//26
		
		//DiceCard id: 09: Cau nguyen
		ImageIcon image_09_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-9.png"));
		ImageIcon image_09_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-9.png"));
		
		DiceCard card_09_01 = new DiceCard();
		card_09_01.setCardImage(image_09_Small, image_09_Big);
		card_09_01.setCardID(9);
		card_09_01.setEOCondition(2);
		card_09_01.setCardCondition(0, 4);
		card_09_01.actionCard(false, false, false, false, false, true, false, false);
		card_09_01.setScaleHeal(2, 0);
		card_09_01.cardTxt = "req: số chấm trên xúc sắc chẵn min 0 max 3\r\n"
				+ "todo: Hồi (số chấm trên xúc sắc)*2 (máu) cho bản thân";
		cardList.add(card_09_01); 
		
		DiceCard card_09_02 = new DiceCard();
		card_09_02.setCardImage(image_09_Small, image_09_Big);
		card_09_02.setCardID(9);
		card_09_02.setEOCondition(2);
		card_09_02.setCardCondition(0, 4);
		card_09_02.actionCard(false, false, false, false, false, true, false, false);
		card_09_02.setScaleHeal(2, 0);
		card_09_02.cardTxt = "req: số chấm trên xúc sắc chẵn min 0 max 3\r\n"
				+ "todo: Hồi (số chấm trên xúc sắc)*2 (máu) cho bản thân";
		cardList.add(card_09_02); 
		
		DiceCard card_09_03 = new DiceCard();
		card_09_03.setCardImage(image_09_Small, image_09_Big);
		card_09_03.setCardID(9);
		card_09_03.setEOCondition(2);
		card_09_03.setCardCondition(0, 4);
		card_09_03.actionCard(false, false, false, false, false, true, false, false);
		card_09_03.setScaleHeal(2, 0);
		card_09_03.cardTxt = "req: số chấm trên xúc sắc chẵn min 0 max 3\r\n"
				+ "todo: Hồi (số chấm trên xúc sắc)*2 (máu) cho bản thân";
		cardList.add(card_09_03);
				
		//DiceCard id: 10 Kiem quy
		ImageIcon image_10_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-10.png"));
		ImageIcon image_10_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-10.png"));
	
		DiceCard card_10_01 = new DiceCard();
		card_10_01.setCardImage(image_10_Small, image_10_Big);
		card_10_01.setCardID(10);
		card_10_01.setEOCondition(1);
		card_10_01.setCardCondition(1, 5);
		card_10_01.actionCard(false, false, false, false, true, true, false, false);
		card_10_01.setScaleHeal(1, 0);
		card_10_01.cardTxt = "req: số chấm trên xúc sắc lẻ min 1 max 5\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ địch và hồi (số chấm trên xúc sắc) (máu) cho bản thân";
		cardList.add(card_10_01);
		
		DiceCard card_10_02 = new DiceCard();
		card_10_02.setCardImage(image_10_Small, image_10_Big);
		card_10_02.setCardID(10);
		card_10_02.setEOCondition(1);
		card_10_02.setCardCondition(1, 5);
		card_10_02.actionCard(false, false, false, false, true, true, false, false);
		card_10_02.setScaleHeal(1, 0);
		card_10_02.cardTxt = "req: số chấm trên xúc sắc lẻ min 1 max 5\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ địch và hồi (số chấm trên xúc sắc) (máu) cho bản thân";
		cardList.add(card_10_02);
		
		DiceCard card_10_03 = new DiceCard();
		card_10_03.setCardImage(image_10_Small, image_10_Big);
		card_10_03.setCardID(10);
		card_10_03.setEOCondition(1);
		card_10_03.setCardCondition(1, 5);
		card_10_03.actionCard(false, false, false, false, true, true, false, false);
		card_10_03.setScaleHeal(1, 0);
		card_10_03.cardTxt = "req: số chấm trên xúc sắc lẻ min 1 max 5\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ địch và hồi (số chấm trên xúc sắc) (máu) cho bản thân";
		cardList.add(card_10_03);
		
		//DiceCard: id:11 Nhanh tay le mat
		ImageIcon image_11_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-11.png"));
		ImageIcon image_11_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-11.png"));
		
		DiceCard card_11_01 = new DiceCard();
		card_11_01.setCardImage(image_11_Small, image_11_Big);
		card_11_01.setCardID(11);
		card_11_01.setCardCondition(0, 5);
		card_11_01.actionCard(false, false, false, true, false, false, false, false);
		card_11_01.setScaleRoll(2, -3, 0, 0);
		card_11_01.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: chia xúc sắc vừa sử dụng làm hai, nhận hai xúc sắc đó";
		cardList.add(card_11_01);
		
		DiceCard card_11_02 = new DiceCard();
		card_11_02.setCardImage(image_11_Small, image_11_Big);
		card_11_02.setCardID(11);
		card_11_02.setCardCondition(0, 5);
		card_11_02.actionCard(false, false, false, true, false, false, false, false);
		card_11_02.setScaleRoll(2, -3, 0, 0);
		card_11_02.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: chia xúc sắc vừa sử dụng làm hai, nhận hai xúc sắc đó";
		cardList.add(card_11_02);
		
		DiceCard card_11_03 = new DiceCard();
		card_11_03.setCardImage(image_11_Small, image_11_Big);
		card_11_03.setCardID(11);
		card_11_03.setCardCondition(0, 5);
		card_11_03.actionCard(false, false, false, true, false, false, false, false);
		card_11_03.setScaleRoll(2, -3, 0, 0);
		card_11_03.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: chia xúc sắc vừa sử dụng làm hai, nhận hai xúc sắc đó";
		cardList.add(card_11_03);
		
		//CounterCard id: 12 Tich dien
		ImageIcon image_12_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-12.png"));
		ImageIcon image_12_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-12.png"));
		
		CounterCard card_12_01 = new CounterCard();
		card_12_01.setCardImage(image_12_Small, image_12_Big);
		card_12_01.setCardID(12);
		card_12_01.setCounterRemain(12);
		card_12_01.actionCard(false, false, false, false, true, false, false, false);
		card_12_01.setScaleAttack(0, 10);
		card_12_01.setAmountAttack(0);
		card_12_01.cardTxt = "req: 12 counter\r\n"
				+ "todo: gây 10 sát thương lên kẻ địch";
		cardList.add(card_12_01); 
		
		CounterCard card_12_02 = new CounterCard();
		card_12_02.setCardImage(image_12_Small, image_12_Big);
		card_12_02.setCardID(12);
		card_12_02.setCounterRemain(12);
		card_12_02.actionCard(false, false, false, false, true, false, false, false);
		card_12_02.setScaleAttack(0, 10);
		card_12_02.setAmountAttack(0);
		card_12_02.cardTxt = "req: 12 counter\r\n"
				+ "todo: gây 10 sát thương lên kẻ địch";
		cardList.add(card_12_02);
		
		CounterCard card_12_03 = new CounterCard();
		card_12_03.setCardImage(image_12_Small, image_12_Big);
		card_12_03.setCardID(12);
		card_12_03.setCounterRemain(12);
		card_12_03.actionCard(false, false, false, false, true, false, false, false);
		card_12_03.setScaleAttack(0, 10);
		card_12_03.setAmountAttack(0);
		card_12_03.cardTxt = "req: 12 counter\r\n"
				+ "todo: gây 10 sát thương lên kẻ địch";
		cardList.add(card_12_03);
		
		//CounterCard id: 13 Dao ham
		ImageIcon image_13_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-13.png"));
		ImageIcon image_13_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-13.png"));
		
		CounterCard card_13_01 = new CounterCard();
		card_13_01.setCardImage(image_13_Small, image_13_Big);
		card_13_01.setCardID(13);
		card_13_01.setCounterRemain(10);
		card_13_01.actionCard(false, false, true, true, false, false, false, false);
		card_13_01.setScaleRoll(1, -1, 0, 0);
		card_13_01.setScaleDraw(0, 3);
		card_13_01.setAmountDraw(0);
		card_13_01.cardTxt = "req: 10 counter\r\n"
				+ "todo: rút 3 lá bài, nhận 1 xúc sắc";
		cardList.add(card_13_01);
		
		CounterCard card_13_02 = new CounterCard();
		card_13_02.setCardImage(image_13_Small, image_13_Big);
		card_13_02.setCardID(13);
		card_13_02.setCounterRemain(10);
		card_13_02.actionCard(false, false, true, true, false, false, false, false);
		card_13_02.setScaleRoll(1, -1, 0, 0);
		card_13_02.setScaleDraw(0, 3);
		card_13_02.setAmountDraw(0);
		card_13_02.cardTxt = "req: 10 counter\r\n"
				+ "todo: rút 3 lá bài, nhận 1 xúc sắc";
		cardList.add(card_13_02);
		
		CounterCard card_13_03 = new CounterCard();
		card_13_03.setCardImage(image_13_Small, image_13_Big);
		card_13_03.setCardID(13);
		card_13_03.setCounterRemain(10);
		card_13_03.actionCard(false, false, true, true, false, false, false, false);
		card_13_03.setScaleRoll(1, -1, 0, 0);
		card_13_03.setScaleDraw(0, 3);
		card_13_03.setAmountDraw(0);
		card_13_03.cardTxt = "req: 10 counter\r\n"
				+ "todo: rút 3 lá bài, nhận 1 xúc sắc";
		cardList.add(card_13_03);
		
		//CounterCard id 14: May nhan ban
		ImageIcon image_14_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-14.png"));
		ImageIcon image_14_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-14.png"));
		
		DiceCard card_14_01 = new DiceCard();
		card_14_01.setCardImage(image_14_Small, image_14_Big);
		card_14_01.setCardID(14);
		card_14_01.setCardCondition(0, 3);
		card_14_01.actionCard(false, false, false, true, false, false, false, false);
		card_14_01.setScaleRoll(2, -2, 0, 0);
		card_14_01.cardTxt = "req: min 0 max 3\r\n"
				+ "todo: nhận 2 xúc sắc với số chấm bằng số chấm của xúc sắc đã sử dụng";
		cardList.add(card_14_01);
		
		DiceCard card_14_02 = new DiceCard();
		card_14_02.setCardImage(image_14_Small, image_14_Big);
		card_14_02.setCardID(14);
		card_14_02.setCardCondition(0, 3);
		card_14_02.actionCard(false, false, false, true, false, false, false, false);
		card_14_02.setScaleRoll(2, -2, 0, 0);
		card_14_02.cardTxt = "req: min 0 max 3\r\n"
				+ "todo: nhận 2 xúc sắc với số chấm bằng số chấm của xúc sắc đã sử dụng";
		cardList.add(card_14_02);
		
		DiceCard card_14_03 = new DiceCard();
		card_14_03.setCardImage(image_14_Small, image_14_Big);
		card_14_03.setCardID(14);
		card_14_03.setCardCondition(0, 3);
		card_14_03.actionCard(false, false, false, true, false, false, false, false);
		card_14_03.setScaleRoll(2, -2, 0, 0);
		card_14_03.cardTxt = "req: min 0 max 3\r\n"
				+ "todo: nhận 2 xúc sắc với số chấm bằng số chấm của xúc sắc đã sử dụng";
		cardList.add(card_14_03);
		
		//DiceCard id 15: Khien
		ImageIcon image_15_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-15.png"));
		ImageIcon image_15_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-15.png"));
		
		DiceCard card_15_01 = new DiceCard();
		card_15_01.setCardImage(image_15_Small, image_15_Big);
		card_15_01.setCardID(15);
		card_15_01.setCardCondition(0, 5);
		card_15_01.actionCard(false, false, false, false, false, false, true, false);
		card_15_01.setScaleShield(1, 0);
		card_15_01.cardTxt = "req min 0 max 5\r\n"
				+ "todo: nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_15_01);
		
		DiceCard card_15_02 = new DiceCard();
		card_15_02.setCardImage(image_15_Small, image_15_Big);
		card_15_02.setCardID(15);
		card_15_02.setCardCondition(0, 5);
		card_15_02.actionCard(false, false, false, false, false, false, true, false);
		card_15_02.setScaleShield(1, 0);
		card_15_02.cardTxt = "req min 0 max 5\r\n"
				+ "todo: nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_15_02);
		
		DiceCard card_15_03 = new DiceCard();
		card_15_03.setCardImage(image_15_Small, image_15_Big);
		card_15_03.setCardID(15);
		card_15_03.setCardCondition(0, 5);
		card_15_03.actionCard(false, false, false, false, false, false, true, false);
		card_15_03.setScaleShield(1, 0);
		card_15_03.cardTxt = "req min 0 max 5\r\n"
				+ "todo: nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_15_03);
		
		//DiceCard id 16: Lay kiem lam khien
		ImageIcon image_16_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-16.png"));
		ImageIcon image_16_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-16.png"));
				
		DiceCard card_16_01 = new DiceCard();
		card_16_01.setCardImage(image_16_Small, image_16_Big);
		card_16_01.setCardID(16);
		card_16_01.setCardCondition(0, 5);
		card_16_01.actionCard(false, false, false, false, true, false, true, false);
		card_16_01.setScaleAttack(-1, 5);
		card_16_01.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ địch và nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_16_01);
		
		DiceCard card_16_02 = new DiceCard();
		card_16_02.setCardImage(image_16_Small, image_16_Big);
		card_16_02.setCardID(16);
		card_16_02.setCardCondition(0, 5);
		card_16_02.actionCard(false, false, false, false, true, false, true, false);
		card_16_02.setScaleAttack(-1, 5);
		card_16_02.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ địch và nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_16_02);
		
		DiceCard card_16_03 = new DiceCard();
		card_16_03.setCardImage(image_16_Small, image_16_Big);
		card_16_03.setCardID(16);
		card_16_03.setCardCondition(0, 5);
		card_16_03.actionCard(false, false, false, false, true, false, true, false);
		card_16_03.setScaleAttack(-1, 5);
		card_16_03.cardTxt = "req: min 0 max 5\r\n"
				+ "todo: gây (5 - số chấm trên xúc sắc) (sát thương) lên kẻ địch và nhận (số chấm trên xúc sắc) (khiên)";
		cardList.add(card_16_03);
		
		//CounterCard id: 17 Tiep te
		ImageIcon image_17_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-17.png"));
		ImageIcon image_17_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-17.png"));
				
		CounterCard card_17_01 = new CounterCard();
		card_17_01.setCardImage(image_17_Small, image_17_Big);
		card_17_01.setCardID(17);
		card_17_01.setCounterRemain(9);
		card_17_01.actionCard(false, false, false, true, false, true, false, false);
		card_17_01.setScaleRoll(2, -1, 0, 0);
		card_17_01.setScaleHeal(0, 6);
		card_17_01.setAmountHeal(0);
		card_17_01.cardTxt = "req: 9 counter\r\n"
				+ "todo: nhận 2 xúc sắc và hồi lại 6 máu";
		cardList.add(card_17_01);
		
		CounterCard card_17_02 = new CounterCard();
		card_17_02.setCardImage(image_17_Small, image_17_Big);
		card_17_02.setCardID(17);
		card_17_02.setCounterRemain(9);
		card_17_02.actionCard(false, false, false, true, false, true, false, false);
		card_17_02.setScaleRoll(2, -1, 0, 0);
		card_17_02.setScaleHeal(0, 6);
		card_17_02.setAmountHeal(0);
		card_17_02.cardTxt = "req: 9 counter\r\n"
				+ "todo: nhận 2 xúc sắc và hồi lại 6 máu";
		cardList.add(card_17_02);
		
		CounterCard card_17_03 = new CounterCard();
		card_17_03.setCardImage(image_17_Small, image_17_Big);
		card_17_03.setCardID(17);
		card_17_03.setCounterRemain(9);
		card_17_03.actionCard(false, false, false, true, false, true, false, false);
		card_17_03.setScaleRoll(2, -1, 0, 0);
		card_17_03.setScaleHeal(0, 6);
		card_17_03.setAmountHeal(0);
		card_17_03.cardTxt = "req: 9 counter\r\n"
				+ "todo: nhận 2 xúc sắc và hồi lại 6 máu";
		cardList.add(card_17_03);
		
		//CounterCard id: 18 Bung no vu tru
		ImageIcon image_18_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-18.png"));
		ImageIcon image_18_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-18.png"));
		
		CounterCard card_18_01 = new CounterCard();
		card_18_01.setCardImage(image_18_Small, image_18_Big);
		card_18_01.setCardID(18);
		card_18_01.setCounterRemain(25);
		card_18_01.actionCard(false, false, false, false, true, false, false, false);
		card_18_01.setScaleAttack(0, 20);
		card_18_01.setAmountAttack(0);
		card_18_01.cardTxt = "req: 25 counter\r\n"
				+ "todo: gây 20 sát thương lên kẻ địch";
		cardList.add(card_18_01);
		
		CounterCard card_18_02 = new CounterCard();
		card_18_02.setCardImage(image_18_Small, image_18_Big);
		card_18_02.setCardID(18);
		card_18_02.setCounterRemain(25);
		card_18_02.actionCard(false, false, false, false, true, false, false, false);
		card_18_02.setScaleAttack(0, 20);
		card_18_02.setAmountAttack(0);
		card_18_02.cardTxt = "req: 25 counter\r\n"
				+ "todo: gây 20 sát thương lên kẻ địch";
		cardList.add(card_18_02);
		
		CounterCard card_18_03 = new CounterCard();
		card_18_03.setCardImage(image_18_Small, image_18_Big);
		card_18_03.setCardID(18);
		card_18_03.setCounterRemain(25);
		card_18_03.actionCard(false, false, false, false, true, false, false, false);
		card_18_03.setScaleAttack(0, 20);
		card_18_03.setAmountAttack(0);
		card_18_03.cardTxt = "req: 25 counter\r\n"
				+ "todo: gây 20 sát thương lên kẻ địch";
		cardList.add(card_18_03);
		
		//CounterCard id: 19 Rut sung
		ImageIcon image_19_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-19.png"));
		ImageIcon image_19_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-19.png"));
						
		DiceCard card_19_01 = new DiceCard();
		card_19_01.setCardImage(image_19_Small, image_19_Big);
		card_19_01.setCardID(19);
		card_19_01.setCardCondition(0, 2);
		card_19_01.actionCard(false, false, false, true, true, false, false, false);
		card_19_01.setScaleAttack(1, 0);
		card_19_01.setScaleRoll(1, -1, 0, 0);
		card_19_01.cardTxt = "req: min 0 max 2\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ thù và nhận 1 xúc sắc bất kì";
		cardList.add(card_19_01);
		
		DiceCard card_19_02 = new DiceCard();
		card_19_02.setCardImage(image_19_Small, image_19_Big);
		card_19_02.setCardID(19);
		card_19_02.setCardCondition(0, 2);
		card_19_02.actionCard(false, false, false, true, true, false, false, false);
		card_19_02.setScaleAttack(1, 0);
		card_19_02.setScaleRoll(1, -1, 0, 0);
		card_19_02.cardTxt = "req: min 0 max 2\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ thù và nhận 1 xúc sắc bất kì";
		cardList.add(card_19_02);
		
		DiceCard card_19_03 = new DiceCard();
		card_19_03.setCardImage(image_19_Small, image_19_Big);
		card_19_03.setCardID(19);
		card_19_03.setCardCondition(0, 2);
		card_19_03.actionCard(false, false, false, true, true, false, false, false);
		card_19_03.setScaleAttack(1, 0);
		card_19_03.setScaleRoll(1, -1, 0, 0);
		card_19_03.cardTxt = "req: min 0 max 2\r\n"
				+ "todo: gây (số chấm trên xúc sắc) (sát thương) lên kẻ thù và nhận 1 xúc sắc bất kì";
		cardList.add(card_19_03);
		
		//CounterCard id: 20 Troi sap
		ImageIcon image_20_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-20.png"));
		ImageIcon image_20_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-20.png"));
								
		CounterCard card_20_01 = new CounterCard();
		card_20_01.setCardImage(image_20_Small, image_20_Big);
		card_20_01.setCardID(20);
		card_20_01.setCounterRemain(30);
		card_20_01.actionCard(false, false, false, false, true, false, false, false);
		card_20_01.setScaleAttack(0, 25);
		card_20_01.setAmountAttack(0);
		card_20_01.cardTxt = "req: 30 counter \r\n"
				+ "todo: gây 25 sát thương lên kẻ địch";
		cardList.add(card_20_01);
		
		CounterCard card_20_02 = new CounterCard();
		card_20_02.setCardImage(image_20_Small, image_20_Big);
		card_20_02.setCardID(20);
		card_20_02.setCounterRemain(30);
		card_20_02.actionCard(false, false, false, false, true, false, false, false);
		card_20_02.setScaleAttack(0, 25);
		card_20_02.setAmountAttack(0);
		card_20_02.cardTxt = "req: 30 counter \r\n"
				+ "todo: gây 25 sát thương lên kẻ địch";
		cardList.add(card_20_02);
		
		CounterCard card_20_03 = new CounterCard();
		card_20_03.setCardImage(image_20_Small, image_20_Big);
		card_20_03.setCardID(20);
		card_20_03.setCounterRemain(30);
		card_20_03.actionCard(false, false, false, false, true, false, false, false);
		card_20_03.setScaleAttack(0, 25);
		card_20_03.setAmountAttack(0);
		card_20_03.cardTxt = "req: 30 counter \r\n"
				+ "todo: gây 25 sát thương lên kẻ địch";
		cardList.add(card_20_03);
		
		//CounterCard id 21: Ban sach bang dan
		ImageIcon image_21_Small = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/small-21.png"));
		ImageIcon image_21_Big = new ImageIcon(CardLibrary.class.getResource("/sprite/Card/big-21.png"));
		
		CounterCard card_21_01 = new CounterCard();
		card_21_01.setCardImage(image_21_Small, image_21_Big);
		card_21_01.setCardID(21);
		card_21_01.setCounterRemain(6);
		card_21_01.actionCard(false, false, false, false, true, false, false, false);
		card_21_01.setScaleAttack(0, 0);
		card_21_01.setAmountAttack(0);
		card_21_01.isUseDiceInTurn = true;
		card_21_01.cardTxt = "req: 6 counter\r\n"
				+ "todo: gây (số xúc sắc đã sử dụng trong lượt) (sát thương) lên kẻ địch";
		cardList.add(card_21_01);
		
		CounterCard card_21_02 = new CounterCard();
		card_21_02.setCardImage(image_21_Small, image_21_Big);
		card_21_02.setCardID(21);
		card_21_02.setCounterRemain(6);
		card_21_02.actionCard(false, false, false, false, true, false, false, false);
		card_21_02.setScaleAttack(0, 0);
		card_21_02.setAmountAttack(0);
		card_21_02.isUseDiceInTurn = true;
		card_21_02.cardTxt = "req: 6 counter\r\n"
				+ "todo: gây (số xúc sắc đã sử dụng trong lượt) (sát thương) lên kẻ địch";
		cardList.add(card_21_02);
		
		CounterCard card_21_03 = new CounterCard();
		card_21_03.setCardImage(image_21_Small, image_21_Big);
		card_21_03.setCardID(21);
		card_21_03.setCounterRemain(6);
		card_21_03.actionCard(false, false, false, false, true, false, false, false);
		card_21_03.setScaleAttack(0, 0);
		card_21_03.setAmountAttack(0);
		card_21_03.isUseDiceInTurn = true;
		card_21_03.cardTxt = "req: 6 counter\r\n"
				+ "todo: gây (số xúc sắc đã sử dụng trong lượt) (sát thương) lên kẻ địch";
		cardList.add(card_21_03);
	}
	
	
}
