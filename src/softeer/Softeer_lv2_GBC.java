package softeer;

import java.util.*;
import java.io.*;

public class Softeer_lv2_GBC
{
    static int N, M, time, answer;
    static int[][] arr1, arr2;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][2];
        arr2 = new int[M][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            if(i==0) arr1[i][0] = Integer.parseInt(st.nextToken());
            else arr1[i][0] = arr1[i-1][0] + Integer.parseInt(st.nextToken());
            arr1[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            if(i==0) arr2[i][0] = Integer.parseInt(st.nextToken());
            else arr2[i][0] = arr2[i-1][0] + Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        } //read

        int idx1=0, idx2=0;
        while(time<100) {
            if(arr1[idx1][0] < arr2[idx2][0]) {
                time = arr1[idx1][0];
                answer = Math.max(answer, arr2[idx2][1]-arr1[idx1][1]);
                idx1++;
            } else if(arr1[idx1][0] > arr2[idx2][0]) {
                time = arr2[idx1][0];
                answer = Math.max(answer, arr2[idx2][1]-arr1[idx1][1]);
                idx2++;
            } else {
                time = arr1[idx1][0];
                answer = Math.max(answer, arr2[idx2][1]-arr1[idx1][1]);
                idx1++;
                idx2++;
            }
        }
        System.out.println(answer);
    }
}
/*
3 3
50 50
40 40
10 30
60 76
18 28
22 50

*/