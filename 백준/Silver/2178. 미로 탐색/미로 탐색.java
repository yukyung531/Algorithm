import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, dist;
	// 우 하 상 좌 이동
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int N = 0, M = 0; // 시작 행, 시작 열
	static char[][] maze;
	static int[] position;

	public static class Position {
		int r, c, dist;

		public Position(int r, int c, int dist) {
			super();
			this.r = r; // 행
			this.c = c; // 열
			this.dist = dist; // 거리
		}
	}// 위치와 거리 담아둘 클래스

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			maze[i] = str.toCharArray();
		} // 미로 입력받기

		r = 0; // 현재 행
		c = 0; // 현재 열
		dist = 1; // 거리

		visited = new boolean[N][M]; // 방문 체크

		BFS();
		System.out.println(dist);
	}// main

	static void BFS() {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(r, c, dist)); // 큐에 추가
		visited[r][c] = true;
		while (!q.isEmpty()) {
			Position t = q.poll();
			// t 와 인접한 길을 찾아서
			for (int i = 0; i < 4; i++) {
				int nr = t.r + dr[i];
				int nc = t.c + dc[i];
				int ndist = t.dist+1;
				// 이동 불가능한 길이면 continue
				if (nc < 0 || nc > M - 1 || nr < 0 || nr > N - 1 || visited[nr][nc] || maze[nr][nc] == '0') {
					continue;
				}
				
				// 위치가 ((N-1),(M-1)) 라면 dist 리턴
				if (nr == N - 1 && nc == M - 1) {
					dist=ndist;
					return;
				}
				// 이동 가능하면 이동 후 q에 넣어주고 방문체크
				r = nr;
				c = nc;
				dist = ndist;
				q.add(new Position(r, c, dist));
				visited[r][c] = true;
				
			}
		} // while
	}

}
