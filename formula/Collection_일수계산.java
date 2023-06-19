package formula;

public class Collection_일수계산 {

	public static void main(String[] args) {
		
		System.out.println("Collection을 사용하기 이전 코드 결과 : "+beforeCollection());
		System.out.println("사용 후 더 간결해진 코드 결과 : "+afterCollection());
	}
	
	public static String beforeCollection() {
		int year = 1900 + (int) (Math.random() * 123);	// 1900년 ~ 2022년 
		int month = 1 + (int) (Math.random() * 12);	// 1월 ~ 12월 
		int day = -1;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			case 2:
				if(year%4==0 && year%100!=0 || year%400==0)
					day = 29;
				else day = 28;
				break;
		}
		return year+"년 "+month+"월은 "+day+"일까지 있습니다.";
	}
	public static String afterCollection() {
		int year = 1900 + (int) (Math.random() * 123);	// 1900년 ~ 2022년 
		int month = 1 + (int) (Math.random() * 12);	// 1월 ~ 12월 
		int[] days = {-1,31,28,31,30,31,30,31,31,30,31,30,31};
		if(month==2 && (year%4==0 && year%100!=0 || year%400==0)) days[2]=29;
		return year+"년 "+month+"월은 "+days[month]+"일까지 있습니다.";
	}

}