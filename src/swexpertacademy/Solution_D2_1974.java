package swexpertacademy;

import java.util.Scanner;

public class Solution_D2_1974 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[] sdq = new int[10];
        int i,j,k,l;
 
        for(int tc=1; tc<=T; tc++) {
            int answer = 1;
            boolean roof = true;
        	
        	int[][] arr = new int[9][9];
        	for(i=0; i<9; i++)
        		for (j=0; j<9; j++)
        			arr[i][j] = sc.nextInt();
        	
        	// 9*1 행 비교 
        	for(i=0; i<9; i++) {
        		sdq = new int[] {0,0,0,0,0,0,0,0,0,0};  // 0으로 초기화 
        		for(j=0; j<9; j++) {
        			if(sdq[arr[i][j]] == 0)
        				sdq[arr[i][j]] = 1;
        			else {  // 중복된 숫자가 있는 경우에 0을 리턴하게 됨.
        				answer = 0;
        				roof = false;
        				break;
        			}
        		}
        	}
        	
        	// 1*9 열 비교 
        	if(roof)
            	for(i=0; i<9; i++) {
            		sdq = new int[] {0,0,0,0,0,0,0,0,0,0};  // 0으로 초기화 
            		for(j=0; j<9; j++) {
            			if(sdq[arr[j][i]] == 0)
            				sdq[arr[j][i]] = 1;
            			else {  // 중복된 숫자가 있는 경우에 0을 리턴하게 됨.
            				answer = 0;
            				roof = false;
            				break;
            			}
            		}
            	}
        	
        	// 3*3 비교
        	int rownum, colnum;
        	if(roof)
        		for(i=0; i<3; i++)
        			for(j=0; j<3; j++) {
        				sdq = new int[] {0,0,0,0,0,0,0,0,0,0};  // 0으로 초기화 
            			for(k=0; k<3; k++)
        					for(l=0; l<3; l++) {
        						rownum = 3*i+k;
        						colnum = 3*j+l;
        						if(sdq[arr[rownum][colnum]] == 0)
    	            				sdq[arr[rownum][colnum]] = 1;
    	            			else {  // 중복된 숫자가 있는 경우에 0을 리턴하게 됨.
    	            				answer = 0;
    	            				roof = false;
    	            				break;
    	            			}
    	            		}
        			}
            System.out.println("#"+tc+" "+answer);
        }
    }
 
}