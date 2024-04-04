package BOJ._1463_1로만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dT = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Arrays.fill(dT, Integer.MAX_VALUE);
		for(int i = 1; i <=N; i++) {
			tada(i, i, 0);
		}
		System.out.println(dT[N]);
	}

	private static void tada(int start, int i, int cnt) {
		
		if (i == 1) {
			dT[start] = Math.min(dT[start], cnt);
			return;
		}
		
		if(dT[i] != Integer.MAX_VALUE) {
			dT[start] = Math.min(dT[i]+cnt,dT[start]);
			return;
		}
		
		
		if (i %3 ==0) tada(start,i/3,cnt+1);
		if (i %2 ==0) tada(start,i/2,cnt+1);
		tada(start,i-1,cnt+1);
	}

}
