package com.ssafy.swea.d1;

import java.util.Scanner;

public class Solution_2070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a<b)
				System.out.println("#"+t+" <");
			else if(a>b)
				System.out.println("#"+t+" >");
			else
				System.out.println("#"+t+" =");
		}
	}
}
