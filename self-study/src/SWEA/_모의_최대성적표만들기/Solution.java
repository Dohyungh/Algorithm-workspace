package SWEA._모의_최대성적표만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			int answer = 0;
			for (int i = N-1; i>=N-K; i--) {
				answer += arr[i];
				
			}
			System.out.printf("#%d %d%n",tc, answer);
		}
	}

}
