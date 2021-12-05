package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String[] s = string.split("-|\\+");
		String[] plusminus = string.split("[0-9]+");
		int len = plusminus.length;
		int sum = Integer.parseInt(s[0]);
		boolean flag = false;
		//System.out.println(Arrays.toString(plusminus));
		for (int i = 1; i < len; i++) {
			if(plusminus[i].equals("-")) flag = true;
			if(flag==false) {
				sum+=Integer.parseInt(s[i]);
			}else {
				sum-=Integer.parseInt(s[i]);
			}
		}
		System.out.println(sum);
	}

}
