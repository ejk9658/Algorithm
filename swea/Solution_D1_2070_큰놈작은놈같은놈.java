package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2070_큰놈작은놈같은놈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num%2==1) {	// 입력한 수가 홀수인 경우
					ans += num;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
