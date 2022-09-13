class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        perm(0, new char[8], new boolean[8], data);
        return answer;
    }
    
    static public void perm(int cnt, char[] friend, boolean[] v, String[] data) {
        
        if(cnt == 8) {
            if(check_data(friend, data)){
                answer++;   
            }
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(v[i]) continue;
            v[i] = true;
            friend[cnt] = friends[i];
            perm(cnt + 1, friend, v, data);
            v[i] = false;
        }
    }
    
    static public boolean check_data(char[] friend, String[] data) {
        
        for(String str : data) {
            char first = str.charAt(0);
            char sec = str.charAt(2);
            char how = str.charAt(3);
            int num = str.charAt(4) - '0' + 1;
            int fi = -1;
            int si = -1;
            for(int i = 0; i < 8; i++) {
                if(friend[i] == first) fi = i;
                if(friend[i] == sec) si = i;
            }
            if(how == '>') {
                if(Math.abs(fi-si) <= num) return false;
            } else if(how == '=') {
                if(Math.abs(fi-si) != num) return false;
            } else {
                if(Math.abs(fi-si) >= num) return false;
            }
        }
        return true;
    }
}
/*
+5

테스트 1 〉	통과 (687.21ms, 94.7MB)
*/
