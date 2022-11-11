package swea;

import java.io.*;
import java.util.*;

// 문제 분류: 완전탐색&백트래킹
public class Solution_SemiA_Q2 {
	static int totalMin; // 이전까지 구한 이동 비용의 최소값
	static boolean[] house, monster; // 각각의 번호에 해당하는 고객/몬스터를 방문/처치했는지 여부를 저장하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()); // 정방행렬의 크기
			ArrayList<Point> points = new ArrayList<>(); // 몬스터와 고객의 좌표정보가 저장되는 리스트
			totalMin = Integer.MAX_VALUE / 100; // 전체 최소 비용 변수의 값을을 도달 불가능한 큰 값으로 초기화한다.
			
			// 각 행과 열에 대해 입력을 받는다.
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp != 0) // 그 위치에 몬스터 또는 고객이 있는 경우 리스트에 그 정보(행 좌표, 열 좌표, 몬스터/고객 번호)를 넣는다.
						points.add(new Point(i, j, tmp));
				}
			}
			// 문제 조건에 고객과 몬스터의 번호는 최대 4까지만 존재할 수 있다 했으므로 size=4이고,
			// 고객번호, 몬스터 번호의 방문 인덱스를 1부터 시작하기 위해 size+1, 즉 5로 생성함.
			house = new boolean[5];
			monster = new boolean[5];

			Collections.sort(points); // 각 점들에 대한 정보를 번호의 절대값이 작은 순서대로 정렬하고 만약 절대값이 같다면 몬스터가 우선 정렬되도록 한다.
			dfs(points, new Point(0, 0, 0), 0, 0);
			sb.append("#"+t+" "+totalMin+"\n");
		}
		System.out.print(sb.toString());
	}

	// 완전탐색+백트래킹 방식으로 최소 비용을 구하는 함수.
	// points: 몬스터와 고객의 위치 정보가 저장된 리스트
	// hunter: 현재 헌터의 위치.
	// depth: 방문/처치한 고객/몬스터 의 총합
	// sum: 현재까지의 비용
	private static void dfs(ArrayList<Point> points, Point hunter, int depth, int sum) {
		if (depth == points.size()) { // 만약 모든 정점들을 방문했다면
			totalMin = sum; // 최소 비용을 업데이트한다.
			// dfs()를 재귀호출 하기 전 다음에 방문할 비용이 이전까지 구한 최소 비용보다 작은지 여부를 검사했으므로 최소 비용임이 보장된다.
			return;
		}
		for (Point tmp : points) { // tmp: 이동하려고 하는 좌표
			int nextSum = sum + getDistance(hunter, tmp); // 이동하려고 하는 좌표까지의 거리를 구하고 현재 단계의 sum과 더한다.
			if (tmp.kind < 0 && !house[-tmp.kind]) { // 만약 이동하려고 하는 위치에 고객이 있고, 방문한 적이 없다면
				if (monster[-tmp.kind] && nextSum < totalMin) { 
					// ↑ 그 고객이 처치를 의뢰한 몬스터가 잡힌 상태이고 현재까지 구한 최소 비용보다 작아야 이동의 의미가 있으므로 그 여부를 검사한다.
					// 만약 Line 56의 조건을 만족하면 그 고객을 방문할 자격이 생겼으므로 그 고객에게 이동한다.
					house[-tmp.kind] = true; // 다음 지점에 있는 그 고객을 방문했다고 표시한다.
					dfs(points, tmp, depth + 1, nextSum); // 이동한 좌표에 대해 추가적으로 백트래킹(dfs)하기 위해 재귀호출 한다.
					/* --- Line 60의 hunter 위치에 tmp를 넣는 것에 대한 부가 설명 ---
					 * 우리가 중요한 것은 현재 hunter의 좌표이기 때문에 hunter에 들어가는 Point의 kind 정보는 어떤 값이던 상관이 없다.
					 * 다시 말해, hunter 좌표의 kind 값이 몬스터 번호를 가지던, 고객 번호를 가지던 
					 * 좌표 정보만을 꺼내 다음 탐색 시도 지점과의 거리 계산만 필요하므로 tmp를 그대로 hunter의 자리에 넣어도 상관 없다.
					 */
					house[-tmp.kind] = false; // 백트래킹 해야하므로 다시 방문하지 않은 것으로 바꿔준다.
				}
			} else if (tmp.kind > 0 && !monster[tmp.kind]) { // 만약 이동하려고 하는 위치에 몬스터가 있고, 방문한 적이 없다면
				if (nextSum < totalMin) { // 그 지점에 이동한 후의 거리가 현재까지의 최소비용보다 작을 때만 이동하는 것에 의미가 있으므로 그 여부를 검사한다.
					monster[tmp.kind] = true; // 이동하려고 하는 좌표에 있는 몬스터를 처치했다고 표시한다.
					dfs(points, tmp, depth + 1, nextSum); // 이동한 좌표에 대해 추가적으로 백트래킹(dfs)하기 위해 재귀호출 한다.
					monster[tmp.kind] = false; // 백트래킹 해야하므로 다시 처치하지 않은 것으로 바꿔준다.
				}
			}
		}
	}

	// 맨하탄 거리 구하는 함수
	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}

	// 고객, 몬스터, 헌터가 공통적으로 사용하는 좌표 class.
	static class Point implements Comparable<Point> {
		int r, c, kind;

		public Point(int r, int c, int kind) {
			this.r = r; // 행 좌표
			this.c = c; // 열 좌표
			this.kind = kind; // 몬스터 번호 또는 고객 번호 또는 헌터 번호
		}

		@Override
		// 몬스터 번호와 고객 번호가 낮은 순서로 저장하고, 만약 몬스터 번호와 고객 번호가 같은 경우 몬스터가 우선적으로 올 수 있게 한다.
		public int compareTo(Point o) {
			return Math.abs(this.kind) != Math.abs(o.kind) ? Math.abs(this.kind) - Math.abs(o.kind)
					: this.kind - o.kind;
		}
	}
}
