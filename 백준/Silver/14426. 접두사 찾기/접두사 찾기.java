import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class  Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // S에 포함된 문자열 개수
        int N = Integer.parseInt(st.nextToken());
        // 검사해야 하는 문자열 개수
        int M = Integer.parseInt(st.nextToken());

        // 집합 S
        Set<String> S = new HashSet<>();

        for(int i = 0; i<N; i++){
            // S에 포함된 문자열 str을 입력받음과 동시에
            String str = br.readLine();
            // str이 가질 수 있는 모든 접두어를 S에 저장
            for(int j = 1; j<=str.length(); j++){
                S.add(str.substring(0,j));
            }
        }

        // 답
        int cnt = 0;

        for(int i = 0; i<M; i++){
            // 검사해야 할 문자열을 입력받고
            String str = br.readLine();
            // S에 존재한다면 cnt+1
           if(S.contains(str)) cnt++;
        }
        
        System.out.println(cnt);
    }
}