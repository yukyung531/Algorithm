import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 물건 수
		int N = sc.nextInt();
		// 최대 무게
		int K = sc.nextInt();
		// 무게 배열
		int[] weight = new int[N + 1];
		// 가치 배열
		int[] value = new int[N + 1];
		for (int i = 0; i < N; i++) {
			weight[i+1] = sc.nextInt();
			value[i+1] = sc.nextInt();
		}
		// 입력 완료
		
		int[][] dp = new int[N + 1][K + 1];
		
		for(int i = 1; i<=N; i++) {// i번 물건일 때
			for(int j = 0; j<=K; j++) {// 무게가 j일 때
				if(weight[i]<=j) { // i번 물건의 무게가 j보다 크거나 같다면
					dp[i][j]=Math.max(dp[i-1][j], value[i]+dp[i-1][j-weight[i]]);
				}
				else {// 그렇지 않다면
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		//for
		System.out.println(dp[N][K]);

	}
//main
}
