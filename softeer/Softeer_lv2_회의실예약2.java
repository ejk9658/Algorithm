package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv2_회의실예약2
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][18];
        HashMap<String, Integer> hm = new HashMap<>();
        String cars[] = new String[N];
        for(int i=0; i<N; i++) {
            String c = br.readLine();
            hm.put(c, i);
            cars[i] = c;
        }
        Arrays.sort(cars);
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int car = hm.get(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start; j<end; j++) {
                map[car][j] = 1;
            }
        }

        // 0인 부분을 출력하기
        for(int i=0; i<N; i++) {
            sb.append("Room ").append(cars[i]).append(":\n");
            boolean isNot = true;
            int cnt = 0;
            StringBuilder sb2 = new StringBuilder();
            for(int j=9; j<18; j++) {
                int idx = hm.get(cars[i]);
                if(map[idx][j]==0) {
                    cnt++;
                    int s = j;
                    int e = j+1;
                    while(e<18 && map[idx][e]==0) {
                        e++;
                    }
                    if(s==9) sb2.append("0");
                    sb2.append(s).append("-").append(e).append("\n");
                    j = e;
                    isNot = false;
                }
            }
            if(isNot) sb.append("Not available\n");
            else sb.append(cnt).append(" available:\n").append(sb2.toString());
            sb.append("-----\n");
        }
        sb.setLength(sb.length()-7);
        System.out.println(sb.toString());
    }
}