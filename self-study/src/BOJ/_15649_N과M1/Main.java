package BOJ._15649_N과M1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++ ) {
			arr[i] = i+1;
		}
		boolean[] visited = new boolean[N];
		int[] output = new int[r];
		
		permutation(arr,visited,0,output,r);
		System.out.println(sb.toString());
		
		
	}
	
	public static void permutation(int[] arr, boolean[] visited, int depth, int[] output, int r) {
		if (depth == r) {
			for (int i = 0; i<output.length; i++) {
				sb.append(output[i]);
				if (i <=output.length-2) {
					sb.append(" ");
					
				}
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr,visited,depth+1,output,r);
				visited[i] = false;
			}
			
		}
		
	}

}
