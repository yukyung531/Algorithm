import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Node> q;
	static boolean[][] visited;
	static int N, M;
	static int[][] storage;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 토마토 저장 창고
		storage = new int[N][M];
		// 방문체크
		visited = new boolean[N][M];

		q = new LinkedList<Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				storage[i][j] = Integer.parseInt(st.nextToken());
				if (storage[i][j] == 1) {
					q.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		bfs();

		int check = 1;
		int answer = 0;
		loof: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (storage[i][j] == 0) {
					check = 0;
					break loof;
				}
				answer = Math.max(storage[i][j], answer);
			}
		}

		// 0이 있다면 -1 출력
		// 없다면 가장 큰 수 출력
		if (check == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer-1);
		}
	}

	// main
	static void bfs() {
		// 상 하 좌 우
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		while (!q.isEmpty()) {
			Node currNode = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextR = currNode.r + dr[i];
				int nextC = currNode.c + dc[i];

				// 만약 범위 안에 있고, 방문안했다면, 토마토가 있다면, q에 넣고 방문체크
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && !visited[nextR][nextC] && storage[nextR][nextC]!=-1) {
					q.add(new Node(nextR, nextC));
					storage[nextR][nextC] = storage[currNode.r][currNode.c]+1;
					visited[nextR][nextC] = true;
				}
			}
		}
		// while
	}
	// bfs
}
