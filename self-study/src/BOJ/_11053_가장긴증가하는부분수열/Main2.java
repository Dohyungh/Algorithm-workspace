package BOJ._11053_가장긴증가하는부분수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		int[][] dpTable = new int[N+1][4]; // chooseL chooseV noChooseL noChooseV
		
		for (int i = 1; i< N+1; i++) {
			dpTable[i][0] = 1;
			dpTable[i][1] = arr[i-1];
		}
		
		
		dpTable[1][1] = arr[0];
		
		for (int i = 2; i <= N; i++) {
			int noChooselength = 0;
			int noChooseval = 0;
			int chooseLength = 0;
			int chooseVal = 0;
			
			for (int j = i-1; j>=0; j--) {
				if (dpTable[j][1] < arr[i-1]) {
					chooseLength = dpTable[j][0]+1;
					chooseVal = arr[i-1];
					break;
					
				}
			}
			for (int j = i-1; j>=0; j--) {
				if (dpTable[j][1] > arr[i-1]) {
					noChooselength = dpTable[j][0];
					noChooseval = dpTable[j][1];
					break;
				}
				
					
			}
//			System.out.println();
//			
//			System.out.println(noChooselength);
//			System.out.println(chooseLength);
			if (noChooselength > chooseLength) {
				dpTable[i][0] = noChooselength;
				dpTable[i][1] = noChooseval;
			} else {
				dpTable[i][0] = chooseLength;
				dpTable[i][1] = chooseVal;
			}
				
		}
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(dpTable[i]));
		}
		System.out.println(dpTable[N][0]);
		

	}


}
