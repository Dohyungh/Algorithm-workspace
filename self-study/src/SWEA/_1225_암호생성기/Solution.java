package SWEA._1225_암호생성기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int T = 10;
		
		for (int tc = 1; tc<=10; tc++) {
			sc.nextInt();
			for (int i = 0; i<8; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;
			while (arr[arr.length-1]!=0) {
				
				if (cnt == 5) {
					cnt = 0;
				}
				cnt++;
				
				arr[0] = Math.max(0, arr[0]-cnt);
				arr = move(arr);
				
			}
			
			
			System.out.printf("#%d",tc);
			for (int i = 0; i<8; i++) {
				System.out.printf(" %d",arr[i]);
			}
			System.out.println();
		}
		sc.close();
		
		
	}
	
	public static int[] move(int[] arr) {
		int[] temp = new int[arr.length];
		
		System.arraycopy(arr, 1, temp,0, arr.length-1);
		temp[arr.length-1] = arr[0];
		return temp;
		
	}

}
