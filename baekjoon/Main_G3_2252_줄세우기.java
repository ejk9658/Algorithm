package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G3_2252_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		int D[] = new int[N+1];	// 진입 차수 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			D[b]++;
		} //read
		
		// 진입 차수가 0인 노드를 큐에 삽입하기
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(D[i] == 0) que.offer(i);
		}
		
		// 큐가 빌 때까지
		while(!que.isEmpty()) {
			int node = que.poll();
			sb.append(node).append(" ");
			int n = list[node].size();
			for(int i=0; i<n; i++) {
				int nextNode = list[node].get(i);
				D[nextNode]--;	// 비순환참조이기 때문에 위상정렬이 가능하다
				if(D[nextNode] == 0) que.offer(nextNode);
			}
		}
		
		System.out.println(sb.toString());
	}
}
