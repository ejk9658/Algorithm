package baekjoon;

import java.io.*;

public class Main_G1_4355_서로소_오일러피공식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100000;
		int arr[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = i; // 오일러피 배열 초기화
		}
		
		for(int i=2; i<=N; i++) {
			if(arr[i]!=i) continue;
			for(int j=i; j<=N; j+=i) {
				arr[j] -= (arr[j]/i);
			}
		}

//		System.out.println(arr[N]);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int k = Integer.parseInt(br.readLine());
			if(k==0) break;
			sb.append(arr[k]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
