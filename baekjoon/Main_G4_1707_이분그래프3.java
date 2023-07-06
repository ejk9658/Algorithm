package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G4_1707_이분그래프3 {

	static ArrayList<Integer>[] arrayList;
	static int team[];
	static boolean isNotBinary;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arrayList = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				arrayList[i] = new ArrayList<>(); // 인접리스트 초기화
			}
			team = new int[V+1];	// 0:에지가 없는 노드, 2:에지가 한 개 이상인 노드, -1:왼편, 1:오른편
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arrayList[s].add(e); // 인접리스트에 값 추가
				arrayList[e].add(s); // 인접리스트에 값 추가
				team[s] = 2;
				team[e] = 2;
			} //read
			
			binaryGraph(V);
			if(isNotBinary) sb.append("NO");
			else sb.append("YES");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	static void binaryGraph(int V) {
		isNotBinary = false;
		for(int i=1; i<=V; i++) {
			if(isNotBinary) return;
			if(team[i] != 2) continue;
			team[i] = -1; // 임의의 팀을 지정해줌
			dfs(i);
		}
	}
	static void dfs(int v) {
		int n = arrayList[v].size();
		for(int i=0; i<n; i++) {
			if(isNotBinary) return;
			int node = arrayList[v].get(i);
			if(team[node] == 2) {
				team[node] = team[v]*(-1);
				dfs(node);
			} else if(team[node] == team[v]) {
				isNotBinary = true;
			}
		}
	}
}
