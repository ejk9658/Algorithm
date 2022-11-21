package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보충_모의_2112_보호필름 {

	static int D, W, K, map[][], ans;
	static boolean combiArr[], fin;
	
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
			map = new int[D][W];
			for (int d = 0; d < D; d++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[d][w] = Integer.parseInt(st.nextToken());
				}
			} //read
			
			ans = 0;
			fin = false;	// 성능검사를 통과하는 경우, 로직을 강제 종료할거임
			if(!pass(map)) {	// 성능검사를 통과하지 않는 경우 해당 로직을 수행하고, 통과하는 경우 바로 ans(0)를 리턴한다.
				go();
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void go() {
		for (int k = 1; k < K; k++) {
			int[][] mapCopy = new int [D][W];
			for (int d = 0; d < D; d++) {
				mapCopy[d] = Arrays.copyOf(map[d], W);
			}
			subset(0, mapCopy, 0, k);
			if(fin) return;
		}
		ans = K;	// 위의 for문을 모두 수행해도 성능 검사를 통과하지 못했다면, 답은 K이다.(K가 최악이기 때문이다.)
	}

	private static void subset(int d, int[][] mapCopy, int kCnt, int k) {
		if(d == D) {
			if(kCnt!=k) return;
			if(pass(mapCopy)) {	// 성능검사를 통과한 경우
				ans = k;
				fin = true;
			}
			return;
		}
		if(kCnt==k) {
			subset(d+1, mapCopy, kCnt, k);
		} else {
			Arrays.fill(mapCopy[d], 0);
			subset(d+1, mapCopy, kCnt+1, k);
			Arrays.fill(mapCopy[d], 1);
			subset(d+1, mapCopy, kCnt+1, k);
			mapCopy[d] = Arrays.copyOf(map[d], W);
			subset(d+1, mapCopy, kCnt, k);
		}
	}

	private static boolean pass(int[][] arr) {
		int cnt1 = 0;	// 몇 번 연속되었는지 확인
		for (int w = 0; w < W; w++) {
			int cnt2 = 1;	// 몇 번 연속되었는지 확인
			int temp = arr[0][w];	// 처음에 비교할 값
			for (int d = 1; d < D; d++) {
				if(temp == arr[d][w]) {
					cnt2++;
				} else {
					temp = arr[d][w];
					cnt2 = 1;
				}
				if(cnt2 == K) {
					cnt1++;
					break;
				}
			}
		}
		return cnt1==W?true:false;
	}
}