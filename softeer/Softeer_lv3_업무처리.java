package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_업무처리
{
    static int H, K, R, n, answer;
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        n = (int)Math.pow(2,H);
        map = new int[K][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        } //read

        if(R-H > n*K) {
            for(int i=0; i<K; i++) {
                for(int j=0; j<n; j++) {
                    answer += map[i][j];
                }
            }
        } else if(R-H > 0) {
            makeMap(K, n, 0);

            for(int i=0; i<R-H; i++) {
                answer += map[i][0];
            }
        }
        System.out.println(answer);
    }
    static void makeMap(int row, int col, int dir) {
        int r = row*2;
        int c = col/2;
        int[][] temp = new int[r][c];
        if(dir%2==0) { // 오른쪽 먼저 채워진다.
            for(int i=0; i<row; i++) {
                for(int j=col-1; j>=0; j--) {
                    temp[2*i+(j%2==0?1:0)][j/2] = map[i][j];
                }
            }
            System.out.println();
        } else { // 왼쪽 먼저 채워진다.
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    temp[2*i+(j%2==0?0:1)][j/2] = map[i][j];
                }
            }
        }
        map = temp;
        if(c>1) makeMap(r, c, dir+1);
    }
}
/*
1 3 2
9 3 7
5 11 2

*/