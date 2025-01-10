package hk.exam.seven;

import java.util.ArrayList;

public class ArenaRule {

	// 2장의 카드 합산 결과를 돌려준다
	public static int getCardToJumsu(Card[] cardArr) {
	    int scoreSum = 0; // 점수 합산 변수

	    for (Card card : cardArr) { // 카드 배열 순회
	        String number = card.getNumber(); // 각 카드의 숫자 값 가져오기
	        								//for (타입 변수 : 배열/컬렉션)
	        // 숫자에 따라 점수를 계산
	        switch (number) {
	            case "A":
	                scoreSum += 1;
	                break;
	            case "T":
	                scoreSum += 10;
	                break;
	            case "J":
	                scoreSum += 11;
	                break;
	            case "Q":
	                scoreSum += 12;
	                break;
	            case "K":
	                scoreSum += 13;
	                break;
	            default:
	                scoreSum += Integer.parseInt(number); // 숫자 카드 처리
	                break;
	        }
	    }

	    return scoreSum;
	}

	
	// 2사람의 카드 결과를 평가한다.
	/**
	 * 
	 * @param my
	 * @param you
	 * 점수가 높은 플레이어가 승리
	 */
	public static void setGamePlayAssess(Player my, Player you){
		if(my.getScore() > you.getScore()){
			my.setWinner(true);
			you.setWinner(false);
		}else{
			you.setWinner(true);
			my.setWinner(false);
		}
	}
	
	// 게임 결과 보여주기
	public static void gamePlayResultInfo(Player my, Player you){
		System.out.println("게임의 승자는! ");
		Card[] myCardArr = my.getMyChoiceCards();
		Card[] yourCardArr = you.getMyChoiceCards();
		
		StringBuffer mySb = new StringBuffer();
		StringBuffer yourSb = new StringBuffer();
		
		for (int i = 0; i < yourCardArr.length; i++) {
			mySb.append("<"+ (i+1) + "번째 카드> ");
			mySb.append(myCardArr[i].getCard() + " ");
			
			yourSb.append("<" + (i+1) + "번째 카드> ");
			yourSb.append(yourCardArr[i].getCard() + " ");
		}
				
		
		System.out.print(my.getName() + ": " + mySb.toString() + "= " + my.getScore() + " vs ");
		System.out.println(you.getName() + ": " + yourSb.toString() + "= " + you.getScore());
		
		if(my.isWinner()){
			System.out.println(my.getName() + "님 입니다.");
		}else{
			System.out.println(you.getName() + "님 입니다.");
		}
	}

}
