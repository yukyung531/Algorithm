import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 동전의 가지 수
			int N = Integer.parseInt(br.readLine());
			// 동전의 종류를 담을 배열, 인덱스 1부터 채움
			int[] coins = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			// 만들어야 할 금액
			int M = Integer.parseInt(br.readLine());
			// 입력 완료

			int[] dp = new int[M + 1];
			dp[0] = 1;
			for (int i = 1; i <= N; i++) {// 동전의 종류
				for (int j = 0; j <= M; j++) {// 만들어야 할 금액
					if (j - coins[i] >= 0) {
						dp[j] = dp[j] + dp[j - coins[i]];
					}
				}
			}

			System.out.println(dp[M]);
		}
		// tc
	}
	// main
}
