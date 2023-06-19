package baekjoon;

import java.util.Scanner;

public class DP_Main_1463_1로만들기 {

	static int N;
	static int[] nums;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dp();
		System.out.println(nums[N]);
	}

	private static void dp() {
		nums = new int[N+1];
		for(int i=2; i<N+1; i++) {
			nums[i] = nums[i-1]+1;
			if(i%3==0)
				nums[i] = Math.min(nums[i], nums[i/3]+1);
			if(i%2==0)
				nums[i] = Math.min(nums[i], nums[i/2]+1);
		}
	}
}
