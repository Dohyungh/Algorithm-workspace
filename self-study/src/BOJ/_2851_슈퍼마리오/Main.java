package BOJ._2851_슈퍼마리오;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] prefixSum = new int[10];
		
		int sum = 0 ;
		for (int i = 0; i<10; i++) {
			sum+=sc.nextInt();
			prefixSum[i] = sum;
		}
		
		int answer = 0;
		for (int i = 0; i<10; i++) {
			if (Math.abs(answer-100) >= Math.abs(prefixSum[i]-100)) answer = prefixSum[i];
		}
		
		System.out.println(answer);
	}

}
