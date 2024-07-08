import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Cow {
        int arrive;
        int cnt;

        public Cow(int arrive, int cnt) {
            this.arrive = arrive;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 헛간 수
        int M = Integer.parseInt(st.nextToken()); // 소들의 길

        List<Cow>[] cowList = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cowList[i] = new ArrayList<>();
        }
        // 리스트 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cows = Integer.parseInt(st.nextToken());
            cowList[start].add(new Cow(end, cows));
            cowList[end].add(new Cow(start, cows));
        }

        int[] arr = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        PriorityQueue<Cow> pq = new PriorityQueue<>(new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) { // 소 마릿수 오름차순
                return o1.cnt - o2.cnt <= 0 ? -1 : 1;
            }
        });

        pq.add(new Cow(1, 0)); // 시작점 넣기

        while (!pq.isEmpty()) {
            Cow cow = pq.poll();
            int now = cow.arrive;
            if (visited[now]) continue;
            visited[now] = true;

            for (int i = 0; i < cowList[now].size(); i++) {
                Cow next = cowList[now].get(i);
                if (arr[now] + next.cnt < arr[next.arrive]) {
                    arr[next.arrive] = arr[now] + next.cnt;
                    pq.add(new Cow(next.arrive, arr[next.arrive]));
                }
            }
        }
        System.out.println(arr[N]);

    }
    // main
}