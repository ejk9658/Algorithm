package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G4_1707_이분그래프2 {

	static ArrayList<Integer>[] arrayList;
	static int team[];
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
			
			if(binaryGraph(V)) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	static boolean binaryGraph(int V) {
		for(int i=1; i<=V; i++) {
			if(team[i] != 2) continue;
			team[i] = -1; // 임의의 팀을 지정해줌
			int n = arrayList[i].size();
			Queue<Integer> que = new LinkedList<>();
			for(int j=0; j<n; j++) {
				int node = arrayList[i].get(j);
				if(team[node] == -1) return false;
				team[node] = 1; // 반대팀으로 지정해줌
				que.offer(node);
			}
			
			while(!que.isEmpty()) {
				int node = que.poll();
				int n2 = arrayList[node].size();
				for(int j=0; j<n2; j++) {
					int node2 = arrayList[node].get(j);
					if(team[node] == team[node2]) return false;
					if(team[node2] == 2) {
						team[node2] = team[node]*-1; // 반대팀으로 지정해줌
						que.offer(node2);
					}
				}
			}
		}
		return true;
	}
}
