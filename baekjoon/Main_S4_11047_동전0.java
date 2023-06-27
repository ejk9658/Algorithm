package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S4_11047_동전0 {

	static int N, K, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //read
		
		int answer = 0;
		for(int i=N-1; i>=0; i--) {
			if(K/arr[i] > 0) {
				answer += (K/arr[i]);
				K %= arr[i];
			}
		}
		System.out.println(answer);
	}
}