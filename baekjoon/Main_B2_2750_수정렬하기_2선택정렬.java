package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B2_2750_수정렬하기_2선택정렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //read
		StringBuilder sb = new StringBuilder();
//		Arrays.sort(arr);
		arr = selectionSort(arr, N);	// 선택정렬 O(n^2)
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 선택정렬 O(n^2)
	// 남은 정렬 범위의 최솟값(또는 최댓값)을 찾아 저장하면서 정렬한다.
	// 최솟값을 기준으로 하면, 처음 인덱스(최솟값)부터 정렬된다.
	// 최댓값을 기준으로 하면, 마지막 인덱스(최댓값)부터 정렬된다.
	static int[] selectionSort(int[] arr, int N) {
		for(int i=0; i<N-1; i++) {
			// 1) 최솟값을 찾으면 저장한다.
			int minValue = Integer.MAX_VALUE;
			int minIdx = Integer.MAX_VALUE;
			for(int j=i; j<N; j++) {
				if(minValue > arr[j]) {
					minValue = arr[j];
					minIdx = j;
				}
			}
			// 2) 처음 인덱스부터 정렬한다.
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		return arr;
	}
}