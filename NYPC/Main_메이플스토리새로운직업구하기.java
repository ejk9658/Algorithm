package NYPC;

import java.util.*;
import java.io.*;

public class Main_메이플스토리새로운직업구하기 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<N; i++) {
			hm.put(br.readLine(), 1);
		} // 사용가능한 직업의 value값을 1로 한 <key,value> 값을 hm에 넣기 

		// 사용한 직업의 value값을 0으로 변경
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			String job = br.readLine();
			hm.put(job, 0);
		}
		
		// hm에서 value값이 0인 key값을 출력한다.
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(HashMap.Entry entry: hm.entrySet()) {
			if((int)entry.getValue()==1) {
				count++;
				sb.append(entry.getKey()).append("\n");
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
	}

}
