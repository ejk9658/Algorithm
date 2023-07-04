package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B1_1934_최소공배수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(A * B / GCD(A, B)).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int GCD(int a, int b) {
		if(a<b) {
			int temp = b;
			b = a;
			a = temp;
		}
		if(b == 0) return a;
		return GCD(b, a%b);
	}
}
