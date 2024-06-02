package PRGS._2023Kakao_이모티콘할인행사;

import java.util.*;

class Solution {
    static List<int[]> powerSet = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {-1,-1};
        int[] result = new int[emoticons.length];
        getPowerSet(0, emoticons, result);

        for(int i = 0; i < powerSet.size(); i++) {
            int[] ans = getResult(powerSet.get(i), users, emoticons);
            if(ans[0] > answer[0]){
                answer = ans;
            } else if (ans[0] == answer[0]) {
                if(ans[1] > answer[1]) {
                    answer = ans;
                }
            }
        }
        return answer;
    }

    public void getPowerSet(int depth, int[] emoticons, int[] result) {
        int m = emoticons.length;
        if (depth == m) {
            int[] copy = Arrays.copyOf(result, result.length);
            powerSet.add(copy);
            return;
        }
        int[] lookUp = {10, 20, 30, 40};

        for (int i = 0; i < 4; i++) {
            result[depth] = lookUp[i];
            getPowerSet(depth+1, emoticons, result);
        }
    }

    public int[] getResult(int[] aSet, int[][] users, int[] emoticons) {
        int[] ans = {0,0};
        int[] discountedEmo = new int[emoticons.length];
        for (int i = 0; i < aSet.length; i++) {
            discountedEmo[i] = emoticons[i] * (100 - aSet[i]) / 100;
        }

        for (int[] user : users) {
            int money = 0;
            for (int i = 0; i < discountedEmo.length; i++) {
                if (aSet[i] >= user[0]) {
                    money += discountedEmo[i];
                }
            }
            if (money >= user[1]) {
                ans[0]++;
            } else {
                ans[1] += money;
            }
        }
        return ans;
    }
}