package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <=N; i++) {
			que.offer(i);
		}
		int lastpop = -1;
		while(true) {
			lastpop = que.poll();
			if(que.isEmpty()) break;
			int temp = que.poll();
			que.offer(temp);
		}
		System.out.println(lastpop);
	}

}
