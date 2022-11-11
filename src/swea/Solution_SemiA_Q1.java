package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 분류: 시뮬레이션
public class Solution_SemiA_Q1 {
	static int totalMin, n; // totalMin: 이전까지 구한 최소 비용이 저장되는 변수, n: 낚시터의 개수
	static int door[][]; // 각 게이트별 정보 [게이트 번호][0번째 원소: 게이트 좌표, 1번쨰 원소: 사람 수]가 2차원 배열 형태로 저장되는 변수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력받음.
		StringBuilder sb = new StringBuilder(); // 최종 출력문이 저장되는 StringBuilder.
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine()); // 낚시터의 개수 입력받음.
			totalMin = Integer.MAX_VALUE / 100;
			door = new int[3][2]; // 게이트 정보 변수 초기화.
			for (int i = 0; i < 3; i++) { // i= 0..2, 각 게이트별 정보를 입력받음.
				StringTokenizer st = new StringTokenizer(br.readLine());
				door[i][0] = Integer.parseInt(st.nextToken()) - 1; // i번 게이트의 좌표. 낚시터 좌표의 시작 index를 0으로 했기 때문에 1을 빼준다.
				door[i][1] = Integer.parseInt(st.nextToken()); // i번 게이트로 입장하는 사람의 수.
			}
			int[] p = { 0, 1, 2 }; // 게이트의 입장 순서. 문제의 조건에 게이트는 항상 3개라 했으므로 이렇게 때려박아도 된다.
			do {
				seat(new boolean[n], p, 0, 0); // nextPermutation으로 정한 입장 순서대로 입장 비용을 구한다.
			} while (np(p));
			sb.append("#" + t + " " + totalMin + "\n");
		}
		System.out.print(sb.toString());
	}

	// 백트래킹(=DFS) 방식으로 최소값을 구한다.
	// visited: 각 좌석이 사용되고 있는지 여부
	// p: 게이트의 입장 순서
	// depth: 입장이 완료된 게이트의 수
	// sum: 현재 단계에 오기까지의 입장 거리비용
	private static void seat(boolean[] visited, int[] p, int depth, int sum) {
		if (sum > totalMin) // 만약 DFS에서 지금 단계까지의 입장 거리비용이 이전까지 구한 최소값보다 큰 경우, 더 이상 탐색의 의미가 없으므로 가지치기한다.
			return;
		if (depth == 3) { // 만약 3개의 게이트가 모두 입장을 완료했으면
			totalMin = sum; // 지금 단계까지의 입장 거리비용을 최소 비용 변수에 저장한다. 
			//(Line 40~41 에서 다음 방문할 비용이 totalMin보다 작은지 검사했기 때문에 최소값이 보장된다.)
			return;
		}

		int startPos = door[p[depth]][0]; // 해당 게이트의 바로 앞 낚시터를 빈 낚시터 자리 탐색 공간의 시작점으로 한다.
		int left = startPos, right = startPos; // 게이트의 왼쪽 방향 낚시터
		int curSum = sum; // 현재 게이트의 사람들을 모두 입장시킨 후의 비용이 저장되는 변수.

		// 해당 게이트의 사람들(door[p[depth]][1])을 한 사람씩 입장 시킨다.
		/* ----door[p[depth]][1]의 의미---- 
		 * p[depth]: depth번째 입장하는 게이트의 번호. door[i][1]: i번째
		 * 게이트를 통해 입장하는 사람의 수
		 */
		for (int i = 0; i < door[p[depth]][1]; i++) {
			while (left >= 0 && visited[left]) // 현재 게이트 좌표 기준 가장 가까운 왼쪽 방향의 빈 낚시터의 좌표를 찾는다.
				left--;
			while (right < n && visited[right]) // 현재 게이트 좌표 기준 가장 가까운 오른쪽 방향 빈 낚시터의 좌표를 찾는다.
				right++;

			// 왼쪽방향, 오른쪽 방향의 빈 낚시터까지의 이동 비용을 구한다. 
			// (게이트 바로 앞 좌표라 하더라도 이동비용이 1m라 했으므로 1을 더해준다.)
			// 만약 위에서 구한 left나 right 값이 유효한 낚시터 좌표의 범위가 아닌 경우, 그 방향으로는 빈 낚시터가 없는 것이므로 
			// 절대 도달 불가능한 큰 값을 거리 비용으로 삼는다.
			int leftDist = left >= 0 ? Math.abs(left - startPos) + 1 : Integer.MAX_VALUE;
			int rightDist = right < n ? Math.abs(right - startPos) + 1 : Integer.MAX_VALUE;

			// 만약 남은 입장 인원이 1명인 경우 다음 게이트를 입장시키기 위해 재귀호출을 해야 한다. 
			if (i == door[p[depth]][1] - 1) {
				// 왼쪽 방향과 오른쪽 방향의 이동 거리비용이 같은 경우, 왼쪽과 오른쪽 각각에 대해 거리비용을 계산해야 하므로 재귀를 2번 호출해야 한다.
				if (leftDist == rightDist) {
					// 마지막 사람을 왼쪽 방향 앉히는 경우에 대한 거리 비용 계산.
					curSum += leftDist;
					visited[left] = true;
					seat(visited.clone(), p, depth + 1, curSum); 
					// Line 77: clone 방식으로 넘겨주는 이유는 backtracking시 각 게이트별 인원에 따라 visited 함수를 복윈하는 것이 사실상 어렵기 때문에
					// 내용물은 같지만 hashCode가 다른 객체로 만들어 되돌아가더라도 이전 상태가 쉽게 복원되게 하기 위해 이 방식으로 사용한다.
					visited[left] = false;
					
					// 마지막 사람을 오른쪽 방향에 앉히는 경우에 대한 거리 비용 계산.
					visited[right] = true;
					seat(visited.clone(), p, depth + 1, curSum);
					// 현재 단계에서의 탐색은 끝났으므로 굳이 visited[right]를 false로 바꿔줄 필요는 없다.
				} 
				// 왼쪽 방향과 오른쪽 방향의 이동 거리 비용이 다른 경우에는 기존처럼 방향에 관계 없이 가장 가까운 위치에 앉히고
				// 다음 게이트의 입장을 위해 함수를 재귀호출한다.
				else {
					if (leftDist < rightDist) {
						curSum += leftDist;
						visited[left] = true;
					} else {
						curSum += rightDist;
						visited[right] = true;
					}
					seat(visited.clone(), p, depth + 1, curSum);
				}
				break;
			}
			// 만약 남은 입장 인원이 1명보다 많은 경우 왼쪽 오른쪽 여부 관계 없이 가장 가까운 위치에 앉히면 된다.
			if (leftDist < rightDist) {
				curSum += leftDist;
				visited[left] = true;
			} else {
				curSum += rightDist;
				visited[right] = true;
			}
		}
	}

	// NextPermutation.
	// 문제의 조건에서 게이트의 개수는 항상 3개라 했으므로 n=3으로 고정되고,
	// size=n-1이기 때문에 2로 고정된다.
	private static boolean np(int[] p) {
		int i = 2, j = 2, k = 2;
		while (i > 0 && p[i - 1] > p[i])
			i--;
		if (i == 0)
			return false;
		while (p[i - 1] > p[j])
			j--;
		swap(p, i - 1, j);
		/* ---- Line 123에 대한 부가 설명 ----
		 * 함수에서 매개변수를 받을 때 배열의 경우 얕은복사(shallow copy)가 일어나므로, 
		 * 매개변수 배열로 받아 바꿔주더라도 실제 외부의 배열의 값이 바뀌기 때문에 
		 * 1ms라도 실행 시간을 줄이고 싶다면 [전역변수+static 배열] 개념이 아니라 [지역변수+매개변수 배열] 개념을 적용하는 것이 속도적으로 유리하다. 
		 * 하지만 A형 코딩테스트에서는 굳이 이렇게까지 시간을 극단적으로 줄여야 하는 문제는 안나올것이므로.. 본인이 편한대로 짭시다.
		 */
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	// 배열 안의 값을 바꿔주기 위한 함수.
	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
