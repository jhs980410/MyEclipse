import java.util.Iterator;

public class SayYes2 {
	public static void main(String[] args) {

		int[] numArr = new int[10];
		int[] countArr = new int[10];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) (Math.random() * 10);
		}
		System.out.println(numArr[0]);
		System.out.println(numArr[1]);
		System.out.println(numArr[2]);
		System.out.println(numArr[3]);
		System.out.println(numArr[4]);
		System.out.println(numArr[5]);
		System.out.println(numArr[6]);
		System.out.println(numArr[7]);
		System.out.println(numArr[8]);
		System.out.println(numArr[9]);

		System.out.println("===================================================");
		System.out.println("===================================================");
		System.out.println();

		for (int i = 0; i < countArr.length; i++) {
			for (int j = 0; j < countArr.length; j++) {
				if (numArr[j] == i) {
					countArr[i] += 1;
				}
				
			}
			
			System.out.println(i + " 는 " +  countArr[i] + " 개  출현 ");
		}
	
		
	
		}
	}



