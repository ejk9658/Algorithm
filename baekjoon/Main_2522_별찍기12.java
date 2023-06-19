package baekjoon;

import java.util.Scanner;

public class Main_2522_별찍기12 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<2*N-1; i++) {
			int j = Math.abs(N-i-1);
			for(int k=0; k<j; k++)
				System.out.print(" ");
			for(int k=0; k<N-j; k++)
				System.out.print("*");
			System.out.println();
		}
	}
}
