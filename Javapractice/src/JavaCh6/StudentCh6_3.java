package JavaCh6;

public class StudentCh6_3 {

	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	// 과목 변수선언 //
	int getTotal() {
		return kor + eng + math;
		//
	}

	float getAverage() {
		float average = (kor + eng + math) / 3.0f;
		return Math.round(average * 10) / 10.0f;
	}
	public StudentCh6_3() {
		
	}
	public StudentCh6_3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	String info() {
		return name +","+ ban+"," + no+"," + kor+"," + eng+"," + math+"," + getTotal() +"," + getAverage();
	}
	
}
