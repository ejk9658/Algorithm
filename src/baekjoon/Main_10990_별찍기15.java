package baekjoon;

import java.util.Scanner;

public class Main_10990_별찍기15 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++)
				System.out.print(" ");
			System.out.print("*");
			for(int k=0; k<2*i-1; k++)
				System.out.print(" ");
			if(i==0) System.out.println();
			else System.out.println("*");
		}
	}
}
