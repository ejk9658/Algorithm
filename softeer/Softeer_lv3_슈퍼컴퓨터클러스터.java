package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_슈퍼컴퓨터클러스터
{
    static int N;
    static long B, arr[], cost, answer;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        } //read

        Arrays.sort(arr);
        bin(arr[0], arr[N-1] + (long)Math.sqrt(B));	// 'arr[]의 최댓값 + B원으로 최대 업그레이드할 수 있는 점수'를 최댓값으로 지정함.
        System.out.println(answer);
    }
    static void bin(long left, long right) {
        if(left > right) return;
        long mid = (left+right)/2;
        long temp = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] >= mid || temp > B) break;
            temp += ((mid-arr[i])*(mid-arr[i]));
        }
        // 이분탐색
        if(temp > B) {
            bin(left, mid-1);
        } else {
            cost = temp;
            answer = mid;
            bin(mid+1, right);
        }
    }
}
/*
10 10
5 3 9 8 4 3 1 8 6 3

*/