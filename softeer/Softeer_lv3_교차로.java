package softeer;

import java.util.*;
import java.io.*;

public class Softeer_lv3_교차로 {

	static class Car implements Comparable<Car>{
		int idx, time;
		char road;
		Car(int idx, int time, char road) {
			this.idx = idx;
			this.time = time;
			this.road = road;
		}
		public int compareTo(Car o) {
			return this.time==o.time?this.idx-o.idx:this.time-o.time;
		}
	}
	static int N, currentTime, answer[];
	static PriorityQueue<Car> pq;
	static Queue<Integer> A, B, C, D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		Arrays.fill(answer, -2);
		pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Car(i, Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		} //read

		A = new LinkedList<>();
		B = new LinkedList<>();
		C = new LinkedList<>();
		D = new LinkedList<>();
		while(!pq.isEmpty() || notEmpty()) {
			if(!pq.isEmpty() && !notEmpty()) {	// 도로에 진입할 차가 있고, 현재 도로에 차가 없는 경우
				currentTime = pq.peek().time;
				in();
			} else if(pq.isEmpty() && notEmpty()) {	// 도로에 진입할 차가 없고, 현재 도로에 차들이 있는 경우
				while(notEmpty()) {
					out();
					currentTime++;
				}
			} else {
				if(!pq.isEmpty() && pq.peek().time==currentTime) in();
				if(notEmpty()) out();
				currentTime++;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(answer[i]);
		}
	}
	static void in() {
		while(!pq.isEmpty()) {
			if(pq.peek().time != currentTime) break;
			inCar(pq.poll());
		}
	}
	static void inCar(Car car) {
		if(car.road == 'A') {
			A.offer(car.idx);
		} else if(car.road == 'B') {
			B.offer(car.idx);
		} else if(car.road == 'C') {
			C.offer(car.idx);
		} else if(car.road == 'D') {
			D.offer(car.idx);
		}
	}
	static void out() {
		// 교착상태인 경우
		if(!A.isEmpty() && !B.isEmpty() && !C.isEmpty() && !D.isEmpty()) {
			while(!pq.isEmpty()) {
				inCar(pq.poll());
			}
			noway(A);
			noway(B);
			noway(C);
			noway(D);
			return;
		}
		// 교착상태가 아닌 경우
		// 비어있는 큐를 확인한다.
		int lenA = A.size();
		int lenB = B.size();
		int lenC = C.size();
		int lenD = D.size();
		if(lenA==0 && lenB>0) outCar(B);
		if(lenB==0 && lenC>0) outCar(C);
		if(lenC==0 && lenD>0) outCar(D);
		if(lenD==0 && lenA>0) outCar(A);
	}
	static void outCar(Queue que) {
		answer[(int)que.poll()] = currentTime;
	}
	static void noway(Queue que) {
		while(!que.isEmpty()) {
			answer[(int)que.poll()] = -1;
		}
	}
	static boolean notEmpty() {
		return !A.isEmpty() || !B.isEmpty() || !C.isEmpty() || !D.isEmpty();
	}

}
