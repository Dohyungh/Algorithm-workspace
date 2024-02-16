package BOJ._2851_슈퍼마리오;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0 ;
		int answer = 0;
		for (int i = 0; i<10; i++) {
			sum+=sc.nextInt();
			if (Math.abs(answer-100) >= Math.abs(sum-100)) answer = sum;
		}
		
		System.out.println(answer);
	}

}
