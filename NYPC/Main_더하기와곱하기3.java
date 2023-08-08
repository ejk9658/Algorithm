package NYPC;

import java.util.*;
import java.io.*;

public class Main_더하기와곱하기3 {

	static int K, X[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		X = new int[K];
		char[] arr = br.readLine().toCharArray();
		for(int i=0; i<K; i++) {
			X[i] = arr[i]-'0';
		} //read
		
		System.out.println(bfs());	// bfs로 0이 되는 경우 구하기
	}
	static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(X);
		int count = 0;
		for(int i=0; i<K; i++) {
			count++;
			int qn = que.size();
			for(int j=0; j<qn; j++) {
				int[] temp = que.poll();
				int[] right = cal2(temp);	// 2를 곱하는 연산
				int[] left = cal1(temp);	// 1을 더하는 연산
				if(check(left) || check(right)) return count;
				que.offer(left);
				que.offer(right);
			}
		}
		return K;
	}
	static int[] cal2(int[] temp) {
		int[] arr = new int[K];
		for(int i=0; i<K-1; i++) {
			arr[i] = temp[i+1];
		}
		return arr;
	}
	static int[] cal1(int[] temp) {
		int[] arr = temp;
		arr[K-1]++;
		for(int i=K-1; i>=0; i--) {
			if(arr[i]==2) {
				if(i>0) arr[i-1]++;
				arr[i]=0;
			}
		}
		return arr;
	}
	static boolean check(int[] arr) {
		for(int i=0; i<K; i++) {
			if(arr[i]==1) return false;
		}
		return true;
	}
}
