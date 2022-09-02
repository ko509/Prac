import java.util.*;

class Solution {
    static int min;
    public int solution(String name) {
        
        int len = name.length();
        int alpha = 0;
        int[] move = new int[len];
        
        for(int i = 0; i < len; i++) {
            int tmp = name.charAt(i) - 'A';
            if(tmp > 26 - tmp) tmp = 26 - tmp;
            alpha += tmp;
        }
        int[] v = new int[len];
        v[0] = 1;
        min = Integer.MAX_VALUE;
        dfs(name.toCharArray(), v, 0, 0);
        // System.out.println(alpha);
        // System.out.println(n);
        int answer = alpha + min;
        return answer;
    }
    
    public static void dfs(char[] name, int[] v, int cnt, int prev) {
        int len = name.length;
        int[] dr = {-1, 1};

        if(cnt >= min) return;
        if(allClear(name, v)) {
            if(min > cnt) min = cnt;
            System.out.println(cnt);
            System.out.println(Arrays.toString(v));
            return;
        }
        for(int d = 0; d < 2; d++) {
            int nr = prev + dr[d];
            if(nr == len) nr = 0;
            if(nr == -1) nr = len - 1;
            if(v[nr] > 2) continue;
            v[nr]++;
            dfs(name, v, cnt + 1, nr);
            v[nr]--;
        }
        return;
    }
    
    static public boolean allClear(char[] name, int[] v) {
        int len = name.length;
        for(int i = 0; i < len; i++) {
            if(name[i] != 'A' && v[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
