package BOJ._13913_숨바꼭질4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int answer = 0;
    static int K;
    static class State {
    	int val;
    	List<Integer> records;
    	State(int N, List<Integer> records) {
    		this.val = N;
    		this.records = records;
    	}
    	
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        
        K = sc.nextInt();
        
        Queue<State> q = new LinkedList<State>();
        
        boolean[] visited = new boolean[200_001];
        
        q.add(new State(N, new ArrayList<Integer>()));
        
        int answer = 0;
        
        if (N > K) {
        	System.out.println(N - K);
        	
        	for (int i = N; i >= K; i--) {
        		sb.append(i);
        		sb.append(" ");
        	}
        	System.out.println(sb.toString());
        	return;
        }
        
        int minusAnswer = Integer.MAX_VALUE;
        List<Integer> minusList = null;
        
        while(!q.isEmpty()) {
        	
        	int sz = q.size();
        	for (int c = 0; c < sz; c++) {
        		
	        	State curr = q.poll();
	        	
	        	if (curr.val < 0 || curr.val > 200000) continue;
	        	if (visited[curr.val]) continue;
	        	
	        	visited[curr.val]= true;
	        	
	        	List<Integer> copiedList = new ArrayList<>();
	        	for (int j = 0; j < curr.records.size(); j++) {
	        		copiedList.add(curr.records.get(j));
	        	}
	        	copiedList.add(curr.val);
	        	
	        	if (curr.val > K) {
	        		
	        		if (minusAnswer > copiedList.size() + (curr.val - K)) {
//	        			System.out.println("여어어기");
	        			minusAnswer = copiedList.size() + (curr.val - K);
	        			minusList = copiedList;
//	        			System.out.println(minusAnswer);
	        		}
	        		
	        		continue;
	        	}
	        	
	        	if (curr.val == K && curr.records.size() < minusAnswer) {
	        		System.out.println(curr.records.size());
	        		for (int i = 0; i < curr.records.size(); i++) {
	        			sb.append(curr.records.get(i));
	        			sb.append(" ");
	        		}
	        		sb.append(K);
	        		System.out.println(sb.toString());
	        		return;
	        	}
	        	
	        	if (curr.val < K && curr.val * 2 <= 200000 && !visited[curr.val*2]) {
	        		q.add(new State(curr.val*2, copiedList));	        		
	        	}
	        	
	        	if (curr.val < K && curr.val + 1 <= 200000 && !visited[curr.val+1]) {
	        		q.add(new State(curr.val + 1, copiedList));	        		
	        	}
	        	
	        	if (curr.val > 1 && !visited[curr.val-1]) {
	        		q.add(new State(curr.val-1, copiedList));	        		
	        	}
	        	
        	}
        	answer++;
        	
        	
        	
        }
        
        if (answer > minusAnswer) {
//        	System.out.println("여기");
        	System.out.println(minusAnswer);
        	for (int i = 0; i < minusList.size(); i++) {
        		sb.append(minusList.get(i));
        		sb.append(" ");
        	}
        	for (int i = minusList.get(minusList.size() - 1); i >= K; i--) {
        		sb.append(i);
        		sb.append(" ");
        	}
        	System.out.println(sb.toString());
        }
        
        
        
        
        
        
        
        
        
        
    }
}