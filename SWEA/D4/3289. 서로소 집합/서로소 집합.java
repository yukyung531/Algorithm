import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] p; // 대표자 배열

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc개수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // n개의 집합
			int m = sc.nextInt(); // m번의 연산

			int[][] arr = new int[m][3]; // 연산, a, b 입력받을 배열

			for (int i = 0; i < m; i++) { // m번 입력받기
				arr[i][0] = sc.nextInt(); // 0: a포함 집합과 b포함 집합 합치기 1: 두 원소가 같은 집합인지 확인
				arr[i][1] = sc.nextInt() - 1; // 원소 a (인덱스는 0부터이므로 -1)
				arr[i][2] = sc.nextInt() - 1; // 원소 b (인덱스는 0부터이므로 -1)
			} // 입력완료

//			for(int[] a : arr) {
//				System.out.println(Arrays.toString(a));
//			}// 입력확인

			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			} // 집합 만들기

			System.out.print("#"+tc+" ");
			// 크루스칼 알고리즘
			for (int i = 0; i < m; i++) {
				int x = arr[i][1];
				int y = arr[i][2];

				if (arr[i][0] == 0) { // 연산이 0이면 합집합
					union(findset(x), findset(y));
				} else { // 연산이 1이면 같은 연산인지 확인
					if (findset(x) == findset(y)) {
						System.out.print("1");
					} else {
						System.out.print("0");
					}

				}
			}
			System.out.println(); // 개행

		} // tc

	}// main

	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}//findset

	static void union(int x, int y) {
		if (x != y) {
			p[y] = x;
		}
	}//union

}
