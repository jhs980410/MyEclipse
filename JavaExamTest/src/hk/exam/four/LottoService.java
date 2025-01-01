package hk.exam.four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class LottoService {
	// 인스턴스의 변수는 배열 or 컬렉션 클래스 둘 중 하나만 이용 
	
	// 45개의 정수값을 저장하기 위한 배열 생성.
	private int[] balls = new int[45];
	private int[] luckyBall = new int[6];

	private ArrayList<Integer> ballList = new ArrayList<>();
	private ArrayList<Integer> luckyBallList = new ArrayList<>();
	
	// 1~45까지의 공 준비
	public void setLottoNumber() {

		for (int i = 1; i <= 45; i++) {
			this.ballList.add(i);	
		}

	}
	
	// 45개의 로또 번호 중 중복되지 않는 나만의 숫자 6개를 선택
	public void setAutoLottoNumber(){
		Random random = new Random(); //랜덤 메서드 사용
		
		while (luckyBallList.size() < 6) {
			int myLuckyBall = random.nextInt(45)+1; // 0~44 까지인 난수생성, +1//
			if (!luckyBallList.contains(myLuckyBall)) {
				luckyBallList.add(myLuckyBall); // luckyBallList에 myLuckyBalllist가 포함되어있지 않다면 추가 
			}
		}
		
		
	}


	/**
	 * 
	 * @param sequence
	 *            true이면 오름차순, false이면 내림차순 정렬
	 * 
	 *            <pre>
	 * 로또 번호 정렬
	 *            </pre>
	 */
	public void sortLottoNumber(boolean sequence) {
		

		if (sequence) { // 오름차순 정렬
	        System.out.println("오름차순");					//Comparator: 두 객체를 비교하여 정렬 기준을 정의한 인터페이스
	        luckyBallList.sort(Comparator.naturalOrder());   // ArrayList.sort()는 Comparator가 필수라고한다. 
	        
	    } else { // 내림차순 정렬
	        System.out.println("내림차순");
	        luckyBallList.sort(Comparator.reverseOrder());
	        
	    }
				
				
		
	}

	// 6개의 공의 숫자를 출력
	public void printLottoNumber() {
		System.out.println(luckyBallList);
	}
	

}
