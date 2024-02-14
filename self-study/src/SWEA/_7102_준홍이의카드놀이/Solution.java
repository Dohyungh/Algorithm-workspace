package SWEA._7102_준홍이의카드놀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int data;
	List<Node> children;
	
	Node() {
		
	}
	
	Node(int data){
		this.data = data;
	}
	
	Node(int data, List<Node> children){
		this.data = data;
		this.children = children;
	}
	
	void link(Node child) {
		children.add(child);
	}
	
	
}

public class Solution {
	
	static int[] count = new int[41]; // 여러 test case에 걸쳐 사용할 카운팅 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for (int i = 0; i < count.length; i++) count[i] = 0; // 매 테스트 케이스마다 스태틱 변수를 리셋해주지 않으면 이전 케이스의 자료들이 중첩된다.
			
			// 2층의 tree를 만들자.
			// root
			// parents (N)
			// children (M)
			
			List<Node> children = new ArrayList<>(); // 2층의 노드들을 List로 만들자. 
			for (int i = 0; i<M; i++) {
				children.add(new Node(i+1)); // index에 주의하자.
			}
			
			List<Node> parents = new ArrayList<>(); // 1층의 노드들을 List로 만들자.
			for (int i = 0; i<N; i++) {
				Node newNode = new Node(i+1, children); // 1층의 모든 노드들은 2층의 모든 노드가 담긴 List에 Link된다.
				parents.add(newNode);
			}
			
			Node root = new Node(0,parents); // root Node를 만들자.
			// Tree class를 따로 정의해서 그 안에서 해결할 수도 있다.
			
			DFS(root,0,2,0); // DFS 알고리즘을 돌리자.
			
			int max = 0;
			
			// counting 배열을 보면서 출현 빈도의 최댓값을 찾고,
			for (int i = 2; i<N+M+1; i++) {
				if (count[i] > max) max = count[i];
			}
			
			// 최댓값을 갖는 모든 index를 출력합니다.
			System.out.printf("#%d", tc);
			for (int i = 2; i<N+M+1; i++) {
				if (count[i] == max) System.out.printf(" %d", i);
			}
			
		}
		sc.close();
		
		
	}
	
	public static void DFS(Node node, int depth, int r, int sum) {
		sum = node.data+sum; // 현재 노드의 값을 더해준다.
		if (depth == r) { // 만약 2층 까지 도달했으면, 카운팅배열을 업데이트하고 끝낸다.
			count[sum]++;
			return;
		}
		
		boolean[] visited = new boolean[node.children.size()]; // 방문했는지 여부를 체크할 배열 생성
		
		for (int i = 0; i<node.children.size(); i++) { // 자식 노드들을 순회하면서
			if (!visited[i]) { // 방문하지 않았을 경우 다시 DFS 를 호출한다.
				visited[i] = true;
				DFS(node.children.get(i),depth+1,r,sum); // depth에 1을 더해주고, update 한 sum을 사용한다. 이외 나머지 파라미터는 목표값이기 때문에 계속 동일하다.
			}
		}
	}
}
