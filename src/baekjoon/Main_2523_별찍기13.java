package baekjoon;

import java.util.Scanner;

public class Main_2523_별찍기13 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<2*N-1; i++) {
			for(int j=0; j<-Math.abs(i-N+1)+N; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
