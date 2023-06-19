package baekjoon;

import java.util.Scanner;

public class Main_10991_별찍기16 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++)
				System.out.print(" ");
			System.out.print("*");
			for(int k=0; k<i; k++)
				System.out.print(" *");
			System.out.println();
		}
	}
}
