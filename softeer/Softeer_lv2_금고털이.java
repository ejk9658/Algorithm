package softeer;

import java.util.*;
import java.io.*;

public class Softeer_lv2_금고털이
{
    static int W, N, answer;
    static PriorityQueue<int[]> pq;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>((o1,o2)->{
            return o2[1]==o1[1]?o1[0]-o2[0]:o2[1]-o1[1];
        });
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {w,p});
        }

        while(W > 0 && !pq.isEmpty()) {
            int jew[] = pq.poll();
            if(W-jew[0] < 0) answer += (W*jew[1]);
            else answer += (jew[0]*jew[1]);
            W -= jew[0];
        }
        System.out.println(answer);
    }
}
/*
100 2
90 1
70 2
*/
