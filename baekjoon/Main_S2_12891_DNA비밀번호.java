package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S2_12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char ch[] = br.readLine().toCharArray();
		int arr[] = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //read
		
		int answer = 0;
		int error = 0;	// 'A','C','G','T' 이외의 글자가 포함된 개수
		// 처음 구간 윈도우 구하기
		for(int i=0; i<P; i++) {
			if(ch[i] != 'A' && ch[i] != 'C' && ch[i] != 'G' && ch[i] != 'T') error++;
			else if(ch[i]=='A') arr[0]--;
			else if(ch[i]=='C') arr[1]--;
			else if(ch[i]=='G') arr[2]--;
			else if(ch[i]=='T') arr[3]--;
		}
		if(error == 0 && arr[0]<=0 && arr[1]<=0 && arr[2]<=0 && arr[3]<=0) answer++;
		
		// 슬라이딩 윈도우
		for(int i=0; i<S-P; i++) {
			// 맨 앞 빼기
			if(ch[i] != 'A' && ch[i] != 'C' && ch[i] != 'G' && ch[i] != 'T') error--;
			else if(ch[i]=='A') arr[0]++;
			else if(ch[i]=='C') arr[1]++;
			else if(ch[i]=='G') arr[2]++;
			else if(ch[i]=='T') arr[3]++;
			// 맨 뒤 더하기
			if(ch[i+P] != 'A' && ch[i+P] != 'C' && ch[i+P] != 'G' && ch[i+P] != 'T') error++;
			else if(ch[i+P]=='A') arr[0]--;
			else if(ch[i+P]=='C') arr[1]--;
			else if(ch[i+P]=='G') arr[2]--;
			else if(ch[i+P]=='T') arr[3]--;
			
			if(error == 0 && arr[0]<=0 && arr[1]<=0 && arr[2]<=0 && arr[3]<=0) answer++;
		}
		System.out.println(answer);
	}
}