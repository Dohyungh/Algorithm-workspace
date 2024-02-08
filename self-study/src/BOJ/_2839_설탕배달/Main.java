package BOJ._2839_설탕배달;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		for (int i = N/5; i>=0; i--) {
			int rest = (N-5*i);
			if (rest%3==0) {
				if (ans > (rest/3) + i) ans = i+(rest/3);
			} 
			
			
		}
		if (N!=0 && ans ==Integer.MAX_VALUE) {
			ans =-1;
		}
		
		System.out.println(ans);
	}

}
