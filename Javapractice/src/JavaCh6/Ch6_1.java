package JavaCh6;

import java.util.Scanner;

public class Ch6_1 {

	public static void main(String[] args) {
		//다음과같은멤버변수를갖는클래스를정의하시오
		int num = (int)(Math.random()*10)+1;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//1.번
		boolean iskwang = (str.equals("광") ? true:false);
		//2번
		boolean iskwang2 = str.equals("광");
		
	}

}
