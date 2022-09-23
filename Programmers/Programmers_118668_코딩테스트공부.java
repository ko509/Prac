import java.util.*;
class Solution {
    static int max_alg;
    static int max_cop;
    static int min;
    public int solution(int alp, int cop, int[][] problems) {
        int len = problems.length;
        max_alg = 0;
        max_cop = 0;
        
        for (int[] problem : problems) {
            if(problem[0] > max_alg) max_alg = problem[0];
            if(problem[1] > max_cop) max_cop = problem[1];
        }
        min = Integer.MAX_VALUE;
        if(max_alg >= alp && max_cop >= cop) min = max_alg - alp + max_cop - cop;
        // System.out.println(max_alg +" " + max_cop);
        // perm(0, new int[len], alp, cop, problems);
        if(max_alg <= alp && max_cop <= cop) return 0;
        study(0, alp, cop, problems);
        return min;
    }
    
    static public void study(int time, int alp, int cop, int[][] problems) {
        if(time >= min) return;
        if(alp >= max_alg && cop >= max_cop) {
            min = Math.min(min, time);
            return;
        } else {
            int learn_alp = Math.max(0, max_alg - alp);
            int learn_cop = Math.max(0, max_cop - cop);
            min = Math.min(min, learn_alp + learn_cop + time);
        }
        int len = problems.length;
        for (int i = 0; i < len; i++) {
            int plus_time = 0;
            int alp_req = problems[i][0];
            int cop_req = problems[i][1];
            int alp_rwd = problems[i][2];
            int cop_rwd = problems[i][3];
            int cost = problems[i][4];
            // if((alp_rwd + cop_rwd)/cost < 1) continue;
            if(alp < alp_req) plus_time += alp_req - alp;
            if(cop < cop_req) plus_time += cop_req - cop;
            if(alp >= max_alg && cop >= max_cop) {
                min = Integer.min(min, time + plus_time);
                return;
            }
            // if(plus_time == 0) continue;
            study(time + plus_time + cost, Math.max(alp_req, alp) + alp_rwd, Math.max(cop_req, cop)+ cop_rwd, problems);
            // if(plus_time > 0) study(time + plus_time, Math.max(alp_req, alp), Math.max(cop_req, cop), problems);
        }
    }
    
}
/*
+9
*/
