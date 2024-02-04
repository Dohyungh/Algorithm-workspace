package SWEA._4012_요리사;

public class Solution {

	public static void main(String[] args) {
		int arr[] = {0,1,1,2,2,2};
		int output[] = new int[arr.length];
		boolean visited[] = new boolean[arr.length];
		
		for(int i = 0; i<arr.length; i++) {
			permutation(arr,output,visited,0,i+1);
		}
	}
	
	public static void permutation(int arr[], int output[], boolean visited[], int depth, int r) {
		if (depth ==r) {
			for(int i = 0; i<r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr,output, visited, depth+1,r);
				visited[i] = false;
			}
		}
	}
}
