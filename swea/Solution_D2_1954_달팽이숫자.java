package swea;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			
			if(N==1)
				map[0][0]=1;
			else {
				count=0;
				dfs(0,0,0);
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
		}
	}
	private static void dfs(int r, int c, int d) {
		if(visited[r][c]) return;
		visited[r][c] = true;
		map[r][c] = ++count;
		if(check(r+dr[d], c+dc[d]))
			dfs(r+dr[d], c+dc[d], d);
		else
			dfs(r+dr[(d+1)%4], c+dc[(d+1)%4], (d+1)%4);
	}
	public static boolean check(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N && map[x][y]==0;
	}
}
