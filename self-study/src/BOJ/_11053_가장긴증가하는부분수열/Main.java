package BOJ._11053_가장긴증가하는부분수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int[][] dpTable = new int[N+1][2]; // chooseL noChoose L
		
		for (int i = 1; i < N+1 ; i++) {
			dpTable[i][0] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			dpTable[i][1] = Math.max(dpTable[i-1][0], dpTable[i-1][1]);
			int max = 0;
			for (int j = i-1; j >= 1; j--) {
				if (arr[j-1] < arr[i-1]) {
					max = Math.max(dpTable[j][0], max);
				}
			}
			dpTable[i][0] = max+1;
		}
		
		
		
//			System.out.println();
//			
//			System.out.println(noChooselength);
//			System.out.println(chooseLength);
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(dpTable[i]));
//		}
		System.out.println(Math.max(dpTable[N][0], dpTable[N][1]));
		

	}


}
