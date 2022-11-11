package practice_ssafy;

import java.util.Scanner;

public class Solution_D2_2005_파스칼의삼각형 {

	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			map = new int[N+1][N+1];
			for(int i=1; i<=N; i++)
				for(int j=1; j<=i; j++)
					map[i][j] = pascal(i,j);
			System.out.println("#"+t);
			for(int i=1; i<=N; i++) {
				for (int j=1; j<=i; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	public static int pascal(int r, int c) {
		if (r>1 && c>1)
			return map[r-1][c-1] + map[r-1][c];
		else
			return 1;
	}
}
