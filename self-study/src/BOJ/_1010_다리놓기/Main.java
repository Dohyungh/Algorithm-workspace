package BOJ._1010_다리놓기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int answer;
	static int N;
	static int M;
	static int target;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
//		int[][] answer = new int [30][30];
//		for (int i = 1; i < 30; i++) {
//			answer[1][i] = i;
//		}
//		
//		for (int i = 2; i < 30; i++) {
//			for (int j = 2; j < 30; j++) {
//				if (i == j) {
//					answer[j][i] = 1;
//					continue;
//				}
//				if (j > i) continue;
//				
//				answer[j][i] = answer[j-1][i-1] + answer[j][i-1];
//			}
//		}
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			target = 1;
			N = sc.nextInt();
			M = sc.nextInt();
			
			DP(1,1,0);
//			System.out.println(answer[N][M]);
			System.out.println(answer);
		}
	}
	
	public static void DP(int i, int last, int numBuilt) {
		
		if (numBuilt == target) {
			answer++;
			System.out.println("i: " + i + " last: " + last + " numBuilt: "+numBuilt);
			return;
		}
		if (i > M || last>N) return;
		
		DP(i+1,last+1,numBuilt+1); // 지어
		DP(i+1,last,numBuilt); // 안짓고 넘어가
		DP(i,last+1,numBuilt);
		
		
		
		
		
		
		
	}

}
