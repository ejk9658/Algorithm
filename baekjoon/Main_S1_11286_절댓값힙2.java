package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S1_11286_절댓값힙2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			return a==b?o1-o2:a-b;
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				pq.offer(num);
			} else {
				sb.append(pq.isEmpty()?"0":pq.poll()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}