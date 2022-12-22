package practice_ssafy;

public class PG_LV2_Greedy_조이스틱 {
	public static void main(String[] args) {   // main 함수 테스트 케이스 2번
		//System.out.println(solution("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		String input = "CAAACAACA";
		System.out.println(input);
		System.out.println(solution(input));
	}
	static int answer;
    static class Range {
	    int start, leng;
	
	    public Range(int start, int leng) {
	    	this.start = start;   // 구간이 시작되는 인덱스
	    	this.leng = leng;   // 구간의 길이
	    }
	}
    
    public static int solution(String name) {
    	answer = 0;   // 출력할 결과 값 : 조이스틱을 몇 번 움직이는지
		char Name[] = name.toCharArray();   // 입력된 문자열 'name'을 char형 일차원 배열에 저장한다. 
		updown(Name);   // 조이스틱을 위,아래로 움직이는 횟수를 count
		System.out.println(answer+" : 위 아래 움직");
		leftright(Name);   // 조이스틱을 왼쪽,오른쪽으로 움직이는 횟수를 count
        return answer;
    }
    private static void updown(char[] Name) {
    	for (char c : Name) {
    		answer += Math.min(c-'A', 26-c+'A');   // A~Z는 총 26개이다.
    	}
    }

    private static void leftright(char[] Name) {
    	// 1. 'A'가 연속적으로 가장 많이 등장하는 구간을 찾고, 그 구간을 'A구간'이라 한다.
    	Range A = findA(Name);
    	if(A.start == -1) {   // A가 하나도 없는 경우
    		answer += Name.length-1;
    		return;
    	}
    	
    	// 2. 'A구간'을 기준으로 왼쪽 문자열을 'L구간'이라 하고, 오른쪽 문자열을 'R구간'이라 한다.
    	Range L = new Range(0, A.start);
        Range R = new Range(A.start+A.leng, Name.length-(A.start+A.leng));
        
        // 3. 한 방향(오른쪽 또는 왼쪽)으로만 이동하는 경우와,
        // 'A구간'을 기준으로 왔다갔다 이동하는 경우를 고려한다.
        
        
        
        
        
        // 3. 'A구간', 'L구간', 'R구간'의 길이를 비교하면서 어느 방형으로 조이스틱을 움직일지 결정한다.
        
//        System.out.println(A.leng+", "+L.leng+", "+R.leng);
//        // 3-1. 'L구간' 길이가 'A구간' 길이보다 작으면 한 방향(오른쪽 또는 왼쪽)으로만 이동한다.
//        if(L.leng < A.leng) {
//        	answer += goOneDirect(Name, L, R);
//        }
//        
//        if(A.leng > L.leng || A.leng > R.leng) {
//        	if(L.leng <= R.leng) {
//        		
//        	} else {
//        		
//        	}
//        }
    }

	private static int goOneDirect(char[] Name, Range L, Range R) {
		// 오른쪽 방향으로 움직일 때
		int cntR = Name.length-1;
		for (int i = Name.length-1; i >= R.start; i--) {
			if(Name[i] == 'A') cntR--;
			else break;
		}
		
		// 왼쪽 방향으로 움직일 때
		int cntL = Name.length-1;
		for (int i = 1; i < L.leng; i++) {
			if(Name[i] == 'A') cntL--;
			else break;
		}
		System.out.println(cntR+" "+cntL);
		return Math.min(cntR, cntL);
	}
	private static Range findA(char[] Name) {
    	Range A = new Range(-1,0);
        int maxCnt = 0;
        for (int i = 0, n = Name.length; i < n; i++) {
        	if(Name[i] == 'A') {
        		int temp = i;   // A.start
        		int cnt = 0;   // A.leng
        		while(i<n && Name[i++]=='A') cnt++;   // A가 연속적으로 몇 번 나오는지 확인
        		i--;

        		if(maxCnt < cnt) {   // A가 연속적으로 가장 많이 등장한 경우
        			A.start = temp;
        			A.leng = cnt;
        			maxCnt = cnt;
        		}
        	}
        }
        return A;
    }
}