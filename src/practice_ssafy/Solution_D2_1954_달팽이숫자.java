package practice_ssafy;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	static int N, nr, nc;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			int r= 0;
			int c = 0;
			int d = 0;
			for (int i = 1; i <= N*N; i++) {
				map[r][c] = i;
				nr = r+dr[d];
				nc = c+dc[d];
				if(!check(nr, nc) || map[nr][nc]!=0) {
					d = (d+1)%4;
				}
				r+=dr[d];
				c+=dc[d];
			}
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static boolean check(int rr, int cc) {
		return rr>=0 && rr<N && cc>=0 && cc<N;
	}

}
