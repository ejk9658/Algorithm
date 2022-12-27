package test;

public class Collection_심화과제 {

	public static void main(String[] args) {
		// 가위 바위 보 결과를 출력하는 예제
		System.out.println("Collection을 사용하기 이전");
		System.out.println(beforeCollection());
		System.out.println("------------------");
		System.out.println("Collection을 사용한 후");
		System.out.println(afterCollection());
	}
	
	public static String beforeCollection() {
		int a = (int) (Math.random() * 3);	// 0: 가위, 1: 바위, 2: 보
		int b = (int) (Math.random() * 3);
		String A = make(a);
		String B = make(b);
		String result = "";
		if(a==0) {
			if(b==0) result = "A와 B는 비겼습니다.";
			else if(b==1) result = "B가 이겼습니다.";
			else if(b==2) result = "A가 이겼습니다.";
		} else if(a==1) {
			if(b==0) result = "A가 이겼습니다.";
			else if(b==1) result = "A와 B는 비겼습니다.";
			else if(b==2) result = "B가 이겼습니다.";
		} else if(a==2) {
			if(b==0) result = "B가 이겼습니다.";
			else if(b==1) result = "A가 이겼습니다.";
			else if(b==2) result = "A와 B는 비겼습니다.";
		}
		return "A:"+A+", B:"+B+" => "+result;
	}
	static String make(int k) {
		switch(k) {
		case 0:
			return "가위";
		case 1:
			return "바위";
		case 2:
			return "보";
		}
		return null;
	}
	
	public static String afterCollection() {
		int a = (int) (Math.random() * 3);
		int b = (int) (Math.random() * 3);
		String card[] = {"가위", "바위", "보"};
		String result[] = {"A가 이겼습니다.","B가 이겼습니다.","A와 B는 비겼습니다.","A가 이겼습니다.","B가 이겼습니다."};
		return "A:"+card[a]+", B:"+card[b]+" => "+result[a-b+2];
	}

}