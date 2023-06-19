package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_로봇이지나간경로
{
    static int R, C, visitCount;
    static boolean map[][], visited[][];
    static StringBuilder sb1, sb2, answer;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];    // #: true
        visitCount = 0; // #의 개수
        int maxLength = Integer.MAX_VALUE;
        for(int i=0; i<R; i++) {
            char ch[] = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                if(ch[j]=='.') continue;
                map[i][j] = true;
                visitCount++;
            }
        }
        // make

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(!map[r][c]) continue;    // .이면 패스
                for(int d=0; d<4; d++) {
                    int nr = r+dd[d][0];
                    int nc = c+dd[d][1];
                    if(!check(nr,nc)) continue;  // 범위 밖이면 패스
                    if(!map[nr][nc]) continue;  // .이면 패스
                    sb1 = new StringBuilder();
                    sb1.append((r+1)+" "+(c+1)+"\n");
                    switch(d) {
                        case 0: sb1.append(">");
                        break;
                        case 1: sb1.append("v");
                        break;
                        case 2: sb1.append("<");
                        break;
                        case 3: sb1.append("^");
                    }
                    
                    sb2 = new StringBuilder();
                    if(!go(r, c, d)) continue;

                    if(sb2.length() < maxLength) {
                        maxLength = sb2.length();
                        answer = new StringBuilder();
                        answer.append(sb1.toString()).append("\n").append(sb2.toString());
                    }
                }
            }
        }
        System.out.println(answer.toString());
    }
    static int dd[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean go(int row, int col, int dir) {
        visited = new boolean[R][C];
        visited[row][col] = true;
        int vCount = 1; // 방문한 # 개수
        int nd = dir;
        while(vCount != visitCount) {
            int nr = row+dd[nd][0];
            int nc = col+dd[nd][1];
            int nnr = nr+dd[nd][0];
            int nnc = nc+dd[nd][1];

            if(check(nr,nc) && map[nr][nc] && !visited[nr][nc]) {   // 전진한다
                if(dir != nd) {
                    if(nd == (dir+1)%4) { // 방향을 전환한다
                        sb2.append("R");
                    } else if(nd == (dir+2)%4) {
                        sb2.append("RR");
                    } else if(nd == (dir+3)%4) {
                        sb2.append("L");
                    }
                    dir = nd;
                }

                sb2.append("A");
                visited[nr][nc] = true;
                vCount++;
                row = nr;
                col = nc;
                if(check(nnr,nnc)) {    // 두 칸 전진 가능한 경우
                    if(!map[nnr][nnc] || visited[nnr][nnc]) return false;   // 갈 수 없거나 이미 방문한 경우
                    visited[nnr][nnc] = true;
                    vCount++;
                    row = nnr;
                    col = nnc;
                }
            } else if(!check(nr,nc) || (check(nr,nc) && (!map[nr][nc] || visited[nr][nc]))) {   // 방향을 전환한다
                nd = (nd+1)%4;
                if(nd == dir) return false; // 방향을 전환해도 더이상 갈 곳이 없는 경우
            }
        }
        return true;
    }
    
    static boolean check(int row, int col) {
        if(row<0 || row>=R || col<0 || col>=C) return false;
        return true;
    }
}
/*
9 14
.......###....
.........#....
.#####...###..
.#.........#..
.#.#####...###
.#.#...#.....#
.###.###.....#
.....#.......#
.....#########

*/
