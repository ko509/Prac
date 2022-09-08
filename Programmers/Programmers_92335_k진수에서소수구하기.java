import java.util.*;

class Solution {
    public int solution(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0) {
            stack.add(n % k);
            n /= k;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        int count = 0;
        StringTokenizer st = new StringTokenizer(sb.toString(), "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            // System.out.println(num + " " + (int)Math.sqrt(num));
            boolean flag = true;
            if(num == 1) continue;
            for(int i = 2; i <= (int) Math.sqrt(num); i++) {
                if(num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }
   
}
/*
테스트 1 〉	통과 (14.15ms, 83MB)
테스트 2 〉	통과 (0.26ms, 75.8MB)
테스트 3 〉	통과 (0.19ms, 77.8MB)
테스트 4 〉	통과 (0.31ms, 70.1MB)
테스트 5 〉	통과 (0.21ms, 71.9MB)
테스트 6 〉	통과 (0.25ms, 73.6MB)
테스트 7 〉	통과 (0.33ms, 75.8MB)
테스트 8 〉	통과 (0.21ms, 77.9MB)
테스트 9 〉	통과 (0.27ms, 77.7MB)
테스트 10 〉	통과 (0.25ms, 73.4MB)
테스트 11 〉	통과 (0.29ms, 74.3MB)
테스트 12 〉	통과 (0.28ms, 77.4MB)
테스트 13 〉	통과 (0.22ms, 73.6MB)
테스트 14 〉	통과 (0.21ms, 75.8MB)
테스트 15 〉	통과 (0.18ms, 72.4MB)
테스트 16 〉	통과 (0.19ms, 84.2MB)
*/
