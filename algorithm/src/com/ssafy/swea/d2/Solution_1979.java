package com.ssafy.swea.d2;

import java.util.Scanner;

public class Solution_1979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        int answer;
        int cnt;
         
        for(int tc=1; tc<=T; tc++) {
            answer = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
 
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    arr[i][j] = sc.nextInt();
             
            for(int i=0; i<N; i++) {
                cnt = 0;
                for(int j=0; j<N; j++) {
                    if(arr[i][j]==1)
                        cnt += 1;
                    else if(cnt==K) {
                        answer += 1;
                        cnt = 0;
                    }
                    else
                        cnt = 0;
                }
                if(cnt==K && arr[i][N-1]==1)
                    answer += 1;
            }
             
            for(int i=0; i<N; i++) {
                cnt = 0;
                for(int j=0; j<N; j++) {
                    if(arr[j][i]==1)
                        cnt += 1;
                    else if(cnt==K) {
                        answer += 1;
                        cnt = 0;
                    }
                    else
                        cnt = 0;
                }
                if(cnt==K && arr[N-1][i]==1)
                    answer += 1;
            }
             
            System.out.println("#"+tc+" "+answer);
        }
    }
 
}
