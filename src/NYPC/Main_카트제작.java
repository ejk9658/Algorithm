package NYPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_카트제작 {

	static class Cart{
		String type, name;
		int power;
		
		public Cart(String type, String name, int power) {
			super();
			this.type = type;
			this.name = name;
			this.power = power;
		}
	}
	static int N, M, S;
	static String[] type = {"body", "handle", "wheel", "engine", "booster"};
	static List<Cart> body = new ArrayList<>();
	static List<Cart> handle = new ArrayList<>();
	static List<Cart> wheel = new ArrayList<>();
	static List<Cart> engine = new ArrayList<>();
	static List<Cart> booster = new ArrayList<>();
	static String[][][] cart;
	static Object[][] synerzy;
	static int answer;
	static List<int[]> best = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			if(a.equals("Body")) body.add(new Cart (a,b,c));
			else if(a.equals("Handle")) handle.add(new Cart (a,b,c));
			else if(a.equals("Wheel")) wheel.add(new Cart (a,b,c));
			else if(a.equals("Engine")) engine.add(new Cart (a,b,c));
			else if(a.equals("Booster")) booster.add(new Cart (a,b,c));
		}
		M = Integer.parseInt(br.readLine());
		synerzy = new Object[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			synerzy[i][0] = a;
			synerzy[i][1] = b;
			synerzy[i][2] = c;
		}
		S = Integer.parseInt(br.readLine());
		//read

		combi(0,0);
		
		// print
		int n = best.size()-1;	// 마지막으로 들어온 게 최고 시너지의 조합이다
		for(int i=0; i<5; i++)
			System.out.println(best.get(n));
	}

	private static void combi(int start, int cnt) {
		int[] choice = new int[5];	// 5개의 종류(타입)이 있음 (body, handle 등)
		int n1 = body.size();
		int n2 = handle.size();
		int n3 = wheel.size();
		int n4 = engine.size();
		int n5 = booster.size();
		for(int a=0; a<n1; a++) {
			choice[0] = a;
			for(int b=0;b<n2; b++) {
				choice[1] = b;
				for(int c=0; c<n3; c++) {
					choice[2] = c;
					for(int d=0; d<n4; d++) {
						choice[3] = d;
						for(int e=0; e<n5; e++) {
							choice[4] = e;
							// 선택된 조합(choice)으로 시너지를 계산
							int temp = cal1(choice);
							if(Math.abs(answer-temp)<Math.abs(answer-S)) {
								best.add(choice);
								answer = temp;
								System.out.println(Arrays.toString(choice)+" "+temp);
							}
						}
					}
				}
			}
		}
		
	}

	private static int cal1(int[] arr) {
		int p1 = body.get(arr[0]).power;
		int p2 = handle.get(arr[1]).power;
		int p3 = wheel.get(arr[2]).power;
		int p4 = engine.get(arr[3]).power;
		int p5 = booster.get(arr[4]).power;
		int total = p1+p2+p3+p4+p5;
		
		String s1 = body.get(arr[0]).name;
		String s2 = handle.get(arr[1]).name;
		String s3 = wheel.get(arr[2]).name;
		String s4 = engine.get(arr[3]).name;
		String s5 = booster.get(arr[4]).name;
		
		for(int i=0; i<M; i++) {
			String a = synerzy[i][0].toString();
			String b = synerzy[i][1].toString();
			
		}
		
		return total;
	}

}
