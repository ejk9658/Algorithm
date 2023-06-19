package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B4_1546_평균 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxScore = 0;
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > maxScore) maxScore = num;
			answer += num;
		}
		System.out.println(answer*1.0/maxScore*100/n);
	}

}
