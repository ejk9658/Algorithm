package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S2_11724_연결요소의개수 {
	
	static ArrayList<Integer>[] list;
	static boolean visited[];
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		} //read
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			answer++;
			dfs(i);
		}
		System.out.println(answer);
	}
	static void dfs(int idx) {
		int n = list[idx].size();
		for(int i=0; i<n; i++) {
			int temp = list[idx].get(i);
			if(visited[temp]) continue;
			visited[temp] = true;
			dfs(temp);
		}
	}
}