import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 256ms
// 메모리 : 42788KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			// 위 아래 앞 뒤 왼 오
			// 흰, 노, 빨, 오, 초, 파
			int[][][] cube = new int[6][3][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						cube[i][j][k] = i+1;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			while(--N >= 0) {
				char[] op = st.nextToken().toCharArray();
				turn_cube(op, cube);
				
				turn_90(op, cube);
			}
			for (int[] is : cube[0]) {
				// 흰, 노, 빨, 오, 초, 파
				for (int is2 : is) {
					switch (is2) {
					case 1:
						sb.append('w');
						break;
					case 2:
						sb.append('y');
						break;
					case 3:
						sb.append('r');
						break;
					case 4:
						sb.append('o');
						break;
					case 5:
						sb.append('g');
						break;
					case 6:
						sb.append('b');
						break;

					default:
						break;
					}
				}
				sb.append('\n');
			}
			System.out.println(sb.substring(0, sb.length()-1));
		}
		
	}

	private static void turn_cube(char[] op, int[][][] cube) {

		// 위 아래 앞 뒤 왼 오
		if(op[0] == 'U') {
			if(op[1] == '+') {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[2][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][0][i] = cube[5][0][2-i];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][0][i] = cube[3][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][0][2-i] = cube[4][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][0][i] = tmp[i];
				}
			} else {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[2][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][0][i] = cube[4][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][0][i] = cube[3][0][2-i];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][0][i] = cube[5][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][0][i] = tmp[2-i];
				}
			}
		} else if(op[0] == 'D') {
			if(op[1] == '+') {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[2][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][2][i] = cube[4][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][2][i] = cube[3][2][2-i];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][2][i] = cube[5][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][2][2-i] = tmp[i];
				}
			} else {
				
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[2][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][2][i] = cube[5][2][2-i];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][2][i] = cube[3][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][2][2-i] = cube[4][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][2][i] = tmp[i];
				}
			}
		} else if(op[0] == 'F') {
			// 위 아래 앞 뒤 왼 오
			if(op[1] == '+') {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][2][i] = cube[4][2-i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][i][2] = cube[1][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][2][i] = cube[5][2-i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][i][2] = tmp[i];
				}
			} else {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][2][i] = cube[5][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][2-i][2] = cube[1][2][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][2][i] = cube[4][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][2-i][2] = tmp[i];
				}
			}
		} else if(op[0] == 'B') {
			// 위 아래 앞 뒤 왼 오
			if(op[1] == '+') {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][0][i] = cube[5][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][2-i][0] = cube[1][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][0][i] = cube[4][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][2-i][0] = tmp[i];
				}
			} else {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][0][i] = cube[4][2-i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[4][i][0] = cube[1][0][i];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][0][i] = cube[5][2-i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[5][i][0] = tmp[i];
				}
			}
		} else if(op[0] == 'L') {
			// 위 아래 앞 뒤 왼 오
			if(op[1] == '+') {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][i][0] = cube[3][2-i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][i][0] = cube[1][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][i][0] = cube[2][2-i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][i][0] = tmp[i];
				}
			} else {
				// 위 아래 앞 뒤 왼 오
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][i][0] = cube[2][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][2-i][0] = cube[1][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][i][0] = cube[3][i][0];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][2-i][0] = tmp[i];
				}
			}
		} else {
			if(op[1] == '+') {
				// 위 아래 앞 뒤 왼 오
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][i][2] = cube[2][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][2-i][2] = cube[1][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][i][2] = cube[3][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][2-i][2] = tmp[i];
				}
			} else {
				// 위 아래 앞 뒤 왼 오
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = cube[0][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[0][i][2] = cube[3][2-i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[3][i][2] = cube[1][i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[1][i][2] = cube[2][2-i][2];
				}
				for (int i = 0; i < 3; i++) {
					cube[2][i][2] = tmp[i];
				}
			}
		}
	}

	private static void turn_90(char[] op, int[][][] cubes) {

		// 위 아래 앞 뒤 왼 오
		int[][] cube = new int[3][3];
		char dir = op[1];
		
		switch (op[0]) {
		case 'U':
			cube = cubes[0];
			break;
		case 'D':
			cube = cubes[1];
			if(dir == '+') dir = '-';
			else dir = '+';
			break;
		case 'F':
			cube = cubes[2];
			break;
		case 'B':
			if(dir == '+') dir = '-';
			else dir = '+';
			cube = cubes[3];
			break;
		case 'L':
			cube = cubes[4];
			break;
		case 'R':
			if(dir == '+') dir = '-';
			else dir = '+';
			cube = cubes[5];
			break;

		default:
			break;
		}
		
		if(dir == '+') {
			for (int i = 0; i < 3; i++) {
				for (int j = i; j < 3 - i -1; j++) {
					int top = cube[i][j];
					cube[i][j] = cube[3-1-j][i];
					cube[3-1-j][i] = cube[3-1-i][3-1-j];
					cube[3-1-i][3-1-j] = cube[j][3-1-i];
					cube[j][3-1-i] = top;
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = i; j < 3 - i -1; j++) {
					int top = cube[j][3-1-i];
					cube[j][3-1-i] = cube[3-1-i][3-1-j];
					cube[3-1-i][3-1-j] = cube[3-1-j][i];
					cube[3-1-j][i] = cube[i][j];
					cube[i][j] = top;
				}
			}
		}
	}

}
