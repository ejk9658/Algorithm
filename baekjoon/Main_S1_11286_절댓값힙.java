package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S1_11286_절댓값힙 {

	static class Number implements Comparable<Number>{
		int num;
		Number(int num) {
			this.num = num;
		}
		@Override
		public int compareTo(Number o) {
			int a = Math.abs(this.num);
			int b = Math.abs(o.num);
			return a==b?this.num-o.num:a-b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Number> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				pq.offer(new Number(num));
			} else {
				sb.append(pq.isEmpty()?"0":pq.poll().num).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}