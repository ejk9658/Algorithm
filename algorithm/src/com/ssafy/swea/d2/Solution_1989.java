package com.ssafy.swea.d2;

import java.util.Scanner;

public class Solution_1989 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=1; t<=T; t++) {
			int answer = 0;
			String word = sc.next().trim();
			int n = word.length();
			String reverse = "";
			for(int i=0; i<n; i++)
				reverse += word.charAt(n-i-1);
			if(word.equals(reverse))
				answer = 1;
			System.out.println("#"+t+" "+answer);
		}
	}
}
