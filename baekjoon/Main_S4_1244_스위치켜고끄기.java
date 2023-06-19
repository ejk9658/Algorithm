package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1244_스위치켜고끄기 {
	
	static int swN;
	static int[] sw;
	static int N;	// 학생 수
	static int num;	// 학생이 받은 숫자

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		swN = Integer.parseInt(br.readLine());
		sw = new int[swN];		// 스위치 개수를 받은 후 스위치 배열 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<swN; i++)
			sw[i] = Integer.parseInt(st.nextToken());	// 스위치 배열 저장
		
		N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1:		// 남학생이라면
				num = Integer.parseInt(st.nextToken());
				for(int i=num-1; i<swN; i+=num)
					sw[i] = (sw[i]+1)%2;	// change
				break;
			case 2:		// 여학생이라면
				num = Integer.parseInt(st.nextToken())-1;	// 배열 index 특성상 -1함
				int lCnt = num;
				int rCnt = num;
				while( (lCnt-1)>=0 && (rCnt+1)<swN ) {	// 좌우 대칭되는 스위치 개수찾기
					if(sw[lCnt-1] != sw[rCnt+1]) break;
					lCnt--;
					rCnt++;
				}
				for(int i=lCnt; i<=rCnt; i++)
					sw[i] = (sw[i]+1)%2;	// change
			}
		}

		for(int i=0; i<swN; i++) {		// 출력
			System.out.print(sw[i]);
			if((i+1)%20==0)
				System.out.println();
			else if(i!=swN-1)
				System.out.print(" ");
		}

	}

}
