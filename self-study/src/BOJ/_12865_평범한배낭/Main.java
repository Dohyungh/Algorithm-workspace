package BOJ._12865_평범한배낭;

import java.util.Scanner;

public class Main {
	
	static int maxValue = 0;
	static int N;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[][] items = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		DP(0, items, 0, 0);
		
		System.out.println(maxValue);
	}
	private static void DP(int i, int[][] items, int weight, int value) {
		
		if (weight > K) return;
		
		maxValue = Math.max(maxValue, value);
		
		if (i >= N) return;
		DP(i+1, items, weight+items[i][0], value+items[i][1]);
		DP(i+1, items, weight, value);
		
	}

}
