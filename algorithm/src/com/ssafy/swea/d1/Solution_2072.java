package com.ssafy.swea.d1;

import java.util.Scanner;

public class Solution_2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 10;
		int[] arr = new int[N];
		
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			for (int e: arr) {
				if(e%2==1)
					sum+=e;
			}
			System.out.println("#"+t+" "+sum);
		}

	}

}
