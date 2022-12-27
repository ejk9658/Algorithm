package test;

public class Collection_기본과제 {

	public static void main(String[] args) {

		int year = 1900 + (int) (Math.random() * 123);	// 1900년 ~ 2022년 
		int month = 1 + (int) (Math.random() * 12);	// 1월 ~ 12월 
		int[] days = {-1,31,28,31,30,31,30,31,31,30,31,30,31};
		if(month==2 && (year%4==0 && year%100!=0 || year%400==0)) days[2]=29;
		System.out.println(year+"년 "+month+"월은 "+days[month]+"일까지 있습니다.");
		
	}

}