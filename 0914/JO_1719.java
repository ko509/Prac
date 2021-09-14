import java.util.Scanner;

public class JO_1719 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		if(N>100 || N%2==0) System.out.println("INPUT ERROR!");
		else {
		switch (M) {
			case 1:
				for (int i = 0; i < N/2; i++) {
					for (int j = 0; j < i+1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = N/2; i < N; i++) {
					for (int j = 0; j < N-i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < N/2; i++) {
					for (int j = 0; j < (N+1)/2-(i+1); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < i+1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = N/2; i < N; i++) {
					for (int j = 0; j < (N+1)/2-(N-i); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < N-i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N/2; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < N-2*i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = N/2; i < N; i++) {
					for (int j = 0; j < N-i-1; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < N-(N-i-1)*2; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < N/2; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (N+1)/2-i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = N/2; i < N; i++) {
					for (int j = 0; j < N/2; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (N+1)/2-(N-i-1); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
	
			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		}
	}

}
