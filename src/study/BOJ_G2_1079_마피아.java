package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G2_1079_마피아 {

	static int N, wrong[], R[][], eunjin, ans;
	static boolean isDead[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wrong = new int[N];		// wrong[] : 유죄 지수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			wrong[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		eunjin = Integer.parseInt(br.readLine()); //read
		
		isDead = new boolean[N];	// dead : 죽은 사람인지 표시
		
		if(N%2==0) {
			goNight(0);	// 참가자가 짝수 명 남았을 때는 밤이다.
		} else {
			goDay(0);	// 참가자가 홀수 명 남았을 때는 낮이다.
		}
		
		System.out.println(ans);
	}

	private static void goNight(int time) {
		if(check(time)) {	// eunjin이 죽었는지 체크한다.
			
			
		}
		for (int i = 0; i < R.length; i++) {
			
		}
	}

	private static void goDay(int time) {
		if(check(time)) {
			
		}
		for (int i = 0; i < R.length; i++) {
		}
		
	}

	private static boolean check(int time) {
		if(isDead[eunjin]) {
			ans = Math.max(ans, time);
		}
		return true;
	}
}
