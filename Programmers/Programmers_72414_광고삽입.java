class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int time = get_time(play_time);
        long[] total_time = new long[time+1];
        
        // 시청 기록 누적합 구하기
        for(String log : logs) {
            String[] tmp = log.split("-");
            int start = get_time(tmp[0]);
            int end = get_time(tmp[1]);
            total_time[start]++;
            if(end <= time) total_time[end]--;
        }
        for (int i = 1; i <= time; i++) {
            total_time[i] += total_time[i-1];
        }
        
        // 광고 삽입 시간 정하기
        int adlen = get_time(adv_time);
        long count = 0l;
        for (int i = 0; i < adlen; i++) {
            count += total_time[i];
        }
        long max = count;
        int point = 0;
        for (int i = 1; i <= time - adlen; i++) {
            count -= total_time[i-1];
            count += total_time[i + adlen - 1];
            // if(i == 3600) System.out.println("01:00:00 "+count);
            // if(i == 5459) System.out.println("01:30:59 "+count);
            if(count > max) {
                max = count;
                point = i;
            }
        }
        
        // point -> 시간 변환
        // System.out.println(point);
        String answer = get_string(point);
        return answer;
    }
    
    static public String get_string(int point) {
        StringBuilder sb = new StringBuilder();
        int h = point/3600;
        if(h < 10) sb.append("0");
        sb.append(h).append(":");
        point %= 3600;
        int m = point/60;
        if(m < 10) sb.append("0");
        sb.append(m).append(":");
        point %= 60;
        if(point < 10) sb.append("0");
        sb.append(point);
        return sb.toString();
    }
    
    static public int get_time(String play_time) {
        String[] ptime = play_time.split(":");
        int time = Integer.parseInt(ptime[0]) * 3600 + Integer.parseInt(ptime[1]) * 60 + Integer.parseInt(ptime[2]);
        return time;
    }
}

/*
+9
7,8,11,12,18,24 케이스 통과 못한 이유
- 시청 시간은 이상/미만으로 생각해야함
- 광고 영상 시간을 0부터 adlen까지 했음... 총 adlen 시간이기 때문에 adlen - 1까지 해야 맞았음
테스트 1 〉	통과 (5.01ms, 80.8MB)
테스트 2 〉	통과 (13.46ms, 95.9MB)
테스트 3 〉	통과 (20.43ms, 92.4MB)
테스트 4 〉	통과 (65.95ms, 124MB)
테스트 5 〉	통과 (85.80ms, 139MB)
테스트 6 〉	통과 (13.28ms, 84.3MB)
테스트 7 〉	통과 (192.38ms, 233MB)
테스트 8 〉	통과 (187.62ms, 215MB)
테스트 9 〉	통과 (330.69ms, 300MB)
테스트 10 〉	통과 (396.95ms, 347MB)
테스트 11 〉	통과 (255.93ms, 306MB)
테스트 12 〉	통과 (299.72ms, 288MB)
테스트 13 〉	통과 (225.33ms, 299MB)
테스트 14 〉	통과 (217.15ms, 274MB)
테스트 15 〉	통과 (5.82ms, 81.5MB)
테스트 16 〉	통과 (228.49ms, 278MB)
테스트 17 〉	통과 (361.77ms, 345MB)
테스트 18 〉	통과 (236.33ms, 308MB)
테스트 19 〉	통과 (3.98ms, 75.7MB)
테스트 20 〉	통과 (1.74ms, 78.9MB)
테스트 21 〉	통과 (152.12ms, 153MB)
테스트 22 〉	통과 (97.67ms, 151MB)
테스트 23 〉	통과 (268.42ms, 293MB)
테스트 24 〉	통과 (213.47ms, 285MB)
테스트 25 〉	통과 (6.73ms, 78.8MB)
테스트 26 〉	통과 (5.07ms, 75.9MB)
테스트 27 〉	통과 (4.71ms, 75.6MB)
테스트 28 〉	통과 (7.07ms, 81.8MB)
테스트 29 〉	통과 (5.98ms, 76.8MB)
테스트 30 〉	통과 (5.67ms, 85MB)
테스트 31 〉	통과 (3.74ms, 79.7MB)
*/
