package BOJ._3190_뱀;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 오른쪽이 왜 R이 아니라 D죠??
		// 어렵다잉
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N][N];
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int dir = 3;
		
		int length = 1;
		List<int[]>snake = new ArrayList<>();
		
		int[] head = {0,0};
		
		int k = sc.nextInt();
		int[][] apples = new int[k][2];
		
		
		
		
		
	}
	
	public static boolean terminate(List<int[]>snake, int[] head, int N) {
		if (head )
	}

}
