package test;

public class GCD_LCM_최대공약수_최소공배수2 {
	
	public static void main(String[] args) {
		
		int a = 12;
		int b = 90;
		
		int gcd = gcd(a, b);
		System.out.println("최대공약수 : "+gcd);
		
		int lcm = a*b/gcd;
		System.out.println("최소공배수 : "+lcm);
	}

	private static int gcd(int n, int m) {
		if(n%m==0)
        	return m;
		return gcd(m, n%m);
	}
}