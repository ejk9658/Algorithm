package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv2_전광판2
{
    static int map[][] = {
        {1,1,1,0,1,1,1},
        {0,0,1,0,0,1,0},
        {1,0,1,1,1,0,1},
        {1,0,1,1,0,1,1},
        {0,1,1,1,0,1,0},
        {1,1,0,1,0,1,1},
        {1,1,0,1,1,1,1},
        {1,1,1,0,0,1,0},
        {1,1,1,1,1,1,1},
        {1,1,1,1,0,1,1},
        {0,0,0,0,0,0,0}
    };
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            String str[] = br.readLine().split(" ");
            int[] from = makeNums(str[0]);
            int[] to = makeNums(str[1]);
            sb.append(countNums(from, to)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[] makeNums(String str) {
        int[] nums = new int[] {10,10,10,10,10};
        String[] number = str.split("");
        int len = number.length;
        for(int i=0; i<len; i++) {
            nums[5-len+i] = Integer.parseInt(number[i]);
        }
        return nums;
    }
    static int countNums(int[] from, int[] to) {
        int cnt = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<7; j++) {
                if(map[from[i]][j] != map[to[i]][j]) cnt++;
            }
        }
        return cnt;
    }
}