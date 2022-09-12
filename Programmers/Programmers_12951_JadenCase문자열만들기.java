import java.util.*;
class Solution {
    public String solution(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        char prev = ' ';
        for(int i = 0; i < len; i++) {
            if(prev == ' ') {
                if(cs[i] >= 'a') {
                    cs[i] -= 32;
                }
            } else if(cs[i] >= 'A' && cs[i] < 'a') {
                cs[i] += 32;
            }
            prev = cs[i];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(c);
        }
        return sb.toString();
    }
}

/*
+8점

테스트 1 〉	통과 (0.03ms, 72MB)
테스트 2 〉	통과 (0.04ms, 75.1MB)
테스트 3 〉	통과 (0.05ms, 77.3MB)
테스트 4 〉	통과 (0.04ms, 73.2MB)
테스트 5 〉	통과 (0.06ms, 77.9MB)
테스트 6 〉	통과 (0.03ms, 73.4MB)
테스트 7 〉	통과 (0.03ms, 72.6MB)
테스트 8 〉	통과 (0.03ms, 74.5MB)
테스트 9 〉	통과 (0.04ms, 71.5MB)
테스트 10 〉	통과 (0.03ms, 73.2MB)
테스트 11 〉	통과 (0.04ms, 73.4MB)
테스트 12 〉	통과 (0.03ms, 73.9MB)
테스트 13 〉	통과 (0.04ms, 74.3MB)
테스트 14 〉	통과 (0.04ms, 79.5MB)
테스트 15 〉	통과 (0.04ms, 74.8MB)
테스트 16 〉	통과 (0.04ms, 76.7MB)
테스트 17 〉	통과 (0.03ms, 72.7MB)
테스트 18 〉	통과 (0.02ms, 74.5MB)
*/
