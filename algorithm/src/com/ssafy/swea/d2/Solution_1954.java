package com.ssafy.swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954 {
	static int T, N, r, c, d, nr, nc;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			r= 0;
			c = -1;
			d = 0;
			for (int i = 1; i <= N*N; i++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if(!check(N, nr, nc) || map[nr][nc]!=0) {
					d = (d+1)%4;
				}
				r+=dr[d];
				c+=dc[d];
				map[r][c] = i;
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
	
	public static boolean check(int N, int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 || nc>=N)
			return false;
		return true;
	}

}
