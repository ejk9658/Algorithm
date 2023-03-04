package softeer;

import java.util.*;
import java.io.*;

public class Softeer_lv2_전광판
{
    static boolean[][] button = {
        {true,true,true,true,true,true,false},
        {false,false,true,true,false,false,false},
        {false,true,true,false,true,true,true},
        {false,true,true,true,true,false,true},
        {true,false,true,true,false,false,true},
        {true,true,false,true,true,false,true},
        {true,true,false,true,true,true,true},
        {true,true,true,true,false,false,false},
        {true,true,true,true,true,true,true},
        {true,true,true,true,true,false,true},
        {false,false,false,false,false,false,false}
    };
    static int[] from, to;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            from = make(st.nextToken());
            to = make(st.nextToken());
            sb.append(count()).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[] make(String str) {
        int[] arr = new int[5];
        int none = 5-str.length();
        for(int i=0; i<none; i++) arr[i] = 10;
        for(int i=none; i<5; i++) arr[i] = str.charAt(i-none)-'0';
        return arr;
    }
    static int count() {
        int cnt = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<7; j++) {
                if((button[from[i]][j] || button[to[i]][j])&&(!button[from[i]][j] || !button[to[i]][j])) cnt++;
            }
        }
        return cnt;
    }
}
/*
2
1 2
9881 10724

*/
