package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G4_11657_타임머신 {
	
	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static long dist[];
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e, c});	// (도착지, 가중치)
		} //read
		
		makeMap();	// 최단 경로 배열 생성
		go();	// 최단 경로 알고리즘 - 벨만 포드 사용
		// 음의 사이클이 있는지 확인하기 
		if(checkMinusCycle()) System.out.println(-1);
		else print();
	}
	static void makeMap() {
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
	}
	static void go() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		
		for(int i=0; i<N-1; i++) {	// 최단 경로 에지 개수는 최대 N-1개이므로 N-1번 수행한다.
			int n = que.size();
			for(int j=0; j<n; j++) {
				int start = que.poll();
				int nn = list[start].size();
				for(int k=0; k<nn;k++) {
					int end = list[start].get(k)[0];
					int cost = list[start].get(k)[1];
					if(dist[end] > dist[start]+cost) {	// 갱신해야함
						dist[end] = dist[start]+cost;
						que.offer(end);	// 다음에 체크할 start 번호를 큐에 넣음
					}
				}
			}
		}
	}
	static boolean checkMinusCycle() {
		for(int start=1; start<=N; start++) {
			int n = list[start].size();
			for(int i=0; i<n; i++) {
				int end = list[start].get(i)[0];
				int cost = list[start].get(i)[1];
				if(dist[end]!=INF && dist[end] > dist[start]+cost) return true;	// 음의 사이클 발생 
			}
		}
		return false;
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(dist[i]==INF?-1:dist[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
