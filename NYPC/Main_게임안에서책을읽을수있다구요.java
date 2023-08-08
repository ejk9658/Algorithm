package NYPC;

import java.util.*;
import java.io.*;

public class Main_게임안에서책을읽을수있다구요 {

	static int M;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		int align = 0;	// 0: 왼쪽정렬, 1: 가운데정렬, 2: 오른쪽정렬
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.equals("<CENTER>")) align=1;
			else if(input.equals("<RIGHT>")) align=2;
			else if(input.equals("</CENTER>")||input.equals("</RIGHT>")) align=0;
			else print(input, align);
		}
		System.out.println(sb.toString());
	}
	static void print(String input, int align) {
		String words[] = input.split(" ");
		int N = words.length;
		for(int i=0; i<N; i++) {
			StringBuilder sb1 = new StringBuilder();
			sb1.append(words[i]);
			int len = words[i].length();
			while(i < N-1 && len+words[i+1].length()+1 <= M) {
				sb1.append("-"+words[++i]);
				len += words[i].length()+1;
			}
			print2(sb1.toString(), align);
		}
	}
	static void print2(String str, int align) {
		int emptyLen = M-str.length();	// 공백 길이
		// align 0: 왼쪽정렬, 1: 가운데정렬, 2: 오른쪽정렬
		if(align==0) {
			sb.append(str);
			for(int i=0; i<emptyLen; i++) sb.append("-");
		} else if(align==1) {
			for(int i=0; i<emptyLen/2; i++) sb.append("-");
			sb.append(str);
			for(int i=0; i<(emptyLen+1)/2; i++) sb.append("-");
		} else if(align==2) {
			for(int i=0; i<emptyLen; i++) sb.append("-");
			sb.append(str);
		}
		sb.append("\n");
	}

}
