package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_사물인식최소면적산출프로그램
{
    static int N, K, answer;
    static ArrayList<int[]>[] adjlist;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adjlist = new ArrayList[K+1];
        for(int i=1; i<=K; i++) {
            adjlist[i] = new ArrayList<int[]>();
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            adjlist[k].add(new int[] {x,y});
        } //read

        answer = Integer.MAX_VALUE;
        int n = adjlist[1].size();
        for(int i=0; i<n; i++) {
            dfs(adjlist[1].get(i), adjlist[1].get(i), 0, 2);   // (좌측상단 좌표값, 우측하단 좌표값, 직사각형 넓이, 다음 k의 값)
        }
        System.out.println(answer);
    }
    static void dfs(int[] lefttop, int[] rightbottom, int area, int k) {
        if(k > K) {
            answer = Math.min(answer, area);
            return;
        }
        int n = adjlist[k].size();
        for(int i=0; i<n; i++) {
            int nx = adjlist[k].get(i)[0];
            int ny = adjlist[k].get(i)[1];
            int[] nlefttop = new int[] {Math.min(lefttop[0], nx), Math.max(lefttop[1], ny)};
            int[] nrightbottom = new int[] {Math.max(rightbottom[0], nx), Math.min(rightbottom[1], ny)};
            int narea = (nrightbottom[0]-nlefttop[0])*(nlefttop[1]-nrightbottom[1]);
            if(answer < narea) continue;    // 백트레킹
            dfs(nlefttop, nrightbottom, narea, k+1);

            // 현재 직사각형 모양과 다음 직사각형의 모양이 같은 경우
            if(check(lefttop, rightbottom, nlefttop, nrightbottom)) break;
        }
    }
    static boolean check(int[] lefttop, int[] rightbottom, int[] nlefttop, int[] nrightbottom) {
        return lefttop[0]==nlefttop[0]&&lefttop[1]==nlefttop[1]&&rightbottom[0]==nrightbottom[0]&&rightbottom[1]==nrightbottom[1];
    }
}
