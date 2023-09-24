import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc개수

		for (int tc = 1; tc <= T; tc++) {
			int day = sc.nextInt();
			int month1 = sc.nextInt();
			int month3 = sc.nextInt();
			int year = sc.nextInt();

			int[] plan = new int[13];
			for (int i = 1; i < 13; i++) {
				plan[i] = sc.nextInt();
			}
			int[] money = new int[13];

			for (int i = 1; i < 13; i++) {
				// 일일 vs 한달

				// 만약 한달 이용권이 더 저렴하다면
				if (day * plan[i] > month1) {
					money[i] = month1 + money[i - 1];// 누적합
					// 일일 이용권이 더 저렴하다면
				} else {
					money[i] = day * plan[i] + money[i - 1];
				}
//				System.out.println(day * plan[i]);
//				System.out.println(Arrays.toString(money));
				// 위의 값 vs 3달

				if (i - 3 >= 0) {
					// 만약 3달 이용권이 더 저렴하다면
					if (money[i] > money[i - 3] + month3) {
						money[i] = money[i - 3] + month3;
					}

				}
				// 3달 이용권을 11월 ,12월에 사는 경우
				if (i >= 11) {
					if (money[i] > money[i - 1] + month3) {
						money[i] = money[i - 1] + month3;
					}
				}
			}

			int ans = 0;
			// 위의 값 vs 일년
			if (money[12] > year) {
				ans = year;
			} else
				ans = money[12];

			System.out.println("#"+tc+" "+ans);
		} // tc

	}// main
}