import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 거스름돈
		int n = sc.nextInt();

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int min = 987654321;
			// 2원을 사용하는 경우의 최소 동전 개수
			if (i >= 2) {
				min = Math.min(min, dp[i - 2] + 1);
			}
			// 5원을 사용하는 경우의 최소 동전 개수
			if (i >= 5) {
				min = Math.min(min, dp[i - 5] + 1);
			}
			if (min > 0) {
				dp[i] = min;
			}
		}
		// for

		if (dp[n] != 987654321) {
			System.out.println(dp[n]);
		} else
			System.out.println(-1);
	}
	// main
}
