package JavaCh6;



	public class SutdaCardCh6_1 {
	    int num;
	    boolean isKwang;  
	    //num과 iskwang; 을 선언 // 

	    // 생성자: 매개변수 있는 생성자
	    SutdaCardCh6_1(int num, boolean isKwang) {
	        this.num = num;
	        this.isKwang = isKwang;
	        //메인클래스에서 호출할때 , 값 입력시  this.로 인해서 , 입력값이 변수로 저장 //  
	    }

	    // 생성자: 기본값 설정
	    public SutdaCardCh6_1() {
	        this.num = 3;
	        this.isKwang = true;
	        //입력값 없이 기본생성시 num은 3이 되어버림  
	    }

	    // info 메서드: 카드 정보 반환
	    String info() {
	        return isKwang ? num + "K" : String.valueOf(num);
	        // info는 좀더 공부필요 // 
	    }
		
	}


