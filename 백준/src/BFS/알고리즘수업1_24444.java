package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고리즘수업1_24444 {
	static int N, M, R;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static int[] node; // 방문 순서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());


		for(int i =0; i<=N; i++) {
			arr.add(new ArrayList<>());
			
		}

		System.out.println(arr.size());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.get(x).add(y); // x번째 리스트에 x번의 정점과 연결된 정점 y를 추가
		}
		
		visited = new boolean[N+1];
		node = new int[N+1];
		BFS();
		
	}// main

	public static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(R); // 시작 정점 넣기
		int cnt = 1;
		visited[R]=true; // 시작 정점 방문체크
		node[R]=cnt;
		while(!q.isEmpty()) {//q가 빌 때까지 반복
			int n = q.poll(); // 큐에서 빼기
			Collections.sort(arr.get(n)); // n번째 리스트 오름차순 정렬
			for(int i : arr.get(n)) { // n번과 연결된 정점을 순회
				if(!visited[i]) { // 방문하지 않았다면
					cnt+=1;
					visited[i]=true; // 방문 체크
					q.add(i); // 큐에 추가
					node[i]=cnt; // 방문순서 입력
				}
			}
			for(int i = 1; i<=N; i++) {
				System.out.println(node[i]);
			}
			
		}
	}
}
