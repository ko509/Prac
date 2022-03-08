import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11648KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] tob = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				tob[i][j] = str.charAt(j)-'0';
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = st.nextToken().charAt(0)-'0'-1;
			int d = Integer.parseInt(st.nextToken());
			// d가 1이면 시계방향 -1이면 반시계 방향
			int[][] temp = new int[4][8];
			
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					temp[j][j2] = tob[j][j2];
				}
			}
			if(d==1) {
				temp[t][0] = tob[t][7];
				for (int j = 7; j >= 1; j--) {
					temp[t][j] = tob[t][j-1];
				}
			}else {
				temp[t][7] = tob[t][0];
				for (int j = 0; j < 7; j++) {
					temp[t][j] = tob[t][j+1];
				}
			}
			int dcopy = d*(-1);
			for (int j = t; j >= 1; j--) {
				if(tob[j][6]!=tob[j-1][2]) {
					if(dcopy==1) {
						temp[j-1][0] = tob[j-1][7];
						for (int k = 7; k >= 1; k--) {
							temp[j-1][k] = tob[j-1][k-1];
						}
					}else {
						temp[j-1][7] = tob[j-1][0];
						for (int k = 0; k < 7; k++) {
							temp[j-1][k] = tob[j-1][k+1];
						}
					}
				}else break;
				dcopy*=-1;
			}
			dcopy = d*(-1);
			for (int j = t; j < 3; j++) {
				if(tob[j][2]!=tob[j+1][6]) {
					if(dcopy==1) {
						temp[j+1][0] = tob[j+1][7];
						for (int k = 7; k >= 1; k--) {
							temp[j+1][k] = tob[j+1][k-1];
						}
					}else {
						temp[j+1][7] = tob[j+1][0];
						for (int k = 0; k < 7; k++) {
							temp[j+1][k] = tob[j+1][k+1];
						}
					}
				}else break;
				dcopy*=-1;
			}
			for (int j = 0; j < 4; j++) {
				for (int j2 = 0; j2 < 8; j2++) {
					tob[j][j2] = temp[j][j2];
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			answer += tob[i][0]*Math.pow(2, i);
		}
		System.out.println(answer);
	}

}
