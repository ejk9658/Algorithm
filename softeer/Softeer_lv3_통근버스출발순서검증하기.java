package softeer;

import java.util.*;
import java.io.*;


public class Softeer_lv3_통근버스출발순서검증하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		long answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //read
		
		for(int i=0; i<N-1; i++) {
			ArrayList<Integer> bigger = new ArrayList<>();
			ArrayList<Integer> smaller = new ArrayList<>();
			for(int j=i+1; j<N; j++) {
				if(arr[i] < arr[j]) bigger.add(j);
				else smaller.add(j);	// 버스 번호는 서로 중복되지 않는다.
			}
			
			int sn = smaller.size();
			int bn = bigger.size();
			if(sn == 0 || bn == 0) continue;
			
			// smaller 리스트를 배열로 만든다.
			int sarr[] = new int[sn];
			for(int j=0; j<sn; j++) {
				sarr[j] = smaller.get(j);
			}
			
			// bigger의 요소를 sarr의 binarySearch를 이용해서 answer 개수를 구한다.
			for(int j=0; j<bn; j++) {
				if(bigger.get(j) > sarr[sn-1]) break;
				answer += sarr.length - (Arrays.binarySearch(sarr, bigger.get(j))*(-1)-1);
			}
		}
		
		System.out.println(answer);
	}

}
