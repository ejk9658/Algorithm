package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1707_이분그래프 {

	static int V, E, visited[];
	static ArrayList<ArrayList<Integer>> nodes;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			nodes = new ArrayList<>();
			for (int i = 0; i < V + 1; i++) {
				nodes.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodes.get(a).add(b);
				nodes.get(b).add(a);
			}

			visited = new int[V + 1];
			Arrays.fill(visited, -1);
			flag = false;
			
			for (int i = 1; i < V+1; i++) {
				if(visited[i]==-1) {
					visited[i] = 0;
					dfs(i);
				}
			}
			
			System.out.println(flag?"NO":"YES");
		}
	}
	
	private static void dfs(int start) {
		for (int v : nodes.get(start)) {
			if (visited[v] == visited[start]) {
				flag = true;
				return;
			}
			else if(visited[v] == -1) {
				visited[v] = visited[start]^1;
				dfs(v);
			}
		}
	}
}
