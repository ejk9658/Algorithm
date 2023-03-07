package formula;

public class ExchangeStringToArray {

	public static void main(String[] args) {
		
		String s = "Hello World!";
		
		// 1. char[] 로 변환
		char[] ca = s.toCharArray();
		
		// 2. char[] 로 변환 (반복문, charAt 사용)
		char[] ca2 = new char[s.length()];
		for (int i = 0; i < ca2.length; i++) {
			ca2[i] = s.charAt(i);
		}
		
		// 3. string[] 로 변환
		String[] sa = s.split("");
		
		// 4. 번외) char[] -> String 로 변환
		String ss = new String(ca);
		System.out.print(ss);
	}
}
