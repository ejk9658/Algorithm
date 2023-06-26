package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S1_2178_미로탐색 {
	
	static int N, M, map[][];
	static int dd[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		} //read
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			int r = arr[0];
			int c = arr[1];
			for(int d=0; d<4; d++) {
				int nr = r+dd[d][0];
				int nc = c+dd[d][1];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(map[nr][nc]==1) {
					que.offer(new int[] {nr,nc});
					map[nr][nc] = map[r][c]+1;
					if(nr==N-1 && nc==M-1) return;
				}
			}
		}
	}
}