
public class StringEx1 {

	public static void main(String[] args) {
		
//		String originStr = "문자열 메서드를 활용haja하자";
//		int strIndex = 0;
//		strIndex = originStr.indexOf("h");
//		
//		System.out.println(originStr);
//		System.out.println(strIndex);  // indexOf
		
//		String originStr = "문자열 메서드를 활용haja하자";
//		String changeStr = "";
//		changeStr = originStr.substring(11,15).toUpperCase();
//		
//		System.out.println(originStr);
//		System.out.println(changeStr);   // substring 
		
		
//		String originStr = "문자열 메서드를 활용haja하자";
//		String firstStr = "";
//		String secondStr = "";
//		String thirdStr = "";
//		
//		String[] strArr = originStr.split(" ");
//		firstStr = strArr[0];
//		secondStr = strArr[1];
//		thirdStr = strArr[2];
//		System.out.println(originStr);
//		System.out.println(firstStr);
//		System.out.println(secondStr);
//		System.out.println(thirdStr.toUpperCase());   
	
		
//		String originStr = "문자열 메서드를 활용haja하자";
//		String changeStr = "";
//		String[] strArr = originStr.split(" ");
//		
//		changeStr = strArr[0].concat(" ")+strArr[1].concat(" (") + strArr[2].concat(")").toUpperCase();
//		System.out.println(originStr);
//		System.out.println(changeStr);
		
		
		String originStr = "자바를 자바라";
		String changeStr = "";
		
		changeStr = originStr.replace("자바", "db").replaceFirst("db", "자바");
		
		System.out.println(originStr);
		System.out.println(changeStr);
		
	}

}
