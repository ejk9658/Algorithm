package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S3_1929_소수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean arr[] = new boolean[N+1];
		arr[1] = true;
		for(int i=2, n=(int)Math.sqrt(N); i<=n; i++) {
			if(arr[i]) continue;
			for(int j=i+i; j<=N; j+=i) {
				arr[j] = true;	// 소수가 아닌 수
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!arr[i]) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}

}
