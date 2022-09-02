import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        for(int t = 0; t < len; t++) {
            if(manhatan(places[t])){
                answer[t] = 1;
            }
        }
        return answer;
    }
    
    static boolean manhatan(String[] place) {
        
        List<int[]> people = new ArrayList<>();
        char[][] map = new char[5][5];
        for(int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
            for(int j = 0; j < 5; j++) {
                if(map[i][j]=='P') {
                    people.add(new int[]{i, j});
                }
            }
        }
        
        int size = people.size();
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                int[] first = people.get(i);
                int[] sec = people.get(j);
                int dist = Math.abs(first[0] - sec[0]) + Math.abs(first[1] - sec[1]);
                if(dist==1) return false;
                if(dist > 2) {
                    continue;
                }
                if(dist == 2) {
                    if(first[0] == sec[0]) {
                        if(first[1] > sec[1] && map[sec[0]][sec[1] + 1] == 'O') {
                            return false;
                        } else if(first[1] < sec[1] && map[first[0]][first[1] + 1] == 'O') {
                            return false;
                        }
                    } else if(first[1]==sec[1]) {
                        if(first[0] > sec[0] && map[sec[0] + 1][sec[1]] == 'O') {
                            return false;
                        } else if(first[0] < sec[0] && map[first[0] + 1][first[1]] == 'O') {
                            return false;
                        }
                    } else {
                        if(first[1] < sec[1]) {
                            if(map[first[0]][first[1] + 1] == 'O') {
                                return false;
                            }
                            if(map[sec[0]][sec[1] - 1] == 'O') {
                                return false;
                            }
                        } else {
                            if(map[first[0]][first[1] - 1] == 'O') {
                                return false;
                            }
                            if(map[sec[0]][sec[1] + 1] == 'O') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
