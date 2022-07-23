package com.ssafy.swea.d2;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		char cA = 65;
		char ca = 97;
		char c0 = 48;
		System.out.println(cA+" "+ca+" "+c0);
		
		int[] arr1 = {1,2,3,4,5};	// 재할당 불가능
		int[] arr2 = new int[3];	// 재할당 가능
		// arr1 = {1,2,3,4};
		arr2 = new int[] {1,2};
		
		int[] arr3 = new int[] {1,2,3};  // 한 줄로 배열 선언, 생성, 할당하기
		System.out.println(Arrays.toString(arr3));
		
		int a = 10;	// 기본형은 CBV (값 복사)
		int b = a;
		b = 5;
		System.out.println(a+" "+b);
		
		int[] arr4 = arr1;	// 배열은 CBR (주소 복사)
		System.out.println(arr1[0] + " " + arr4[0]);
		arr4[0] = 44;
		System.out.println(arr1[0] + " " + arr4[0]);
		
		String s1 = "Hello";	// String은 CBV (값 복사)
		String s2 = s1;
		s2 = "go";
		System.out.println(s1+" "+s2);
		
		
	}
}
