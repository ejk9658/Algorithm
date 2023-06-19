package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 보충_D4_1486_장훈이의높은선반 {

	static int N, B, S, heights[], ans;
	static List<Integer> list;
	static boolean isAdd[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			heights = new int[N];
			S = 0;	// 모든 점원들 키의 합
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				heights[i] = a;
				S += a;
			} //read
			
			// 1. 점원들 키의 합이 될 수 있는 경우를 저장한다.
			addList();
			
			// 2. B 이상인 숫자 중에서 최소값을 출력한다.
			find();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static void addList() {
		list = new ArrayList();
		list.add(0);	// 점원들 키의 합을 저장할 리스트
		
		isAdd = new boolean[S+1];	// 리스트에 저장된 정수 값을 표시
		
		for (int height : heights) {
			int n = list.size();
			for (int i = 0; i < n; i++) {
				int plus = height + list.get(i);
				if(isAdd[plus]) continue;
				isAdd[plus] = true;
				list.add(plus);
			}
		}
	}

	private static void find() {
		for (int i = B; i < S+1; i++) {
			if(isAdd[i]) {
				ans = i-B;
				return;
			}
		}
	}
}
