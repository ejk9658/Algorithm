package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D1_2072_홀수만더하기 {
 
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        int N=10;
        int[] arr = new int[N];
    	for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                arr[i]=Integer.parseInt(st.nextToken());
            
            // 로직
            int sum = 0;
            for(int i=0; i<N; i++)
                if(arr[i]%2==1)
                    sum += arr[i];
            
            //결과
            System.out.println("#"+tc+" "+sum);
        }
 
    }
 
}
