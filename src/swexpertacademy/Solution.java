package swexpertacademy;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int[][] arr1 = new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					arr1[i][j] = sc.nextInt();
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					System.out.print(arr1[N-j-1][i]);
				System.out.print(" ");
				for(int k=0; k<N; k++)
					System.out.print(arr1[N-i-1][N-k-1]);
				System.out.print(" ");
				for(int l=0; l<N; l++)
					System.out.print(arr1[l][N-i-1]);
				System.out.println();
			}
		}
	}

}
