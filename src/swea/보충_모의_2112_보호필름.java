package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 보충_모의_2112_보호필름 {

	static int D, W, K, map[][], ans;
	static boolean change[], fin; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [D][W];
			for (int d = 0; d < D; d++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[d][w] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			ans = 0;	// 약품의 최소 투입 횟수
			
			if(!pass(map)) {	// 1. 합격기준을 만족시키지 못할 경우
				for (int d = 1; d <= D; d++) {	// 약품을 1~D번 투입할 것이다.
					change = new boolean[D];	// change[] : 1에 해당하는 인덱스와 일치하는 map의 행을 찾아 약품을 투입한다.
					fin = false;
					combi(0,0,d);
					System.out.println("------");
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static boolean pass(int[][] arr) {
		int cnt = 0;	// cnt : 모든 열이 합격기준을 만족하였는지 확인
		for (int w = 0; w < W; w++) {
			int rep = 1;	// rep : 셀의 특성이 몇 번 반복되었는지 확인
			int temp = arr[0][w];	// temp : 비교할 0번째 행의 셀의 특성
			for (int d = 1; d < D; d++) {	// 1번째 행부터 D-1번 행까지 비교 시작
				if(temp == arr[d][w]) {
					rep++;
					if(rep >= K) {
						cnt ++;
						break;
					}
				} else {
					temp = arr[d][w];
					rep = 1;
				}
			}
		}
		return cnt==W?true:false;
	}

	private static void combi(int start, int cnt, int d) {
		if(cnt==d) {
			System.out.println(Arrays.toString(change));
			// 3. 약품을 투입한다.
			go();
			return;
		}
		for (int i = start; i < D; i++) {
			change[i] = true;
			combi(i+1, cnt+1, d);
			if(fin) return;
			change[i] = false;
			
		}
	}

	private static void go() {
		int temp[][] = new int[D][W];
		for (int i = 0; i < D; i++) {
			temp[i] = Arrays.copyOf(map[i], W);
		}
		for (int i = 0; i < D; i++) {
			if(change[i]) {	// 약품을 투입해야 하는 경우
				// 3-1. 0으로 투입하는 경우
				Arrays.fill(temp[i], 0);
				
				
			}
		}
	}
	
}
