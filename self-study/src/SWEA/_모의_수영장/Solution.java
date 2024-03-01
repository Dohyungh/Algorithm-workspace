package SWEA._모의_수영장;

import java.util.Scanner;

public class Solution {
	
	static int final_answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int[] price = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()}; //ㅋㅋ
			final_answer = price[3];
			
			int[] arr = new int[12];
			
			for (int i = 0; i < 12; i++) arr[i] = sc.nextInt();
			
			int[] plan = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
			
			DP(arr, price, 0, plan);
			
			System.out.printf("#%d %d%n",tc,final_answer);

		}
		
		sc.close();
		
		
		
		
		
		
	}
	
	public static void DP(int[] arr, int[] price, int index, int[] plan) {
		if (index >= arr.length) {
			
			int answer = 0;
			for(int i = 0; i< plan.length; i++) {
				if (plan[i]==2) {
					i += 2;
					answer += price[2];
					continue;
				}
				if (plan[i]==1) {
					answer += price[1];
				}
				if (plan[i]==0) {
					answer +=arr[i]*price[0];
				}
			}
			final_answer = Math.min(final_answer, answer);
			return;
		}
		if (arr[index]!=0) {
			plan[index] = 2;
			DP(arr,price,index+3,plan);
			plan[index] = 1;
			DP(arr,price,index+1,plan);
			plan[index] = 0;
			DP(arr,price,index+1,plan);
		} else DP(arr,price,index+1,plan);
		
		
	}

}
