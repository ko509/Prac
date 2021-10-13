package _1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1219 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = null;
		while((s=br.readLine())!=null) {
			st = new StringTokenizer(s);
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
			}
			
			int flag = goto99(list, 0);
			System.out.println("#"+T+" "+flag);
		}
	}

	private static int goto99(List<Integer>[] list, int start) {

		if(start==99) return 1;
		else {
			for (int l : list[start]) {
				if(goto99(list, l)==1) return 1;
			}
		}
		return 0;
	}

}
