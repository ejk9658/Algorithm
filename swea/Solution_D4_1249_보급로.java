package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_D4_1249_보급로 {

	static int N, map[][], ans;
	static boolean visited[][];
	static int dd[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				char[] ch = s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j]-'0';
				}
			} // read
			
			visited = new boolean[N][N];
			bfs();
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs() {
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];	// 복구 작업시간 순 내림차순 정렬
			}
		});
		que.offer(new int[] {0,0,0});	// x좌표, y좌표, 복구작업시간
		visited[0][0] = true;
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			int x = arr[0];
			int y = arr[1];
			int time = arr[2];
			
			if(x==N-1 && y==N-1) {
				ans = time;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dd[i][0];
				int ny = y + dd[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny]) continue;
				visited[nx][ny] = true;
				que.offer(new int[] {nx, ny, time+map[nx][ny]});
			}
		}
		
	}

}
