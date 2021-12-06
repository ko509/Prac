package _1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_13038 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] week = new int[7];
			
			st = new StringTokenizer(br.readLine());
			List<Integer> one = new ArrayList<Integer>();
			for (int i = 0; i < 7; i++) {
				week[i] = Integer.parseInt(st.nextToken());
				if(week[i]==1) one.add(i);
			}
			int min = Integer.MAX_VALUE;
			for (Integer integer : one) {
				int i = integer;
				int count = 0;
				int days = 0;
				boolean flag = false;
				while(true) {
					if(week[i]==1) {
						count++;
					}
					days++;
					if(count==N) break;
					i++;
					if(i==7) i = 0;
				}
				min = Math.min(min, days);
			}
			
			System.out.println("#"+t+" "+min);
		}
	}

}
