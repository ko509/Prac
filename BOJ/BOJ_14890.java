import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 시간 : 108ms
// 메모리 : 12812KB

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = findrow(map, L) + findcol(map, L);
		System.out.println(answer);
	}

	private static int findcol(int[][] map, int L) {
		int N = map.length;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			boolean count = true;
			int[] len = new int[11];
			len[map[0][i]]++;
			outer : for (int j = 1; j < N; j++) {
				int diff = map[j][i]-map[j-1][i];
				if(diff==0) {
					len[map[j][i]]++;
				}else if(diff==1) {
					if(len[map[j-1][i]]<L) {
						count = false;
						break;
					}
					len[map[j-1][i]] = 0;
					len[map[j][i]]++;
				}else if(diff==-1){
					len[map[j-1][i]] = 0;
					int stand = map[j-1][i];
					for (int k = 0; k < L; k++) {
						if(j+k<N && map[j+k][i]-stand!=-1) {
							count = false;
							break outer;
						}else if(j+k>=N) {
							count = false;
							break outer;
						}
						
					}
					j+=L-1;
					len[map[j-1][i]] = 0;
				}else {
					count = false;
					break;
				}
				
			}
			if(count) {
				answer++;
			}
		}
		return answer;
	}

	private static int findrow(int[][] map, int L) {
		
		int N = map.length;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			boolean count = true;
			int[] len = new int[11];
            len[map[i][0]]++;
			outer : for (int j = 1; j < N; j++) {
				int diff = map[i][j]-map[i][j-1];
				if(diff==0) {
					len[map[i][j]]++;
				}else if(diff==1) {
					if(len[map[i][j-1]]<L) {
						count = false;
						break;
					}
					len[map[i][j-1]]=0;
					len[map[i][j]]++;
				}else if(diff==-1){
					len[map[j-1][i]] = 0;
					int stand = map[i][j-1];
					for (int k = 0; k < L; k++) {
						if(j+k<N && map[i][j+k]-stand!=-1) {
							count = false;
							break outer;
						}else if(j+k>=N) {
							count = false;
							break outer;
						}
						
					}
					j+=L-1;
					len[map[i][j-1]] = 0;
				}else {
					count = false;
					break;
				}
			}
			if(count) {
				answer++;
			}
		}
		return answer;
	}

}
