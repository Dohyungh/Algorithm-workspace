package PRGS._2023Kakao_123떨어뜨리기;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int[] answer = {};
        return answer;
    }
    
    
    class Node {
    	int idx;
    	Queue<Node> childs;
    	int childsIdx;
    	
    	
    	Node(int idx) {
    		this.idx = idx;
    		this.childs = new LinkedList<Integer>();
    		
    	}
    	
    	public void add(Node node) {
    		this.childs.add(node);
    	}
    	
    	
    	
    	
    }
    
    
}