import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 배열로 하면 메모리 초과
// 인접리스트로 해보겠음
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수(정점)
		int M = sc.nextInt(); // 키를 비교한 횟수(간선)

		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		} // list의 각 원소 초기화

		int[] degree = new int[N + 1]; // 진입차수

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list[A].add(B);
			degree[B]++;
		} // 입력 완료

		Queue<Integer> q = new LinkedList<>();
		// 우선 진입차수가 0인 것을 넣는다.
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		// 이제 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			int work = q.poll();
			System.out.print(work + " ");
			for (int i = 0; i < list[work].size(); i++) {
				degree[list[work].get(i)]--;
				if (degree[list[work].get(i)] == 0) {
//					System.out.println("확인: "+ list[work].get(i));
					q.add(list[work].get(i));
				}
			}
		}

		System.out.println(); // 개행
	}// main
}
