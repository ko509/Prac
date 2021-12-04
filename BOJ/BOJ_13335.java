package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13335 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받기
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 트럭 하중 입력
		int[] truck = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
			
		}
		int[][] time = new int[N][2];
		time[0][0] = -1;
		time[0][1] = W+1;
		for (int i = 1; i < N; i++) {
			int onbridge = truck[i];
			time[i][0] = -1;
			for (int j = i-1; j >=0; j--) {
				onbridge+=truck[j];
				if(onbridge>L || j==i-W) {
					time[i][0] = j;
					break;
				}
			}
			if(time[i][0]==-1 || time[i][0]==time[i-1][0]) time[i][1] = time[i-1][1]+1;
			else time[i][1] = Math.max(time[time[i][0]][1]+W, time[i-1][1]+1);
		}
		System.out.println(time[N-1][1]);
	}



}
