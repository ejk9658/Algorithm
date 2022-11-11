package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SSAFY_연습문제1_낚시터자리잡기 {

	static int N, ans;
	static int gate[][];
	static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			gate = new int[3][N];
			for(int i=0; i<3; i++) {
				st = new StringTokenizer(br.readLine());
				gate[i][0] = Integer.parseInt(st.nextToken())-1;	// gate 위치
				gate[i][1] = Integer.parseInt(st.nextToken());	// gate에 대기하는 사람 수
			} //read
			
			ans=Integer.MAX_VALUE;
			// 1. 3개의 gate 입장순서 정하기
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					if(i!=j)
						for(int k=0; k<3; k++)
							if(i!=k && j!=k)
								// 2. 입장 시작
								open(i,j,k);
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void open(int gate1, int gate2, int gate3) {
		// 아직 낚시꾼이 한 명도 안 들어온 상태
		visited = new boolean[N];
		int tot = 0;
		
		// 3. 입장
		int[] gArr = new int[] {gate1, gate2, gate3};
		bfs(gArr, 0, tot);
	}

	private static void bfs(int[] gArr, int idx, int tot) {
		if(ans<tot) return;
		if(idx==3) {
			// 최소 횟수 계산 : 위에서 ans<tot return조건으로 걸어두어서 tot이 언제나 최소값이라는 것을 보장한다.
			ans=tot;
			return;
		}
		
		int gateNum = gate[gArr[idx]][0];
		int peopleCnt = gate[gArr[idx]][1];
		
		// 처음 자리가 비어있다면 넣기
		if(!visited[gateNum]) {
			visited[gateNum] = true;
			tot+=1;
			peopleCnt--;
		}
		
		int left = gateNum;
		int right = gateNum;
		for(int i=0; i<peopleCnt-1; i++) {
			
			while(left>=0 && visited[left]) left--;
			while(right<N && visited[right]) right++;
			
			if(gateNum-left < right-gateNum || right==N) {	// 왼쪽이 더 가까운 경우
				visited[left] = true;
				tot+=(gateNum-left+1);
			} else {	// 오른쪽이 더 가깝거나 같은 경우
				visited[right] = true;
				tot+=(right-gateNum+1);
			}
		}
		
		// 마지막 낚시꾼이 갈 수 있는 경우는 1가지 또는 2가지가 있다
		int[] arr = new int[2];
		for(int i=1; i<N; i++) {
			if(gateNum+i<N)
				if(!visited[gateNum+i]) {
					visited[gateNum+i]=true;
					arr[0] = i+1;
					bfs(gArr, idx+1, tot+arr[0]);
					visited[gateNum+i]=false;
				}
			if(gateNum-i>=0)
				if(!visited[gateNum-i]) {
					visited[gateNum-i]=true;
					arr[1] = i+1;
					bfs(gArr, idx+1, tot+arr[1]);
					visited[gateNum-i]=false;
				}
			if(arr[0]!=0 || arr[1]!=0) break;
		}
	}

	private static boolean check(int i) {
		return i>=0 && i<N;
	}

}
