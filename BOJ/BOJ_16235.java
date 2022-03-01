import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


// 시간 : 1064ms
// 메모리 : 204064KB
public class BOJ_16235 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 땅 크기 N*N
		int M = Integer.parseInt(st.nextToken()); // 나무 개수
		int K = Integer.parseInt(st.nextToken()); // K년 후
		
		int[] dr = {-1, -1, -1, 0, 0, 1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		
		int[][] s2d2 = new int[N][N];
		int[][] map = new int[N][N];
		PriorityQueue<Integer>[][] tree = new PriorityQueue[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s2d2[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				tree[i][j] = new PriorityQueue<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			tree[r-1][c-1].offer(z);
		}
		
		int count = M;
		for (int k = 0; k < K; k++) {
			int[][] age5 = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Queue<Integer> tmp = new LinkedList<>();
                    boolean flag = false;
                    int total = 0;
					while(!tree[i][j].isEmpty()) {
                        int age = tree[i][j].poll();
                        int diff = map[i][j] - age;
                        if(diff < 0 || flag==true) {
                            flag = true;
                            total += age/2;
                            count--;
                        }else if(flag==false && diff >=0) {
                            map[i][j] = diff;
                            tmp.offer(++age);
                            if(age%5==0) age5[i][j]++;
                        }
					}
                    map[i][j] += total;
					while(!tmp.isEmpty()) {
						tree[i][j].offer(tmp.poll());
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
                    int size = age5[i][j];
					for (int j2 = 0; j2 < size; j2++) {
						
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr<0 || nc <0 || nr >= N || nc >= N) continue;
							tree[nr][nc].offer(1);
                            count++;
						}
					}
					map[i][j] += s2d2[i][j];
				}
			}
		}
		System.out.println(count);
	}

}
