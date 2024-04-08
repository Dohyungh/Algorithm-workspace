package PRGS._2023Kakao_123떨어뜨리기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Solution {
	static int answer;
	static int targetSum;
	static int[] answerArr;
	static boolean found;
	public static void main(String[] args) {
		
		int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
		int[] target = {0,0,0,3,0,0,5,1,2,3};
		int[][] edges1 = {{1, 2}, {1, 3}};
		int[] target1 = {0,7,3};
		int[][] edges2 = {{1, 3}, {1, 2}};
		int[] target2 = {0,7,1};
		
		System.out.println(Arrays.toString(solution(edges,target)));
//		System.out.println(Arrays.toString(solution(edges1,target1)));
//		System.out.println(Arrays.toString(solution(edges2,target2)));
		
	}
	
    public static int[] solution(int[][] edges, int[] target) {
    	answer = 8;
    	found = false;
    	targetSum = 0;
    	for (int i = 0; i < target.length; i++) targetSum += target[i];
    	System.out.println("targetSum"+ targetSum);
        int[] answer = {};
        
        Arrays.sort(edges, (int[] o1, int[] o2) -> {
        	if(o1[0] == o2[0]) return o1[1] - o2[1];
        	return o1[0] - o2[0];
        });
        
        int N = edges.length+1;
        
        Node[] nodes = new Node[N+1];
        for (int i = 1; i < N+1; i++) nodes[i] = new Node(i);
        for (int[] edge : edges) nodes[edge[0]].add(nodes[edge[1]]);
        int[] result = new int[N];
        int[] output = new int[30];
        DP(1, result, nodes, 0, 0, target, output);

        nodes = new Node[N+1];
        for (int i = 1; i < N+1; i++) nodes[i] = new Node(i);
        for (int[] edge : edges) nodes[edge[0]].add(nodes[edge[1]]);
        result = new int[N];
        output = new int[30];
        DP(2, result, nodes, 0, 0, target, output);
        
        
        nodes = new Node[N+1];
        for (int i = 1; i < N+1; i++) nodes[i] = new Node(i);
        for (int[] edge : edges) nodes[edge[0]].add(nodes[edge[1]]);
        result = new int[N];
        output = new int[30];
        DP(3, result, nodes, 0, 0, target, output);
        

        return answerArr;
    }
    
    
    
    
    private static void DP(int i, int[] result, Node[] nodes, int numFallen, int sumFallen, int[] target, int[] output) {
    	if (found) return;
    	output[numFallen] = i;
    	sumFallen += i;
    	numFallen += 1;
    	
    	Node nowNode = nodes[1];
    	
    	int id = 0;
    	while (nowNode != null) {
    		id = nowNode.idx;
    		nowNode = nowNode.nextNode(i);
    	}
    	result[id-1] += i;
    	System.out.println();
    	System.out.println("떨어진 node의 idx: " + id);
    	System.out.println("떨어뜨린 숫자:"+ i);
    	System.out.println("떨어뜨린개수:"+numFallen);
    	System.out.println("떨어뜨린총합:"+sumFallen);
    	System.out.println("result:" + Arrays.toString(result));
    	System.out.println("target:" + Arrays.toString(target));
    	System.out.println("output:" + Arrays.toString(output));
    	
    	
    	if (sumFallen == targetSum) {
    		for (int j = 0; j < target.length; j++) {
    			if (result[j] != target[j]) break;
    			if (j == target.length-1) {
    				answerArr = Arrays.copyOf(output, numFallen);
    				found = true;
    			}
    		}
    		return;
    	}
    	
    	System.out.println("갑니다");
    	if (sumFallen > targetSum) return;
    	System.out.println("result[id-1]: "+result[id-1]);
    	System.out.println("target[id-1]: "+ target[id-1]);
    	if (result[id-1] > target[id-1]) return;
    	
    	int[] copiedResult = Arrays.copyOf(result, result.length);
    	int[] copiedOutput = Arrays.copyOf(output, output.length);
    	Node[] copiedNode = new Node[nodes.length];
    	for (int j = 1; j< copiedNode.length; j++) {
    		copiedNode[j] = nodes[j].copy();
    	}
    	
    	DP(1, copiedResult, copiedNode, numFallen, sumFallen, target, copiedOutput);
    	DP(2, copiedResult, copiedNode, numFallen, sumFallen, target, copiedOutput);
    	DP(3, copiedResult, copiedNode, numFallen, sumFallen, target, copiedOutput);
    	
    	
    	
    	
    	
    	
		
	}




	static class Node {
    	int idx;
    	Queue<Node> childs;
    	int sum;
    	
    	
    	Node(int idx) {
    		this.idx = idx;
    		this.childs = new LinkedList<Node>();
    		sum = 0;
    	}
    	Node(int idx, Queue<Node> childs, int sum) {
    		this.idx = idx;
    		this.childs = childs;
    		this.sum = sum;
    	}
    	
    	public void add(Node node) {
    		this.childs.add(node);
    	}
    	
    	public Node nextNode(int num) {
    		if (childs.size()==0) {
    			this.sum+=num;
    			return null;
    		}
    		Node nextNode = childs.poll();
    		childs.add(nextNode);
    		return nextNode;
    	}
    	
    	public Node copy() {
    		Node newNode = new Node(this.idx, this.childs, this.sum);
    		return newNode;
    	}
    }
    
    
}