package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv2_장애물인식프로그램
{
    static int N;
    static int[][] map;
    static ArrayList<Integer> answer;
    static boolean[][] visit;
    static int[][] dd = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        } //read

        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==0 || visit[i][j]) continue;
                visit[i][j] = true;
                answer.add(bfs(i,j));
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);
        int n = answer.size();
        sb.append(n).append("\n");
        for(int i=0; i<n; i++) {
            sb.append(answer.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int row, int col) {
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {row, col});
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int r = arr[0];
            int c = arr[1];
            count++;
            for(int d=0; d<4; d++) {
                int nr = r+dd[d][0];
                int nc = c+dd[d][1];
                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(map[nr][nc]==0 || visit[nr][nc]) continue;
                visit[nr][nc] = true;
                que.offer(new int[] {nr,nc});
            }
        }
        return count;
    }
}
