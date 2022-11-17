package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_2382_미생물격리 {

	static class Node implements Comparable<Node>{
		int row, col, count, dir;

		public Node(int row, int col, int count, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.count = count;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			return o.count-this.count;
		}
		
	}
	static int N, M, K, map[][], ans;
	static PriorityQueue<Node> pq;
	static int dd[][] = {{},{-1,0},{1,0},{0,-1},{0,1}};	// 1~4 : 상하좌우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>();
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				pq.add(new Node(a,b,c,d));
			} //read
			
			for (int i = 0; i < M; i++) {
				if(pq.isEmpty()) break;	// 예외 처리
				go();
			}
			
			count();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void go() {
		Queue<Node> tempQ = new LinkedList();
		map = new int[N][N];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nd = node.dir;
			int nr = node.row+dd[nd][0];
			int nc = node.col+dd[nd][1];
			int nk = node.count;
			
			// 가장자리의 약품이 칠해진 셀로 이동할 경우
			if(nr==0 || nr==N-1 || nc==0 || nc==N-1) {
				nk /= 2;
				
				// 방향 처리
				if(nr==0 || nc==0) nd++;
				else nd--;
			}
			
			if(map[nr][nc]>0) {	// 같은 공간에 미생물이 들어온 경우
				map[nr][nc] += nk;
				continue;
			} else {	// 같은 공간에 미생물이 없는 경우
				map[nr][nc] = nk;
			}
			
			// 미생물이 없는 경우 queue에 다시 넣지 않는다.
			if(nk==0) continue;
			tempQ.add(new Node(nr,nc,nk,nd));
		}
		
		// temp에 들어온 값을 다시 pq에 저장한다.
		while(!tempQ.isEmpty()) {
			Node tempN = tempQ.poll();
			int r = tempN.row;
			int c = tempN.col;
			pq.offer(new Node(r, c, map[r][c], tempN.dir));
		}
	}

	private static void count() {
		ans = 0;
		while(!pq.isEmpty()) {
			ans += pq.poll().count;
		}
	}
}
