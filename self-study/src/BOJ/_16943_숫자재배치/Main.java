package BOJ._16943_숫자재배치;

import java.util.Scanner;

public class Main {
	static int B;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		B = sc.nextInt();
		answer = -1;
		String str = ""+ A;
		char[] aList = str.toCharArray();
		
		boolean[] visited = new boolean[aList.length];
		String[] output = new String[aList.length];
		
		permutation(aList, visited, 0, output);
		System.out.println(answer);
	}
	
	public static void permutation(char[] aList, boolean[] visited, int depth, String[] output) {
		if (depth == aList.length) {
			String aCase = "";
			if (output[0].equals("0")) return;
			for (int i = 0; i <aList.length; i++) {
				aCase += output[i];
			}
			
			int num = Integer.parseInt(aCase);
			
			if (num < B && num > answer) {
				answer = num;
			}
		}
		
		for (int i = 0; i<aList.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = ""+aList[i];
				permutation(aList,visited,depth+1,output);
				visited[i] = false;
			}
		}
	}

}
