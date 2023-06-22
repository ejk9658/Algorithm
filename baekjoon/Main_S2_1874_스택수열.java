package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S2_1874_스택수열 {

	static StringBuilder sb;
	static int N, map[];
	static LinkedList<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		} //read
		
		int mapIdx = 0;
		stack = new LinkedList<>();	// stack에 1부터 N까지 오름차순으로 저장
		for(int i=1; i<=N; i++) {
			if(map[mapIdx] < i) break;
			
			push(i);
			while(mapIdx < N && stack.size() > 0 && map[mapIdx] == stack.get(stack.size()-1)) {
				pop();
				mapIdx++;
			}
		}
		System.out.println(mapIdx == N?sb.toString():"NO");
	}
	static void push(int i) {
		stack.add(i);
		sb.append("+\n");
	}
	static void pop() {
		stack.remove(stack.size()-1);
		sb.append("-\n");
	}
}