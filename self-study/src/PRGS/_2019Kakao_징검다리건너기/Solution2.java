package PRGS._2019Kakao_징검다리건너기;

public class Solution2 {
	
	
	public static void main(String[] args) {
		
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, 3));
		
	}
	
	static int globalMin;
    public static int solution(int[] stones, int k) {

        
        // k 사이즈의 sliding window에서
        // 가장 작은 maximum 을 찾으라는 거네
        
        int maxIdx = -1;
        int max = -1;
        for (int i = 0; i < k; i++) {
        	if (stones[i] >= max) {
        		max = stones[i];
        		maxIdx = i;
        	}
        	
        }
        globalMin = max;
        
        int right = k-1;
        int left = 0;
        
        out:
        while(right <stones.length) {
        	
        	while (right < stones.length && stones[right] <= max && left < maxIdx) {
        		left++;
        		right++;
        	}
        	if (right >= stones.length-1) {
        		max = -1;
        		for (int i = left; i <= Math.min(right, stones.length-1); i++) {
        			if (stones[i] > max) {
        				max = stones[i];
        			}
        		}
        		globalMin = Math.min(globalMin, max);
        		break out;
        	}
        	if (left == maxIdx) {
        		left = Math.min(maxIdx+1, stones.length-k);
        		right = left +k-1;
        		max = -1;
        		maxIdx = -1;
        		for (int i =left; i <= right; i++) {
        			if (stones[i] >= max) {
        				max = stones[i];
        				maxIdx = i;
        			}
        		}
        	}  
        	else {
        		max = stones[right];
        		maxIdx = right;
        	}
        	globalMin = Math.min(globalMin,max);
        }
        return globalMin;
    }

}
