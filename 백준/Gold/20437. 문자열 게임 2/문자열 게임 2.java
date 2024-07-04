import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            Map<Character, List<Integer>> charPositions = new HashMap<>();
            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                charPositions.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            for (List<Integer> positions : charPositions.values()) {
                if (positions.size() < K) continue;

                for (int i = 0; i <= positions.size() - K; i++) {
                    int start = positions.get(i);
                    int end = positions.get(i + K - 1);
                    int len = end - start + 1;

                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}