package NYPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_페인트칠하기 {

	static int N, M, map[][];
	static int[][] dd = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
	static int total, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // read
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				kill(i,j);
				ans = Math.max(ans, total);
			}
		}

		System.out.println(ans);
	}

	private static void kill(int r, int c) {
		total = map[r][c];
		for(int d=0; d<8; d++) {	// 4방향과 대각선 따로 검사
			for(int i=1; i<=M; i++) {	// 물줄기만큼
				int nr = r+dd[d][0]*i;
				int nc = c+dd[d][1]*i;
				if(!check(nr,nc)) break;
				total += map[nr][nc];
				if(d==3 || d==7) {	// 최댓값 구하기 (4방향과 대각선 따로 검사)
					ans = Math.max(ans, total);
					total = map[r][c];
				}
			}
		}		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
