package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_S4_2164_queue_카드2 {

	static int N;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new ArrayDeque<>();
		int N = sc.nextInt();
		for(int i=1; i<=N; i++)
			q.offer(i);
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.peek());
	}

}
