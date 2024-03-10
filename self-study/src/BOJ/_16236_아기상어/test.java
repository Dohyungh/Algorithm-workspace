package BOJ._16236_아기상어;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class test {

	static Node[] gragh;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 정점의 개수
		int M = sc.nextInt();		// 간선의 개수
		int V = sc.nextInt();		// 탐색을 시작할 정점의 번호
		gragh = new Node[1001];
		
		for (int i = 0; i < M; i++) {
			int idx1 = sc.nextInt();
			if (gragh[idx1] == null) {
				gragh[idx1] = new Node();
			}
			int idx2 = sc.nextInt();
			if (gragh[idx2] == null) {
				gragh[idx2] = new Node();
			}
			gragh[idx1].links.add(idx2);
			gragh[idx2].links.add(idx1);
		}

		visited = new boolean[1001];
		dfs(V);
		
		System.out.println();
		
		visited = new boolean[1001];
		bfs(V);
		
		sc.close();
	}
	
	public static void dfs(int num) {
		if (visited[num]) return;
		if (gragh[num] == null) return;
		
		System.out.print(num+" ");
		visited[num] = true;
		
		if (gragh[num].links != null && gragh[num].links.size() != 0) {
			Collections.sort(gragh[num].links);
			for (int n : gragh[num].links) {
				dfs(n);
			}
		}
	}
	
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(num);
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			
			int tmp = queue.poll();
			System.out.print(tmp + " ");
			
			if (gragh[tmp] != null && gragh[tmp].links != null) {
				for (int n : gragh[tmp].links) {
					
					if (!visited[n]) {
						queue.add(n);
						visited[n] = true;
					}
				}
			}
		}
	}

}

class Node {
	List<Integer> links = new ArrayList<>();
}
