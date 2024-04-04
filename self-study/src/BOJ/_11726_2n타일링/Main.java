package BOJ._11726_2n타일링;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dT = new int[1001];
		
		dT[1] = 1;
		dT[2] = 2;
		
		for (int i = 3; i<=N; i++) dT[i] = (dT[i-2] + dT[i-1]) % 10007;
		
		System.out.println(dT[N]);
		
		sc.close();
		
		
	}

}
