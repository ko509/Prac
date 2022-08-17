import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 1248ms
// 메모리 : 46096KB
public class Main {

	static int[] order;
	static int cnt;
	static int[] inorder;
	static int[] postorder;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		inorder = new int[N];
		postorder = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
            postorder[i] = Integer.parseInt(st2.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		order = new int[N];
		cnt = 0;
		findOrder(0, N-1, 0, N - 1);
		for (int i : order) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	private static void findOrder(int start, int end, int postS, int postE) {

        if(start > end) return;
		int rootLoc = findRootLoc(start, end, postE);
		if(rootLoc == -1) {
			return;
		}
		order[cnt++] = inorder[rootLoc];
		findOrder(start, rootLoc - 1, postS, postS + rootLoc - 1 - start);
		findOrder(rootLoc + 1, end, postS + rootLoc - start, postE - 1);
	
	}
	private static int findRootLoc(int start, int end, int root) {
		int M = postorder.length;
			for(int j = end; j >= start; j--) {
				if(inorder[j] == postorder[root]) {
					return j;
				}
			}
		return -1;
	}

}
