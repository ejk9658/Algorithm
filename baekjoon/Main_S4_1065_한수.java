package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S4_1065_한수 {

	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N<100) System.out.println(N);
		else {
			int ans = 99;
			for (int num = 111; num <= N; num++) {
				int a = num/100;	// 백의 자리 수
				int b = num/10%10;	// 십의 자리 수
				int c = num%10;	// 일의 자리 수
				
				int d = a-b;
				if(b-c==d) ans++;
			}
			System.out.println(ans);
		}
	}
}
