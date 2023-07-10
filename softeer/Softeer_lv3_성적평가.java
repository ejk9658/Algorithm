package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_성적평가
{
    static int N;
    static StringBuilder sb;
    static class Node implements Comparable<Node> {
        int num, score;
        Node(int num, int score) {
            this.num = num;
            this.score = score;
        }
        @Override
        public int compareTo(Node o) {
            return o.score - this.score;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int totalScore[] = new int[N];
        for(int i=0; i<3; i++) {
            int score[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                totalScore[j] += score[j];
            } //read
            print(score);
        }
        print(totalScore);
        System.out.println(sb.toString());
    }
    static void print(int[] score) {
        int answer[] = new int[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.offer(new Node(i, score[i]));
        }
        int tmp = -1;   // 중복점수 체크
        int cnt = 0;
        for(int i=0; i<N; i++) {
            Node n = pq.poll();
            if(n.score == tmp) {
                cnt++;
            } else {
                tmp = n.score;
                cnt = 0;
            }
            answer[n.num] = i+1-cnt;
        }

        for(int i=0; i<N; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
    }
}