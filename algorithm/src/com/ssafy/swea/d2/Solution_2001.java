package com.ssafy.swea.d2;

import java.util.Scanner;

public class Solution_2001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        int sum_count;
        int answer;
 
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    arr[i][j] = sc.nextInt();
             
            answer = 0;
            for(int i=0; i<=N-M; i++)
                for(int j=0; j<=N-M; j++) {
                    sum_count = 0;
                    for(int k=0; k<M; k++)
                        for(int l=0; l<M; l++)
                            sum_count += arr[i+k][j+l];
                    answer = Math.max(answer, sum_count);
            }
             
            System.out.println("#"+tc+" "+answer);
        }
    }
}
