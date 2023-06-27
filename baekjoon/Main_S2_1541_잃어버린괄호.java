package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S2_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String head = input.split("-")[0];
		int answer = 0;
		if(head.length() == input.length()) {
			answer = sum(head);
		} else {
			String tail = input.substring(head.length()+1, input.length());
			answer = sum(head) - sum(tail);
		}
		System.out.println(answer);
	}
	static int sum(String str) {
		int temp = 0;
		String arr1[] = str.split("-");
		for(int i=0, n1=arr1.length; i<n1; i++) {
			String arr2[] = arr1[i].split("\\+");
			for(int j=0, n2=arr2.length; j<n2; j++) {
				temp += Integer.parseInt(arr2[j]);
			}
		}
		return temp;
	}
}