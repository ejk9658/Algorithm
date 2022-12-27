package test;

public class Collection_실습 {

	public static void main(String[] args) {
		
		System.out.println("Collection을 사용하기 이전 코드 결과 : "+beforeCollection());
		System.out.println("사용 후 더 간결해진 코드 결과 : "+afterCollection());
	}
	
	public static String beforeCollection() {
		int random = (int) (Math.random() * 100);
		int i = random % 4;
		switch(i) {
			case 0:
				return "Mango";
			case 1:
				return "Apple";
			case 2:
				return "Orange";
			case 3:
				return "Banana";
			default:
				return null;
		}
	}
	
	public static String afterCollection() {
		String fruits[] = {"Mango", "Apple", "Orange", "Banana"};
		int random = (int) (Math.random() * 100);
		int i = random % fruits.length;
		return fruits[i];
	}

}