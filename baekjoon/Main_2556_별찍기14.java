package baekjoon;

import java.util.Scanner;

public class Main_2556_별찍기14 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
