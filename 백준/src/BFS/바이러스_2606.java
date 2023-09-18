package BFS;
// 약 40분 걸림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_2606 {
	static int N, M;// 컴퓨터 수, 네트워크 연결선 수
	static int V = 1; // 감염 컴퓨터 번호
	static List<Integer>[] list; // 감염된 컴퓨터와 네트워크가 연결된 컴퓨터를 담을 리스트배열
	static boolean[] visited; // 방문체크
	static int cnt = 0; // 바이러스 걸린 컴퓨터 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		// 이 작업을 꼭 해주어야 함.. 이거 빼먹어서 또 시간 버림
		for(int i = 0; i<list.length; i++) {
			list[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 양방향
			list[x].add(y);
			list[y].add(x);
		}

		BFS();
		System.out.println(cnt);

	}// main

	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V); // 시작 컴퓨터를 큐에 넣기
		visited[V] = true; // 시작 컴퓨터 방문 체크
		while (!q.isEmpty()) { // 큐가 빌 때까지 반복
			int n = q.poll(); // 변수 n 에 큐의 맨 앞의 값 넣기
			for (int i = 0; i < list[n].size(); i++) { // 컴퓨터 n과 연결된 컴퓨터 순회
				int t = list[n].get(i); // 편하게 사용하기 위해 연결 컴퓨터를 변수 t에 넣음
				if (visited[t] == false) { // 컴퓨터 t를 방문하지 않았다면
					q.add(t);// 큐에 추가
					visited[t] = true;// 방문 체크
					++cnt; // 바이러스 컴퓨터와 연결된 컴퓨터 수 증가
				}
			}
		} // while

	}// BFS

}
