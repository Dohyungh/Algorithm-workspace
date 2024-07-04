package PRGS._2022Kakao_양과늑대;

import java.util.*;
class Solution {
    static int[][] child;
    static int answer, N;
    public int solution(int[] info, int[][] edges) {
        answer = 0;

        N = info.length;

        child = new int[N][2];

        for (int[] edge : edges) {
            int pa = edge[0];
            int ch = edge[1];
            if (child[pa][0] != 0) {
                child[pa][1] = ch;
                continue;
            }
            child[pa][0] = ch;
        }

        int[] order = new int[N];

        solve(order, info, 0);



        return answer;
    }

    void solve(int[] order, int[] info, int depth) {
        int sum = 0;
        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i <= depth; i++) {
            int node = order[i];
            if (i != 0 && node == 0) break;

            if (info[node] == 0) sheep++;
            if (info[node] == 1) wolf++;
        }

        if (sheep <= wolf) return;
        answer = Math.max(answer, sheep);

        List<Integer> nextNodes = getNextNodes(order);
        for (int nextPossibleNode : nextNodes) {
            int[] newOrder = Arrays.copyOf(order, N);
            newOrder[depth+1] = nextPossibleNode;
            solve(newOrder, info, depth+1);
        }

    }

    List<Integer> getNextNodes(int[] order) {
        List<Integer> nextNodes = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for (int ord : order) {
            visited[ord] = true;
        }

        for (int ord : order) {
            for (int i = 0; i <2; i++) {
                int ch = child[ord][i];
                if ( ch != -1 && ! visited[ch]) {
                    nextNodes.add(ch);
                }
            }

        }
        return nextNodes;

    }

}