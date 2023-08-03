package baekjoon;

import java.util.*;
import java.io.*;

public class Main_1654_랜선자르기 {
	
	static int K, N;
	static long arr[], answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
		} //read
		
		Arrays.sort(arr);
		bin(1, arr[K-1]);
		System.out.println(answer);
	}
	static void bin(long left, long right) {
		if(left > right) return;
		long temp = 0;
		long mid = (left+right)/2;
		for(int i=0; i<K; i++) {
			temp += (arr[i]/mid);
		}
		if(temp < N) bin(left, mid-1);
		else {
			answer = mid;
			bin(mid+1, right);
		}
	}
}
