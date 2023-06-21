package baekjoon;

import java.io.*;
import java.util.*;

public class Main_S2_12891_DNA비밀번호2 {

	static int S, P, arr[], error;
	static char ch[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		ch = br.readLine().toCharArray();
		arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //read
		
		error = 0;	// 'A','C','G','T' 이외의 글자가 포함된 개수
		int answer = 0;
		// 처음 구간 윈도우 구하기
		for(int i=0; i<P; i++) {
			plus(i);
		}
		if(check()) answer++;
		
		// 슬라이딩 윈도우
		for(int i=0; i<S-P; i++) {
			minus(i);	// 맨 앞 빼기
			plus(i+P);	// 맨 뒤 더하기
			if(check()) answer++;
		}
		System.out.println(answer);
	}
	static void plus(int idx) {
		if(ch[idx] != 'A' && ch[idx] != 'C' && ch[idx] != 'G' && ch[idx] != 'T') error++;
		else if(ch[idx]=='A') arr[0]--;
		else if(ch[idx]=='C') arr[1]--;
		else if(ch[idx]=='G') arr[2]--;
		else if(ch[idx]=='T') arr[3]--;
	}
	static void minus(int idx) {
		if(ch[idx] != 'A' && ch[idx] != 'C' && ch[idx] != 'G' && ch[idx] != 'T') error--;
		else if(ch[idx]=='A') arr[0]++;
		else if(ch[idx]=='C') arr[1]++;
		else if(ch[idx]=='G') arr[2]++;
		else if(ch[idx]=='T') arr[3]++;
	}
	static boolean check() {
		return error == 0 && arr[0]<=0 && arr[1]<=0 && arr[2]<=0 && arr[3]<=0;
	}
}