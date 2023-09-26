import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 대표자 배열
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// tc개수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 국가의 수
			int N = sc.nextInt();
			// 비행기 종류
			int M = sc.nextInt();

			// 비행기 경로 담을 리스트 배열
			List<Integer>[] list = new ArrayList[N];

			// 각 리스트 초기화
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}

			// 비행기 경로 입력
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				// 왕복, 인덱스 맞춰야 함
				list[A - 1].add(B - 1);
				list[B - 1].add(A - 1);
			}

//			for(List<Integer> a : list) {
//				System.out.println(a);
//			}

			p = new int[N];

			// 대표자 설정
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			int cnt = 0; // 타야 하는 비행기의 최소 개수

			// 크루스칼 알고리즘
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					// 만약 대표자가 다르다면
					if (findset(i) != findset(list[i].get(j))) {
						// 두 집합 합치자
						unioun(findset(i), findset(list[i].get(j)));
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		// tc
	}
	// main

	static void unioun(int x, int y) {
		p[y] = x;
	}

	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];

	}
}
