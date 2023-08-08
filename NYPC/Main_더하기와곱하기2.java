package NYPC;

import java.util.*;
import java.io.*;

public class Main_더하기와곱하기2 {

	static int K, X, maximum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		X = x(arr);	// X 구하기 
		maximum = (int)Math.pow(2, K);
		
		System.out.println(bfs());	// bfs로 0이 되는 경우 구하기
	}
	static int x(char[] arr) {
		int X = 0;
		for(int i=0; i<K; i++) {
			if(arr[i]=='0') continue;
			X += (int)Math.pow(2, K-1-i);
		}
		return X;
	}
	static int bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(X);
		int count = 0;
		for(int i=0; i<K; i++) {
			count++;
			int qn = que.size();
			for(int j=0; j<qn; j++) {
				int temp = que.poll();
				int left = (temp+1) % maximum;
				int right = (temp*2) % maximum;
				if(left == 0 || right == 0) return count;
				que.offer(left);
				que.offer(right);
			}
		}
		return K;
	}
}
