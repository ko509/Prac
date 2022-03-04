package _2022_sk_jina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

// 시간 : 260ms
// 메모리 : 25716KB
public class BOJ_17140 {

	static class Arr implements Comparable<Arr>{
		
		int num;
		int count;
		
		public Arr(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
		@Override
		public int compareTo(Arr o) {
			int n = Integer.compare(this.count, o.count);
			if(n!=0) return n;
			else return Integer.compare(this.num, o.num);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken())-1;
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int answer = -1;
		int r = 3;
		int c = 3;
		
		while(count<=100) {
			if(arr[R][C]==K) {
				answer = count;
				break;
			}
			int base = r;
			int nbase = c;
			if(r>=c) {
				for (int i = 0; i < base; i++) {
					Map<Integer, Arr> map = new HashMap<>();
					for (int j = 0; j < nbase; j++) {
						if(arr[i][j]==0) continue;
						if(map.containsKey(arr[i][j])) {
							map.put(arr[i][j], new Arr(arr[i][j], map.get(arr[i][j]).count+1));
						}else {
							map.put(arr[i][j], new Arr(arr[i][j], 1));
						}
					}
					List<Map.Entry<Integer, Arr>> entries = new LinkedList<>(map.entrySet());
					Collections.sort(entries, (o1, o2)-> o1.getValue().compareTo(o2.getValue()));
					
					if(map.size()*2<=100) c = Math.max(c, map.size()*2);
					
					int n = 0;
					for (Entry<Integer, Arr> entry : entries) {
//						System.out.println(entry.getKey() + " " + entry.getValue().count);
						arr[i][n++] = entry.getValue().num;
						arr[i][n++] = entry.getValue().count;
					}
					for (int j = n; j < base; j++) {
						for (int v = 0; v < nbase; v++) {
							arr[i][j] = 0;
						}
					}
				}
			} else {
				for (int j = 0; j < nbase; j++) {
					Map<Integer, Arr> map = new HashMap<>();
					for (int i = 0; i < base; i++) {
						if(arr[i][j]==0) continue;
						if(map.containsKey(arr[i][j])) {
							map.put(arr[i][j], new Arr(arr[i][j],map.get(arr[i][j]).count+1));
						}else {
							map.put(arr[i][j], new Arr(arr[i][j], 1));
						}
					}
					List<Map.Entry<Integer, Arr>> entries = new LinkedList<>(map.entrySet());
					Collections.sort(entries, (o1, o2)-> o1.getValue().compareTo(o2.getValue()));
					if(map.size()*2<=100) r = Math.max(r, map.size()*2);
					
					int n = 0;
					for (Entry<Integer, Arr> entry : entries) {
						arr[n++][j] = entry.getValue().num;
						arr[n++][j] = entry.getValue().count;
					}
					for (int i = n; i < base; i++) {
						for (int v = 0; v < nbase; v++) {
							arr[i][j] = 0;
						}
					}
				}
			}
			count++;
			if(arr[R][C]==K) {
				answer = count;
				break;
			}
		}
		System.out.println(answer);
	}


}
