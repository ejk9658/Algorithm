package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S4_1940_주몽 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //read
		int answer = 0;

		Arrays.sort(arr);
		int start_idx = 0;
		int end_idx = N-1;
		int sum = arr[start_idx] + arr[end_idx];
		while(start_idx < end_idx) {
			if(sum < M) {
				sum = sum - arr[start_idx] + arr[++start_idx];
			} else if(sum == M) {
				answer++;
				sum = arr[++start_idx] + arr[--end_idx];
			} else if(sum > M) {
				sum = sum - arr[end_idx] + arr[--end_idx];
			}
		}
		System.out.println(answer);
	}
}