package BOJ._10164_격자상의경로;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int K = sc.nextInt();
		
		if (K == 0) {
//			System.out.println(Integer.MAX_VALUE);
//			System.out.println(factorial(N+M-2));
			System.out.println(factorial(N+M-2) / (factorial(N-1)*factorial(M-1)));
		}
		
		else {
			
			int a = (K-1)/M;
			int b = (K-1)%M;
			
			long front = factorial(a+b)/(factorial(a)*factorial(b));
			long back = factorial(N-1-a+M-1-b) /(factorial(N-1-a)*factorial(M-1-b));
			
			System.out.println(front*back);
				
			
			
		}
	}
	
	
	public static long factorial(int i) {
		if (i == 1) {
			return 1L;
		}
		else return factorial(i-1) * i;
	}

}
