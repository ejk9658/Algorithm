package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S4_1920_수찾기 {

	static int N, M, arr[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(find(0, N-1, Integer.parseInt(st.nextToken()))?"1":"0").append("\n");
		}
		System.out.println(sb.toString());
	}
	static boolean find(int s, int e, int num) {
		if(s<0 || e>=N || s>e) return false;
		int mid = (s+e)/2;
		if(num < arr[mid]) return find(s, mid-1, num);
		else if(num > arr[mid]) return find(mid+1, e, num);
		else return true;
	}
}