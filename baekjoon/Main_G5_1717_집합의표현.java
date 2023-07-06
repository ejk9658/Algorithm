package baekjoon;

import java.io.*;
import java.util.*;

public class Main_G5_1717_집합의표현 {

	static int U[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		U = new int[n+1];
		for(int i=0; i<=n; i++) U[i]=i;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(type==0) union(a,b);
			else if(type==1) sb.append(find(a)==find(b)?"YES":"NO").append("\n");
		}
		System.out.print(sb.toString());
	}
	static void union(int a, int b) {
		if(a>b) {
			int temp = b;
			b = a;
			a = temp;
		}
		a = find(a);	// union 할 때마다 U[]값을 갱신해주어야 함
		b = find(b);
		if(a==b) return;
		U[b] = a;
	}
	static int find(int n) {
		if(U[n] == n) return n;
		return U[n]=find(U[n]);
	}
}
