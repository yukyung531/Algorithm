import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int min = 987654321;
			if (i >= 3) {
				min = Math.min(min, dp[i - 3] + 1);
			}
			if (i >= 5) {
				min = Math.min(min, dp[i - 5] + 1);
			}
			dp[i] = min;
		}
		if (dp[N] != 987654321) {
			System.out.println(dp[N]);
		}
		else {
			System.out.println(-1);
		}
	}
	// main

}
