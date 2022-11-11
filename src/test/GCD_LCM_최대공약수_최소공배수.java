package test;

public class GCD_LCM_최대공약수_최소공배수 {
	
	public static void main(String[] args) {
		
		int a = 12;
		int b = 90;
		
		int gcd = gcd(a, b);
		System.out.println("최대공약수 : "+gcd);
		
		int lcm = a*b/gcd;
		System.out.println("최소공배수 : "+lcm);
	}

	private static int gcd(int n, int m) {
		if(n<m) {	// n이 m보다 항상 큰 수로 만든다. (n>m)
			int temp = m;
			m=n;
			n=temp;
		}
		
		if(m==0) return n;	// m이 0이면 n은 처음 들어온 두 정수의 최대공약수이다.
		
		return gcd(n%m, m);
	}
}
