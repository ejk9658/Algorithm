package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {

	static int N, nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		// 읽기 끝
		
		if(np(N-1)) {
			for(int i=0; i<nums.length; i++)
				sb.append(nums[i]).append(" ");
		}
		else sb.append("-1");
		
		System.out.println(sb.toString());
	}

	private static boolean np(int size) {
		int i = size;
		while(i>0 && nums[i-1]>nums[i]) i--;
		if(i==0) return false;
		int j = size;
		while(nums[i-1]>nums[j]) j--;
		int temp = nums[i-1];
		nums[i-1] = nums[j];
		nums[j] = temp;
		int k = size;
		while(i<k) {
			temp = nums[i];
			nums[i++] = nums[k];
			nums[k--] = temp;
		}
		return true;
	}
}
