package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_업무처리2
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int row = (int)Math.pow(2, H);
        int col = K;
        int arr[][] = new int[row][col];
        for(int i=0; i<row; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<col; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        } //read
        
        for(int h=1; h<=H; h++) {
        	arr = changeArr(arr, row/=2, col*=2, h);
        }
        
        System.out.println(getAnswer(arr, R-H));
    }
    static int[][] changeArr(int[][]arr, int row, int col, int h) {
    	int[][] temp = new int[row][col];
    	for(int i=0; i<row; i++) {
    		for(int j=0; j<col; j++) {
    			temp[i][j] = arr[(j+h)%2+2*i][j/2];
    		}
    	}
    	return temp;
    }
    static int getAnswer(int[][] arr, int idx) {
    	int answer = 0;
    	for(int i=0, n=Math.min(arr[0].length, idx); i<n; i++) {
    		answer += arr[0][i];
    	}
    	return answer;
    }
}