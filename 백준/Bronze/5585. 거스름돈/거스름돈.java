import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 거스름돈
		int N = sc.nextInt();
		N = 1000 - N;

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int min = 987654321;
			if (i >= 1) {
				min = Math.min(min, dp[i - 1] + 1);
			}
			if (i >= 5) {
				min = Math.min(min, dp[i - 5] + 1);
			}
			if (i >= 10) {
				min = Math.min(min, dp[i - 10] + 1);
			}
			if (i >= 50) {
				min = Math.min(min, dp[i - 50] + 1);
			}
			if (i >= 100) {
				min = Math.min(min, dp[i - 100] + 1);
			}
			if (i >= 500) {
				min = Math.min(min, dp[i - 500] + 1);
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}
	// main
}
