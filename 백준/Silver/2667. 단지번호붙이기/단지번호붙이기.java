import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static List<Integer> list;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 지도 한 변
		N = sc.nextInt();

		// 지도
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();

			map[i] = str.toCharArray();
		}

//		for (char[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		// 각 단지의 집 수 저장
		list = new ArrayList<>();

		// 전체 단지 수
		int total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					// 방문체크 배열 초기화
					visited = new boolean[N][N];
					bfs(i, j);
					total++;
				}
			}
		}

//		System.out.println(list.size());

		System.out.println(total);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
// main

	public static void bfs(int r, int c) {
		int cnt = 0;
		// 상 하 좌 우
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };

		Queue<Node> q = new LinkedList<Node>();

		// 시작점 넣기
		q.add(new Node(r, c));
		cnt++;
		// 방문체크
		visited[r][c] = true;
		map[r][c] = '0';

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nextR = curr.r + dr[d];
				int nextC = curr.c + dc[d];

				// 범위 안에 있고, 방문체크 안했고, 집이 있다면
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC]
						&& map[nextR][nextC] == '1') {
					q.add(new Node(nextR, nextC));
					cnt++;
					visited[nextR][nextC] = true;
					map[nextR][nextC] = '0';

				}

			}
		}
		// while
		list.add(cnt);

	}

}
