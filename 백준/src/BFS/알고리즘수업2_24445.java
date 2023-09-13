package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 내림차순 방문!
public class 알고리즘수업2_24445 {
	static int N, M, R; // 정점 수, 간선 수, 시작 정점
	static ArrayList<ArrayList<Integer>> list; // 간선 정보를 담을 리스트
	static int[] visited; // 방문체크 및 방문순서
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // readLine은 스트링 값과 엔터를 포함하여 읽어오는 방식
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		
		
		
		
	}
	public static void bfs() {
		
	}
	

}
