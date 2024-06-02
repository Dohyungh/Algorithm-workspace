package PRGS._2023Kakao_택배배달과수거하기;
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int sD = -1;
        int sP = -1;
        List<Integer> del = new ArrayList<>();
        List<Integer> pic = new ArrayList<>();
        for (int i = n-1; i >= 0 ; i--) {
            if (deliveries[i] != 0) {
                sD = i;
                break;
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            if (pickups[i] != 0) {
                sP = i;
                break;
            }
        }

        if(sD != -1) {
            del.add(sD+1);
        }
        if(sP != -1) {
            pic.add(sP+1);
        }

        int p = n-1;
        int cnt = 0;
        while(p >= 0) {
            cnt += deliveries[p];
            if (cnt > cap) {
                deliveries[p] = cnt - cap;
                del.add(p+1);
                cnt = 0;
                continue;
            }
            p--;

        }
        p = n-1;
        cnt = 0;
        while(p >= 0) {
            cnt += pickups[p];
            if (cnt > cap) {
                pickups[p] = cnt - cap;
                pic.add(p+1);
                cnt = 0;
                continue;
            }
            p--;

        }

        int common = Math.min(del.size(), pic.size());

        for (int i = 0; i < common; i++) {
            answer += Math.max(del.get(i),pic.get(i));
        }

        if (common == del.size()) {
            for (int i = common; i < pic.size(); i++) {
                answer += pic.get(i);
            }
        } else {
            for (int i = common; i < del.size(); i++) {
                answer += del.get(i);
            }
        }

        return answer*2;
    }
}
