package SWEA._1225_암호생성기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int T = 10;
		
		for (int tc = 1; tc<=10; tc++) {
			for (int i = 0; i<8; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;
			int pointer = 0;
			while (arr[pointer-1]!=0) {
				cnt++;
				arr[pointer] = Math.max(0, arr[pointer]-cnt);
				
			}
		}
		
		
	}

}
