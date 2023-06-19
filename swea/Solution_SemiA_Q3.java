package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 분류: 시뮬레이션
public class Solution_SemiA_Q3 {
	static int[] asc, desc; // 오름차순, 내림차순 정렬 후의 상태가 저장되는 배열.
	static int n, totalMin; // n: 카드 장 수, totalMin: 이전까지 구한 셔플 횟수의 최소값

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			int[] deck = new int[n]; // 현재 카드들의 상태가 저장된 함수.
			asc = new int[n]; // 오름차순 카드덱에 배열 할당
			desc = new int[n]; // 내림차순 카드덱에 배열 할당
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				deck[i] = Integer.parseInt(st.nextToken());
				asc[i] = i + 1; // 오름차순 정렬된 카드덱의 i(0..n-1)번째에는 i+1(1..n)의 카드가 와야 하므로 그 값을 저장해준다.
				desc[i] = n - i; // 내림차순 정렬된 카드덱의 i(n-1..0)번째에는 i+1(n..1)의 카드가 와야 하므로 그 값을 저장해준다.
			}
			totalMin = 6; // 최대 셔플 횟수가 5회를 넘으면 실패라 했으므로 셔플 회수의 최소값을 6으로 한다.

			shuffle(deck, 0);
			sb.append("#" + t + " " + (totalMin == 6 ? -1 : totalMin) + "\n");
			/*
			 * Line 30의 코드는 아래 3줄과 같은 의미이다. 
			 * int ans = totalMin; 
			 * if(ans == 6) ans = -1;
			 * sb.append("#" + t + " " + ans + "\n");
			 */
		}
		System.out.print(sb.toString());
	}

	private static void shuffle(int[] deck, int depth) {
		if (hasSorted(deck)) // 만약 정렬이 된 상태라면 재귀호출 한 횟수를 최소 셔플횟수에 저장한다.
			totalMin = depth;
		if (depth == 5 || totalMin <= depth) // 만약 아직 정렬이 되지 않았는데도 depth가 5이거나 현재 가지의 셔플 횟수가 최소 셔플 회수 이상인 경우 가지치기 한다.
			return;
		for (int x = 1; x < n; x++) { // x=1부터 n-1까지 연속해서 바꿔가며 백트래킹 탐색한다.
			// 셔플의 시작 위치를 보면 x=1,2,3,..,n 일 때 (n/2)-1,(n/2)-2,..,1,0,1,..,(n/2)-2,(n/2)-1 이므로 
			// 이 규칙은 |n/2-x|라고 볼 수 있다.
			// 따라서 아래와 같이 시작 위치를 잡을 수 있다.
			int start = Math.abs(n / 2 - x);
			
			// 셔플의 끝 위치는 x=1,2,3,..,n일 때 (n/2)+1, (n/2)+2, .. n-2,n-1,n-2,..,(n/2)+2,(n/2)+1이다.
			// 이 때 시작점에서부터 인접한 2개씩 바꿔가며 swap을 해야 하므로
			// Line 56~57과 같이 값을 교환하면 문제에서 요구한 x일때의 상태가 나오게 된다.
			// 이해가 되지 않는다면 연습장에 직접 n의 값을 지정하고 x와 j 값을 하나씩 증가시켜가며 값의 변경 추이를 tracking 해보길 바란다.
			for (int j = 0; (start + j) * 2 < n; j++)
				swap(deck, start + 2 * j, start + 2 * j + 1);
			shuffle(deck.clone(), depth + 1); // 재귀호출하여 다음 깊이로 들어간다.
		}
	}

	// i와 j번쨰 위치의 배열의 원소 값을 바꾼다.
	private static void swap(int[] deck, int i, int j) {
		int tmp = deck[i];
		deck[i] = deck[j];
		deck[j] = tmp;
	}

	// hasSorted: 이미 정렬 된 상태의 카드 덱과 각 인덱스의 값을 비교하여 정렬됐는지 여부를 탐색한다.
	// deck: 정렬 됐는지 여부를 검사하려는 카드 덱
	// 반환값: 오름차순이던 내림차순이던 정렬 되었다면 true를, 아니라면 false를 반환한다.
	private static boolean hasSorted(int[] deck) {
		boolean isASC = true, isDESC = true; // isASC= 오름차순 정렬 여부, isDESC=내림차순 정렬 여부
		for (int i = 0; i < n && (isASC || isDESC); i++) { // isASC와 isDESC가 모두 false가 되는 경우 반복문 탈출하기 위해 && 로 추가 조건 붙임.
			// 속도를 조금이라도 더 빠르게 하기 위해 || 연산자를 썼을 뿐, | 연산자를 써도 무방하다. 
			if (isASC && asc[i] != deck[i]) // 오름차순 정렬된 배열과 값이 현재 위치의 값이 일치하지 않으면 deck이 오름차순 정렬된 것이 아니므로 isASC 값을 false로 바꾼다.
				isASC = false;
			if (isDESC && desc[i] != deck[i]) // 내림차순 정렬된 배열과 현재 위치의 값이 일치하지 않으면 deck이 내림차순 정렬된 것이 아니므로 isDESC 값을 false로 바꾼다.
				isDESC = false;
		}
		return isASC || isDESC; // 둘 중 어느쪽이라도 정렬되었는지 여부를 반환한다.
	}
}
