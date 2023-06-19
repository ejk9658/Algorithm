package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1976_여행가자 {

	static int N, M, map[][], trip[], root[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		trip = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			trip[i] = Integer.parseInt(st.nextToken())-1;
		} // read
		
		// 1. 각 도시의 root를 자신으로 초기화.
		make();
		
		// 2. root가 같은 도시 집합을 합친다.
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(map[i][j] == 1)	// 1이라면 연결되어 있는 것이므로 root를 바꿔준다.
					root[j] = root[i];
			}
			for (int j = 0; j < i; j++) {
				if(map[i][j] == 1)
					root[i] = root[j];
			}
		}

		// 3. 여행 하려는 나라들의 root가 모두 같다면 이어져 있는 것이다.
		int first = root[trip[0]];	// 첫 번째 나라의 root
		boolean ans = true;
		for (int i = 1; i < M; i++) {
			if(root[trip[i]] != first) {	// root가 다르다면
				ans = false;
				break;
			}
		}
		
		System.out.println(ans? "YES": "NO");
	}

	private static void make() {
		root = new int[N];
		for (int i = 0; i < N; i++) {
			root[i] = i;
		}
	}

}
