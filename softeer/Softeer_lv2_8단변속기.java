package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv2_8단변속기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i=0; i<8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int plus=0, minus=0;
        for(int i=1; i<8; i++) {
            if(Math.abs(arr[i-1]-arr[i])>1) {
                System.out.println("mixed");
                return;
            }
            else if(arr[i-1] < arr[i]) plus++;
            else if(arr[i-1] > arr[i]) minus++;
        }

        if(plus == 7) System.out.println("ascending");
        else if(minus == 7) System.out.println("descending");
        else System.out.println("mixed");
    }
}