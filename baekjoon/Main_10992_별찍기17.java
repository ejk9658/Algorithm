package baekjoon;

import java.util.Scanner;

public class Main_10992_별찍기17 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++)
				System.out.print(" ");
			System.out.print("*");
			if(i==0) {
				System.out.println();
				continue;
			}
			else if(i==N-1)
				for(int j=0; j<2*N-2; j++)
					System.out.print("*");
			else {
				for(int j=0; j<2*i-1; j++)
					System.out.print(" ");
				System.out.println("*");
			}
		}
	}
}
