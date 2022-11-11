package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 디저트카페 {

	static int N, map[][], ans;
	static int dd[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static boolean visited[];	// 디저트 종류
	static Queue<int[]> que;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			ans = -1;
			
			// 시작점에서부터 시계방향으로 직사각형을 그릴 것이다.
			// map 배열의 인덱스는 0~(N-1) 내에서 최소한 벽에 부딪히지 않으려면,
			// 시작점의 열 번호는 1~(N-2) 범위에 있어야 하고
			// 시작점의 행 번호는 0~(N-3) 범위에 있어야 한다.
			for (int sr = 0; sr <= N-3; sr++) {
				for (int sc = 1; sc <= N-2; sc++) {
					go(sr,sc,0);	// 시작점(sr, sc) 좌표, 처음 시작 방향을 (0,1,2,3 중에서) 0으로 설정
				}
			}
		}
	}

	private static void go(int sr, int sc, int dir) {
		visited = new boolean [101];	// 초기화
		visited[map[sr][sc]] = true;
		que = new LinkedList<>();
		que.offer(new int[] {sr, sc, dir});
		
		while(!que.isEmpty()) {
			int node[] = que.poll();
			int r = node[0];
			int c = node[1];
			int d = node[2];
			
			// 1. 다음 노드를 검사한다.
			// 1-1. 방향이 그대로인 경우
			int nr = r+dd[d][0];
			int nc = c+dd[d][1];
			if(check1(nr,nc)) {	// map의 범위 밖을 벗어나지 않은 경우
				if(sr==nr && sc==nc) count()
				if(visited[map[nr][nc]]) continue;	// 이미 방문한 곳이라면 pass
				visited[map[nr][nc]] = true;
				que.offer(new int[] {nr, nc, d});
			}
			
			// 1-2. 방향을 바꾼 경우
			if(d==3) continue;	// 마지막 방향은 바꾸지 않는다. (마지막이니까)
			nr = r+dd[d+1][0];
			nc = c+dd[d+1][1];
			if(check1(nr,nc)) {	// map의 범위 밖을 벗어나지 않은 경우
				if(visited[map[nr][nc]]) continue;	// 이미 방문한 곳이라면 pass
				visited[map[nr][nc]] = true;
				que.offer(new int[] {nr, nc, d+1});
			}
		}
		
		
	}

	private static boolean check1(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}