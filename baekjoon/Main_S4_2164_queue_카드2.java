package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S4_2164_queue_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N; i++) que.offer(i);
		
		while(que.size() > 1) {
			que.poll();
			que.offer(que.poll());
		}
		System.out.println(que.peek());
	}
}