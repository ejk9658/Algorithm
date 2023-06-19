package baekjoon;

import java.util.Scanner;

public class Main_2448_별찍기11 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2*N-1];
		star(0,0,N);
		
		StringBuilder sb = new StringBuilder();		// StringBuilder로 시간초과를 막아준다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++)
				sb.append(arr[i][j]==1?"*":" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void star(int r, int c, int N) {
		if(N==3) {
			for(int i=0; i<3; i++) {
				int j = 3-i-1;
				for(int k=0; k<2*i+1; k++) {
					if(i==1 && k==1)
						continue;
					arr[r+i][c+j+k] = 1;
				}
			}
		} else {
			star(r, c+N/2, N/2);
			star(r+N/2, c, N/2);
			star(r+N/2, c+N, N/2);
		}
	}
}
