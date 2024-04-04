package BOJ._2579_계단오르기;

import java.util.Scanner;

public class Main {
	static int[] dT;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		
		dT = new int[N+1];
		dT[N] = arr[N];
		
		// 다영이꺼에 점화식 있어유
		// 점화식의 만족 범위에 주의
		// 계단을 안밟아버려유 막
		
		for (int i = N-1; i>=0; i--) {
			DP(i,i+1,arr[i],1);
			DP(i,i+2,arr[i],2);
		}
		
		if (N ==1) System.out.println(dT[1]); // 무쟈게 까다롭구만
		else {
			System.out.println(Math.max(dT[1], dT[2]));			
		}
	}
	private static void DP(int start, int i, int score, int steps) {
		if (i > N) return;
		
		if (i == N) { // 아주 까다롭구만
			dT[start] = Math.max(dT[start], score+arr[i]);
			return;
		}
		
		if (dT[i] != 0 && steps==2) { // 까다롭구만
			dT[start] = Math.max(dT[start], score+dT[i]);
			return;
		}
		
		
		if (steps == 1) {
			DP(start, i+2, score+arr[i], 2);
		} else {
			DP(start, i+1, score+arr[i], 1);
			DP(start, i+2, score+arr[i], 2);
		}
		
		
	}

}
