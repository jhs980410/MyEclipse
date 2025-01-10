package hk.exam.seven;

import java.util.ArrayList;
import java.util.List;

public class CardCase {

	// 52장의 카드를 담는 참조변수
	private List<Card> cardList = null;

	public CardCase() {
		cardList = new ArrayList();
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	// 카드덱에 52장의 카드들을 셋팅함

	public void init() {
		cardList.clear(); // 카드리스트 비움,
		for (String shape : Card.shape) { // 모양 순회 
			for (String number : Card.number) { // 숫자 순회 
				cardList.add(new Card(shape, number)); // 카드 객체 생성 및 리스트에 추가
			}
		}
	}
	// 전체 for문 종료

	// 카드덱의 순서와 모양을 출력
	public void cardCasePrint() {
		for (int i = 0; i < cardList.size(); i++) {
			System.out.print(cardList.get(i).getCard() + "\t");
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
	}
	

}
