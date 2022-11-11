package baekjoon02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역 {

	static int N, map[][], copyMap[][], maxSafe;
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copyMap = new int[N][N];
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				low = Math.min(low, map[i][j]);
				high = Math.max(high, map[i][j]);
			}
		} //read
		
		// 높이(i)만큼 왔을 때 잠긴 영역 구하기
		for(int i=low-1; i<=high; i++) {
			find(i);
		}
		
		System.out.println(maxSafe);
	}


	private static void find(int height) {
		visited = new boolean[N][N];
		
		// 깊은 복사로 map 복사 -> copyMap		
		for(int i=0; i<N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], N);
		}
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(copyMap[i][j]<=height)
					copyMap[i][j] = -1;	// 특정 높이 이하일 때 map에 -1로 표시
		
		// 안전영역 최대 개수 구하기
		int safe = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(copyMap[i][j] != -1 && !visited[i][j]) {	// 잠긴 지역이 아닌 경우
					bfs(i,j);
					safe++;
				}
		
		
		maxSafe = Math.max(safe, maxSafe);
	}
	
	private static void bfs(int row, int col) {
		Queue<int []> que = new LinkedList<>();
		que.offer(new int[] {row,col});
		visited[row][col] = true;
		while(!que.isEmpty()) {
			int[] cur =que.poll();
			for(int d = 0; d<4; d++) {
				int nr = cur[0]+dd[d][0];
				int nc = cur[1]+dd[d][1];
				if(!check(nr,nc)) continue;
				if(copyMap[nr][nc]<1) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				que.offer(new int[] {nr,nc});
			}
		}
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
