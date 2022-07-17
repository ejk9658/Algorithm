package swexpertacademy;

import java.util.*;

public class Solution_D2_1959 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[] A = new int[N];
            int[] B = new int[M];
 
            for(int i=0; i<N; i++)
                A[i] = sc.nextInt();
            for(int i=0; i<M; i++)
                B[i] = sc.nextInt();
 
             
            int max_sum = 0;
            int temp;
            if(N<=M) {
                for(int i=0; i<=M-N; i++) {
                    temp = 0;
                    for(int j=0; j<N; j++) {
                        temp += A[j]*B[i+j];
                    }
                    max_sum = Math.max(max_sum, temp);
                }
            } else {
                for(int i=0; i<=N-M; i++) {
                    temp = 0;
                    for(int j=0; j<M; j++) {
                        temp += A[i+j]*B[j];
                    }
                    max_sum = Math.max(max_sum, temp);
                }
            }
            System.out.println("#"+tc+" "+max_sum);
        }
    }
 
}