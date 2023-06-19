package formula;

import java.util.Arrays;

public class Arrays_binarySearch_이분탐색 {

	public static void main(String[] args) {
		int arr[] = {10,40,20};
		Arrays.sort(arr);	// 오름차순 정렬
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[1]);
		System.out.println(Arrays.binarySearch(arr, 20));	// 있는 경우, 인덱스를 리턴함.
		System.out.println(Arrays.binarySearch(arr, 30));	// 없는 경우, 끼어야 할 인덱스*(-1)-1을 리턴함.
	}

}
