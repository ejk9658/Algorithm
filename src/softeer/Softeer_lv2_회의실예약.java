package softeer;

import java.util.*;
import java.io.*;

public class Softeer_lv2_회의실예약
{
    static class Room implements Comparable<Room>{
        String name;
        boolean[] times;
        Room(String name) {
            this.name = name;
            this.times = new boolean[19];
        }
        @Override
        public int compareTo(Room r) {
            return this.name.compareTo(r.name);
        }
    }
    static int N,M;
    static Room[] rooms;
    static HashMap<String, Integer> hm;
    static LinkedList<Integer> ll;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rooms = new Room[N];
        hm = new HashMap<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            hm.put(str, i);   // N개의 회의실 이름 저장
            rooms[i] = new Room(str);
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // read

            for(int j=from; j<to; j++) {
                rooms[hm.get(str)].times[j] = true;
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        Arrays.sort(rooms);
        for(int i=0; i<N; i++) {
            ll = new LinkedList<>();
            sb.append("Room ").append(rooms[i].name).append(":\n");
            find(rooms[i]);
            int cnt = ll.size();
            if(cnt==0) {
                sb.append("Not available\n");
            } else {
                sb.append(cnt/2).append(" available:\n");
            }
            for(int j=0; j<cnt; j+=2) {
                String from = ll.get(j)<10?"0"+ll.get(j):""+ll.get(j);
                String to = ll.get(j+1)<10?"0"+ll.get(j+1):""+ll.get(j+1);
                sb.append(from).append("-").append(to).append("\n");
            }
            sb.append("-----\n");
        }
        sb.setLength(sb.length()-7);
        System.out.println(sb.toString());
    }
    private static void find(Room room) {
        int cnt = 0;
        for(int i=9; i<18; i++) {
            if(room.times[i]) { // 예약 불가능 시간
                if(cnt==0) continue;
                ll.add(i);
                cnt=0;
            } else {    // 예약 가능 시간
                if(cnt==0) ll.add(i);
                cnt++;
            }
        }
        if(cnt>0) ll.add(18);
    }
}
/*
3 7
grandeur
avante
sonata
sonata 14 16
grandeur 11 12
avante 15 18
sonata 10 11
avante 9 12
grandeur 16 18
avante 12 15

*/