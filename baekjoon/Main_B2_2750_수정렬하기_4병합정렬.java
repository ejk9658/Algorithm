package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B2_2750_수정렬하기_4병합정렬 {
	
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //read
		StringBuilder sb = new StringBuilder();
		mergeSort(0, N-1);	// 병합정렬 O(nlogn)
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 병합정렬 O(nlogn)
	// 반으로 나눈 정렬된 두 배열에 투 포인터를 사용하여 병합한다.
	static void mergeSort(int start, int end) {
		if(start < end) {
			mergeSort(start, (start+end)/2);
			mergeSort((start+end)/2+1, end);
			merge(start, (start+end)/2+1, end);
		}
	}
	static void merge(int start1, int start2, int end) {
		int idx1 = start1;
		int idx2 = start2;
		int n = end-start1+1;
		int[] temp = new int[n];
		int t = 0;
		while(idx1<start2 && idx2<end+1) {
			if(arr[idx1] <= arr[idx2]) temp[t++] = arr[idx1++];
			else temp[t++] = arr[idx2++];
		}
		while(idx1<start2) temp[t++] = arr[idx1++];
		while(idx2<end+1) temp[t++] = arr[idx2++];
		for(int i=0; i<n; i++) {
			arr[start1+i] = temp[i];
		}
	}
}
/*
5
5
2
3
4
1

*/