class Solution {
    public int solution(int[] priorities, int location) {
        int start = 0;
        int cnt = 0;
        int len = priorities.length;
        boolean[] v = new boolean[len];
        while(cnt < len) {
            if(v[start]) {
                start++;
                if(start >= len) {
                    start = 0;
                }
                continue;
            }
            if(isBiggest(start, priorities, v)) {
                v[start] = true;
                if(start==location) return cnt+1;
                start++;
                cnt++;
                if(start >= len) {
                    start = 0;
                }
            } else {
                start++;
                if(start >= len) {
                    start = 0;
                }
            }
        }
        return cnt;
    }
    
    static public boolean isBiggest(int loc, int[] priorities, boolean[] v) {
        int len = priorities.length;
        for(int i = 0; i < len; i++) {
            if(v[i]) continue;
            if(priorities[i] > priorities[loc]) {
                return false;
            }
        }
        return true;
    }
}
