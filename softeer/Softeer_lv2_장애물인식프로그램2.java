package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv2_장애물인식프로그램2
{
    static int N, map[][];
    static int[][] dd = {{0,1},{1,0},{0,-1},{-1,0}};
    static PriorityQueue<Integer> answer;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new PriorityQueue<>();
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            char[] ca = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                map[i][j] = ca[j]-'0';
            }
        } //read

        go();
        print();
    }
    static void go() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    answer.add(bfs(i,j));
                }
            }
        }
    }
    static int bfs(int r, int c) {
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {r,c});
        map[r][c] = 2;
        while(!que.isEmpty()) {
            int arr[] = que.poll();
            count++;
            for(int d=0; d<4; d++) {
                int nr = arr[0]+dd[d][0];
                int nc = arr[1]+dd[d][1];
                if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                if(map[nr][nc] == 1) {
                    que.offer(new int[] {nr,nc});
                    map[nr][nc] = 2;
                }
            }
        }
        return count;
    }
    static void print() {
        int n = answer.size();
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n");
        while(!answer.isEmpty()) {
            int a = answer.poll();
            sb.append(a).append("\n");
        }
        System.out.println(sb.toString());
    }
}