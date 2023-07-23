package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G4_4485_녹색옷입은애가젤다지 {
	
	static int N, map[][], dist[][];
	static boolean visited[][];
	static StringBuilder sb;
	static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static class Node implements Comparable<Node>{
		int row, col, dis;
		Node(int row, int col, int dis) {
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			} //read
			
			sb.append("Problem "+(tc++)+": "+dijk()+"\n");
		}
		
		System.out.println(sb.toString());
	}
	static int dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		visited[0][0] = true;
		pq.offer(new Node(0,0,dist[0][0]));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for(int d=0; d<4; d++) {
				int nr = node.row + dd[d][0];
				int nc = node.col + dd[d][1];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(visited[nr][nc]) continue; // pq 때문에 최단 dist 순으로 방문하기 때문에 방문하지 않은 노드만 체크해도 된다
				visited[nr][nc] = true;
				dist[nr][nc] = Math.min(dist[node.row][node.col] + map[nr][nc], dist[nr][nc]);
				pq.offer(new Node(nr,nc,dist[nr][nc]));
			}
		}
		return dist[N-1][N-1];
	}
}
