package BFS;
// 약 한시간 소요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS_1260 {
	static List<Integer>[] list; // 인접정점 정보 리스트를 가지는 배열
	static boolean[] visited; // 방문 체크
	static List<Integer> node; // 방문 순서 기록
	static int N, M, V; // 정점 수, 간선 수, 시작 정점
	static int cnt = 0; // 방문 순서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		node = new ArrayList<>();
		list = new ArrayList[N + 1]; // 정점의 번호와 리스트의 인덱스와 맞추기 위해

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		} // 각 원소리스트 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 양방향이므로 아래처럼 인접 정점의 정보 입력
			list[x].add(y);
			list[y].add(x);
		} // 입력완료

		// list의 각 리스트를 오름차순으로 정렬하자.
		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i]);
		}
		
		DFS(V);
		for(int i = 0; i<node.size(); i++) {
			System.out.print(node.get(i)+ " ");
		}System.out.println();
		
		visited = new boolean[N + 1]; // 초기화 해줘야 함.. 이거 안해서 시간 버림
		node = new ArrayList<>(); // 초기화 해줘야 함
		
		BFS(V);
		for(int i = 0; i<node.size(); i++) {
			System.out.print(node.get(i)+ " ");
		}System.out.println();

	}// main

	static void DFS(int V) { // 깊이 우선 탐색
		visited[V]=true; // 정점 방문체크
		node.add(V); // 몇 번 정점이 방문했는지 추가
		for(int i = 0; i<list[V].size(); i++) { // 해당 정점과 인접한 정점들을 순회
			int n = list[V].get(i); // 값을 편리하게 사용하려고 변수 n에 인접 정점을 담음
			if(visited[n]==false) { // 만약 인접정점을 방문하지 않은 상태라면
				DFS(n); // 재귀
			}
		}
	}

	static void BFS(int V) { // 너비 우선 탐색
		Queue<Integer> q = new LinkedList<>();
		q.add(V); // 시작 정점을 큐에 추가
		visited[V] = true; // 시작 정점 방문 체크
		node.add(V); // 시작 정점 방문 기록
		while(!q.isEmpty()) { // 큐가 빌 때까지 반복
			int n = q.poll(); // 큐의 맨 앞의 값을 변수 n에 넣기
			for(int i = 0; i<list[n].size(); i++) { //정점 n과 인접한 정점들을 순회
				int t = list[n].get(i);
				if(visited[t]==false) { // 방문하지 않은 정점이라면
					q.add(t);// 큐에 추가하고
					visited[t]=true; // 방문체크
					node.add(t); // 방문 기록
				}
			}
		}
		

	}//BFS

//	4 5 1
//	1 2
//	1 3
//	1 4
//	2 4
//	3 4
}
