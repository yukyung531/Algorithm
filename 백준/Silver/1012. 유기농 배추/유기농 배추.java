import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] farm;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class node {
		int r, c;

		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// tc개수
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 배추밭 가로
			M = sc.nextInt();
			// 배추밭 세로
			N = sc.nextInt();

			// 배추밭 초기화
			farm = new int[N][M];

			// 배추 개수
			int K = sc.nextInt();
			// 배추 위치

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				farm[y][x] = 1;
			}

			int cnt = 0;
			
			// farm 순회하면서 1을 만나면 bfs
			// bfs를 한 개수를 세어보자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);

		}
		// tc
	}
	// main

	public static void bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		Queue<node> q = new LinkedList<>();

		q.add(new node(i, j));
		// 방문체크
		visited[i][j] = true;
		farm[i][j] = 0;

		while (!q.isEmpty()) {
			node curr = q.poll();
			// 상하좌우 탐색
			for (int d = 0; d < dr.length; d++) {
				int nextR = curr.r + dr[d];
				int nextC = curr.c + dc[d];

				// 범위 안에 있고, 방문하지 않았고, 배추가 있다면 q에 넣고 방문체크
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC] && farm[nextR][nextC]==1) {
					q.add(new node(nextR, nextC));
					visited[nextR][nextC] = true;
					farm[nextR][nextC] = 0;
				}
			}
		}
	}
	// bfs
}
