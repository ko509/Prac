import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 340ms
// 메모리 : 13392KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][][] square = new boolean[3][3][10];
		List<int[]> zero = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = str.charAt(j) - '0';
				if(sudoku[i][j] == 0) {
					zero.add(new int[] {i, j});
				} else {
					row[i][sudoku[i][j]] = true;
					col[j][sudoku[i][j]] = true;
					square[(i * 9 + j)  / 27][((i * 9 + j) % 9) / 3][sudoku[i][j]] = true;
				}
			}
		}
		
		dfs(0, sudoku, row, col, square, zero);
		
	}

	private static void dfs(int cnt, int[][] sudoku, boolean[][] row, boolean[][] col, boolean[][][] square, List<int[]> zero) {
		
		if(cnt == zero.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}
		
		int[] cur = zero.get(cnt);
		for (int i = 1; i <= 9; i++) {
			if(row[cur[0]][i]) continue;
			if(col[cur[1]][i]) continue;
			if(square[(cur[0] * 9 + cur[1]) / 27][((cur[0] * 9 + cur[1]) % 9) / 3][i]) continue;
			
			sudoku[cur[0]][cur[1]] = i;
			
			row[cur[0]][i] = true;
			col[cur[1]][i] = true;
			square[(cur[0] * 9 + cur[1]) / 27][((cur[0] * 9 + cur[1]) % 9) / 3][i] = true;
			
			dfs(cnt + 1, sudoku, row, col, square, zero);
			
			row[cur[0]][i] = false;
			col[cur[1]][i] = false;
			square[(cur[0] * 9 + cur[1]) / 27][((cur[0] * 9 + cur[1]) % 9) / 3][i] = false;
		}
	}

}
