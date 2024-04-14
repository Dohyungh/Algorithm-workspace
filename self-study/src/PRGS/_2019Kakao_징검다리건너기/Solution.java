package PRGS._2019Kakao_징검다리건너기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	
	public static void main(String[] args) {
		
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, 1));
		
	}
	
	static int globalMin = Integer.MAX_VALUE;
    public static int solution(int[] stones, int k) {
    	Deque<Integer> deque = new ArrayDeque<Integer>();
    	int max = -1;
    	int maxIdx = -1;
    	for (int i =0; i < k; i++) {
    		if (stones[i] > max) {
    			max = stones[i];
    			maxIdx = i;
    		}
    	}
    	deque.add(maxIdx);
    	
    	int idx = 0;
    	while (idx < stones.length) {
    		if (deque.peekFirst() < idx-k+1) deque.poll();
    		
    		if (deque.isEmpty()) {
    			deque.add(idx);
    		}
    		
    		if (stones[idx] >= stones[deque.peekFirst()]) {
    			deque.clear();
    			deque.add(idx);
    		} else {
    			while(stones[deque.peekLast()] < stones[idx]) deque.pollLast();
    			deque.addLast(idx);
    		}
    		
    		globalMin = Math.min(globalMin, stones[deque.peekFirst()]);
    		
    		idx++;
    	}
    	
    	
    	
        return globalMin;
    }

}
