package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S5_1427_소트인사이드_선택정렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int N = input.length;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		} //read
		StringBuilder sb = new StringBuilder();
//		Arrays.sort(arr, Collections.reverseOrder());	// Integer[] arr
		arr = selectionSort(arr, N);	// 선택정렬 O(n^2)
		for(int i=0; i<N; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}
	// 선택정렬 O(n^2)
	// 최솟값(또는 최댓값)을 찾아 저장하면서 정렬한다.
	// 최솟값을 기준으로 하면, 처음 인덱스(최솟값)부터 정렬된다.
	// 최댓값을 기준으로 하면, 마지막 인덱스(최댓값)부터 정렬된다.
	static int[] selectionSort(int[] arr, int N) {
		for(int i=0; i<N-1; i++) {
			// 1) 최댓값을 찾으면 저장한다.
			int maxValue = -1;
			int maxIdx = -1;
			for(int j=i; j<N; j++) {
				if(maxValue < arr[j]) {
					maxValue = arr[j];
					maxIdx = j;
				}
			}
			// 2) 처음 인덱스부터 정렬한다.
			int temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
		}
		return arr;
	}
}