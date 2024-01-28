import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> homeList;
    static List<int[]> chickenList;
    static int result;
    static int[] chickenArr;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시 한 변의 길이
        N = Integer.parseInt(st.nextToken());
        // 존재해야 하는 최대 치킨집 수
        M = Integer.parseInt(st.nextToken());

        // 도시
        city = new int[N][N];

        // 집 좌표를 저장할 리스트
        homeList = new ArrayList<>();

        // 치킨집 좌표를 저장할 리스트
        chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                // 집을 입력받으면 좌표 저장
                if (city[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                }
                // 치킨집을 입력받으면 좌표저 장, 현재 치킨집 수 +1
                if (city[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }// j
        }// i

        // 치킨집 수
        int chickenNum = chickenList.size();

        // 치킨 거리 합
        result = Integer.MAX_VALUE;

        // 치킨 집 수만큼의 배열
        chickenArr = new int[chickenNum];
        for (int i = 0; i < chickenNum; i++) {
            chickenArr[i] = i;
        }

        // 선택된 조합
        sel = new int[M];

        combi(0, 0, chickenNum);

        System.out.println(result);

    }
    // main

    // 치킨 집 수에서 M개씩 뽑은 부분 조합 구하기
    public static void combi(int idx, int sidx, int chickenNum) {
        // 기저조건
        // M개를 뽑았으면 치킨거리 계산해서 저장
        if (sidx == M) {
            int total = 0;
            for (int i = 0; i < homeList.size(); i++) {
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    // 각 집에서 가장 가까운 치킨거리 저장
                    dist = Math.min(dist, Math.abs(homeList.get(i)[0] - chickenList.get(sel[j])[0]) + Math.abs(homeList.get(i)[1] - chickenList.get(sel[j])[1]));
                }
                total += dist;
            }
            result = Math.min(result, total);
            return;
        }

        // 모든 치킨집을 다 돌았으면
        if (idx == chickenNum) return;

        // 재귀조건
        sel[sidx] = chickenArr[idx];
        combi(idx + 1, sidx + 1, chickenNum);
        combi(idx + 1, sidx, chickenNum);
    }
    // combi

}

