package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B2_2750_수정렬하기_버블정렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //read
		StringBuilder sb = new StringBuilder();
//		Arrays.sort(arr);
		arr = bubbleSort(arr, N);	// 버블정렬 O(n^2)
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 버블정렬 O(n^2)
	// 인접한 두 숫자를 비교해서 swap 하면서 자리를 찾아간다.
	// 마지막 인덱스(최댓값)부터 정렬된다.
	static int[] bubbleSort(int[] arr, int N) {
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}