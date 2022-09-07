import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int N = truck_weights.length;
        int[] time = new int[N];
        int start = 0;
        int end = 0;
        int w = 0;
        int t = 0;
        while(true) {
            if(time[start] + bridge_length == t) {
                w -= truck_weights[start];
                start++;
            }
            if(truck_weights[end] + w > weight || end - start >= bridge_length) {
                t = time[start] + bridge_length;
                continue;
            }
            w += truck_weights[end];
            time[end] = t;
            end++;
            t++;
            if(end == N) break;
        }
        return time[N - 1] + bridge_length + 1;
    }
    

}

/*
테스트 1 〉	통과 (0.02ms, 69.8MB)
테스트 2 〉	통과 (0.03ms, 75.6MB)
테스트 3 〉	통과 (0.02ms, 83.7MB)
테스트 4 〉	통과 (0.05ms, 79.8MB)
테스트 5 〉	통과 (0.07ms, 74MB)
테스트 6 〉	통과 (0.05ms, 76.4MB)
테스트 7 〉	통과 (0.01ms, 73.4MB)
테스트 8 〉	통과 (0.04ms, 76.2MB)
테스트 9 〉	통과 (0.06ms, 72.9MB)
테스트 10 〉	통과 (0.03ms, 76.9MB)
테스트 11 〉	통과 (0.03ms, 72.9MB)
테스트 12 〉	통과 (0.03ms, 76.1MB)
테스트 13 〉	통과 (0.04ms, 65.3MB)
테스트 14 〉	통과 (0.02ms, 69.7MB)
*/
