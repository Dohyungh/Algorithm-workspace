package BOJ._17471_게리맨더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] adj;
	static int[] population;
	static boolean[][] cases;
	static int finalAnswer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		population = new int[N];
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new boolean[N][N];
		
		for (int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			for(int j = 0; j < z; j++) {
				int num = Integer.parseInt(st.nextToken());
				adj[i][num-1] = true;
			}
		}
		
		cases = new boolean[(int)Math.pow(2, N)][N]; 
		solve();
		System.out.println(finalAnswer);
		
				
		
	}
	
	public static boolean BFS(boolean[] aCase) {
		boolean answer = true;

		Queue<Integer> queue = new LinkedList<>();
		
		int num1 = 0;
		int num2 = 0;
		
		int start1 = -1;
		int start2 = -1;
		
		for (int i = 0; i < aCase.length; i++) {
			if (aCase[i]) {
				num1++;
				start1 = i;
			}
			else {
				num2++;
				start2 = i;
			}
			
		}
		
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < aCase.length; i++) {
			if (!aCase[i]) {
				visited[i] = true;
			}
		}

		queue.offer(start1);
		visited[start1] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i = 0; i < N; i++) {
				if (adj[nowNode][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					
				}
			}
			cnt++;
		}

		if (cnt != num1) return false;
		
		
		queue.clear();
		
		visited = new boolean[N];
		
		for (int i = 0; i < aCase.length; i++) {
			if (aCase[i]) {
				visited[i] = true;
			}
		}
		
		queue.offer(start2);
		visited[start2] = true;
		cnt = 0;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i = 0; i < N; i++) {
				if (adj[nowNode][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			cnt++;
		}

		if (cnt != num2) return false;
		
		return answer;
		
	}
	
	public static void getCases() {
		
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) > 0) cases[i][j] = true;
			}
		}
	}
	
	public static void solve() {
		boolean found = false;
		getCases();
		for (int c = 1; c <cases.length-1; c++) {
			if (BFS(cases[c])) {
				int population1 = 0;
				int population2 = 0;
				for (int i = 0; i < cases[c].length; i++) {
					if (cases[c][i]) {
						population1 += population[i];
					} else population2 +=population[i];
					
				}
				found = true;
				
				finalAnswer = Math.min(finalAnswer, Math.abs(population1-population2));
				
			}
		}
		if (!found) finalAnswer = -1;
		
	}
}
