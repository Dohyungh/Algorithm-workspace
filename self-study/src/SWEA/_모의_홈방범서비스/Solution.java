package SWEA._모의_홈방범서비스;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int final_answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			final_answer = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean[][] map = new boolean[3*N][3*N];
			
			for (int i = N; i <=2*N-1; i++) {
				for (int j = N; j <=2*N-1; j++) {
					int num = sc.nextInt();
					if (num==1) {
						map[i][j] = true;
					}
				}
			}
			
//			for (int i =0; i <= map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			for (int i = N; i <=2*N-1; i++) {
				for (int j = N; j <=2*N-1; j++) {
					for (int k = 1; k <=N+1; k++) {
						getAnswer(map,i,j,k,M);
					}
				}
			}
			System.out.printf("#%d %d%n", tc, final_answer);
			
		}
		
	}

	private static void getAnswer(boolean[][] map, int i, int j, int k, int M) {
		int cnt = 0;
		int sum = 0;
		int left = j;
		int right = j;
		int r = i-(k-1);
		while(r <= i+(k-1)) {
			for (int a = left; a <=right; a++) {
				if (map[r][a]) {
					sum+= M;
					cnt++;
				}
			}
			if (r >= i) {
				left++;
				right--;
			}
			else {
				left--;
				right++;
			}
			r++;
		}
		
		if (sum >= k * k + (k - 1) * (k - 1)) {
			
			final_answer = Math.max(cnt, final_answer);
		}
		
		
	}

}
