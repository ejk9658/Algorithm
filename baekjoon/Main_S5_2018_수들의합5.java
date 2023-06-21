package baekjoon;

import java.io.*;

public class Main_S5_2018_수들의합5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		int answer = 0;
		while(!(end_idx == start_idx && end_idx == N)) {
			if(sum < N) {
				sum += ++end_idx;
			} else if(sum == N) {
				answer++;
				sum += ++end_idx;
			} else if(sum > N) {
				sum -= start_idx++;
			}
		}
		System.out.println(answer+1);
	}
}