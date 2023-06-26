package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B2_2750_수정렬하기_3삽입정렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //read
		StringBuilder sb = new StringBuilder();
//		Arrays.sort(arr);
		arr = insertionSort(arr, N);	// 삽입정렬 O(n^2)
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 삽입정렬 O(n^2)
	// 정렬하면서 자신의 위치를 찾아 삽입한다.
	// 처음 인덱스부터 정렬된다.
	static int[] insertionSort(int[] arr, int N) {
		for(int i=1; i<N; i++) {	// 1번째 인덱스부터 시작해서 자신의 위치를 찾는다
			int idx = i;
			while(idx>0 && arr[i] < arr[idx-1]) idx--;
			
			int temp = arr[i];
			for(int j=i; j>idx; j--) {
				arr[j] = arr[j-1];
			}
			arr[idx] = temp;
		}
		return arr;
	}
}