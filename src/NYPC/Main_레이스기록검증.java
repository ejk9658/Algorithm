package NYPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_레이스기록검증 {

	static int N, M;
	static int[][] log;
	static int[] user;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		log = new int[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				log[i][j] = Integer.parseInt(st.nextToken());
		} //read
		
		// User 정보 배열 생성
		user = new int[N+1];	// ID가 1부터 시작. User의 게임 시작 시간을 넣을 것임.
		Arrays.fill(user, -1);
		
		if(log())	// log분석
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	private static boolean log() {
		
		if(M%2==1) return false;	// 로그의 정보가 홀수개인 경우 (Wrong!)
		
		for(int i=0; i<M; i++) {
			int id = log[i][1];
			if(user[id]==-1) {	// 사용자 정보가 비어있다면 추가(game start)
				if(log[i][2]==1) return false;	// 시작하지 않은 사용자가 게임을 종료한 경우 (Wrong!)
				user[id] = log[i][0];
			} else {
				if(log[i][2]==0) return false;	// 시작한 사용자가 게임을 시작한 경우 (Wrong!)
				if(log[i][0]-user[id]<60) return false;	// 게임 시간이 60초 미만인 경우 (Wrong!)
				user[id]=-1;	// 게임이 종료됐으니 다시 비워줌
			}
		}
		
		for(int i=1; i<N; i++) {
			if(user[i]!=-1) return false;	// 게임이 종료되지 않은 사용자가 있는 경우 (Wrong!)
		}
		
		return true;
	}
}
