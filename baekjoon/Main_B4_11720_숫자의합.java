package baekjoon;

import java.io.*;

public class Main_B4_11720_숫자의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		char ch[] = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			answer += ch[i]-'0';
		}
		System.out.println(answer);
	}

}
