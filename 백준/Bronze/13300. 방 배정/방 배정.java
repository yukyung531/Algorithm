import java.util.Scanner;

public class Main{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 학생 수 입력
		int N = sc.nextInt();

		// 한 방에 수용 가능한 학생 수
		int K = sc.nextInt();

		int wSum = 0; // 여자 합
		int mSum = 0; // 남자 합

		int[][] student = new int[N][2]; // 성별, 학년 담을 N행 2열 배열 생성

		int[] cnt = new int[12]; // 학년마다 성별로 나누어 학생 수 카운트

		for (int i = 0; i < N; i++) { // 학생수만큼
			int S = sc.nextInt(); // 성별 입력
			int Y = sc.nextInt(); // 학년 입력
			student[i][0] = S; // 배열에 값 입력
			student[i][1] = Y;
		}

		for (int i = 0; i < N; i++) {
			for (int k = 1; k < 12; k++) {
				if (student[i][1] == k) { // k학년일때
					if (student[i][0] == 0) { // 여자라면
						cnt[(k * 2) - 1] += 1; // k학년 여자 수 +1
					} else { // 남자라면
						cnt[(k * 2) - 2] += 1; // k학년 남자 수 +1
					}
				}

			}

		}

		int answer = 0; // 필요한 방의 수

		for (int i = 0; i < 12; i++) {
			answer += cnt[i] / K;
			if (cnt[i] % K != 0) {
				answer += 1;
			}
		}

		System.out.println(answer);
	}
}
