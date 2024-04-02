package BOJ._11053_가장긴증가하는부분수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int answer;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		answer = 0;
		
		DP(0,0,0);
		
		System.out.println(answer);
	}
	public static void DP(int i, int max, int ans) {
		if (i >= arr.length) {
			answer = Math.max(answer, ans);
			return;
		}
		
		if (arr[i] > max) {
			DP(i+1,arr[i],ans+1);
			DP(i+1,max,ans);
		} else {
			DP(i+1,max,ans);
		}
		
	}

}
