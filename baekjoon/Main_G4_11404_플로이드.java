package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G4_11404_플로이드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		} // 최단 경로 배열 초기화
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], cost);
		} // 입력 받은 최단 경로 저장하기
		
		// 플로이드-워셜 알고리즘 3중 for문 사용
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sb.append(map[i][j] == Integer.MAX_VALUE?0:map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
