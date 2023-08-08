package NYPC;

import java.util.*;
import java.io.*;

public class Main_더하기와곱하기 {

	static int K;
	static class Node {
		int[] number;
		int countZero;
		Node(int[] number, int countZero) {
			this.number = number;
			this.countZero = countZero;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int X[] = new int[K];
		int countZero = 0;	// 이진법으로 표현된 X에서 0의 개수
		char[] arr = br.readLine().toCharArray();
		for(int i=0; i<K; i++) {
			X[i] = arr[i]-'0';
			if(X[i]==0) countZero++;
		} //read
		
		System.out.println(bfs(X, countZero));	// bfs로 0이 되는 경우 구하기
	}
	static int bfs(int[] X, int countZero) {
		if(countZero == K) return 0;
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(X, countZero));
		int answer = 0;
		for(int i=0; i<K; i++) {
			answer++;
			int qn = que.size();
			for(int j=0; j<qn; j++) {
				Node node = que.poll();
				Node right = cal2(node.number, node.countZero);	// 2를 곱하는 연산
				Node left = cal1(node.number, node.countZero);	// 1을 더하는 연산
				if(check(left) || check(right)) return answer;
				que.offer(left);
				que.offer(right);
			}
		}
		return K;
	}
	static Node cal2(int[] number, int countZero) {
		if(number[0]==1) countZero++;
		if(countZero == K) return new Node(number, K);
		
		int[] arr = new int[K];
		for(int i=0; i<K-1; i++) {
			arr[i] = number[i+1];
		}
		return new Node(arr, countZero);
	}
	static Node cal1(int[] arr, int countZero) {
		arr[K-1]++;
		for(int i=K-1; i>=0; i--) {
			if(arr[i]==2) {
				if(i>0) arr[i-1]++;
				arr[i]=0;
				countZero++;
			} else {
				countZero--;
				break;
			}
		}
		return new Node(arr, countZero);
	}
	static boolean check(Node node) {
		return node.countZero == K;
	}
}
