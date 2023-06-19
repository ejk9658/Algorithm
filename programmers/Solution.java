package programmers;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String my_string = "jaron";
		System.out.println(solution(my_string));
	}
	
	static public String solution(String my_string) {
		String answer = "";
		for(int i=my_string.length()-1; i>=0; i--)
			answer += my_string.split("")[i];
		System.out.println("asdfasd".substring(2,5));
		return answer;
		
	}
}
