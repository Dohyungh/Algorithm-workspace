package SWEA._1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int money = sc.nextInt();
			
			int[] arr = new int[8];
			int[] currency = {50000,10000,5000,1000,500,100,50,10};
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = money/currency[i];
				money %=currency[i];
			}
			
			System.out.print("#" +tc+"\n");
			System.out.print(arr[0]);
			for (int i = 1; i< arr.length; i++) {
				System.out.print(" "+arr[i]);
			}
			System.out.print("\n");
		}
	}

}
