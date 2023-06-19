package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {

	static int T, N, M;
	static int[][] map;
	static int sum, max_sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++)
					map[i][j] = Integer.parseInt(st.nextToken()) +
					map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			} // 입력 끝
			
			max_sum = 0;
			for(int i=M; i<=N; i++)
				for(int j=M; j<=N; j++) {
					sum = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					max_sum = Math.max(max_sum, sum);
				}
			
			System.out.println("#"+tc+" "+max_sum);
		}
	}

}
