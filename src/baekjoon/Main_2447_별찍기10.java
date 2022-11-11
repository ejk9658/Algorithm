package baekjoon;

import java.util.Scanner;

public class Main_2447_별찍기10 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		star(0,0,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(arr[i][j]==1?"*":" ");
			System.out.println();
		}
	}
	
	
	public static void star(int r, int c, int N) {
		if(N==3) {
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++) {
					if(i==1 && j==1)
						continue;
					arr[r+i][c+j] = 1;
				}
		} else {
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++) {
					if(i==1 && j==1)
						continue;
					star(r+N/3*i, c+N/3*j, N/3);
				}
		}
		

	}


}
