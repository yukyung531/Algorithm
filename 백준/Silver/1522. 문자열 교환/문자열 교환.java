import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        // 슬라이딩 윈도우로 풀어야 함.

        int aCount = 0;
        for (char c : charArr) {
            if (c == 'a') {
                aCount++;
            }
        }
        /*
          a의 개수를 세는 이유 => 예를 들어, abaabb문자열이 있다면, 완성형은 aaabbb임, 
            => aaa 즉, 크기가 3인 구간 내에 b가 없어야 함.
            따라서 슬라이딩 윈도우로 a의 개수만큼의 구간 내에 b의 개수가 최소가 되는 부분을 찾으면 됨.
         */
        
        // 한 가지 문자로만 이루어져 있을 경우 0 출력 후 리턴
        if (aCount == 0 || aCount == charArr.length) {
            System.out.println(0);
            return;
        }

        int bCount = 0;
        // 초기 윈도우에 포함된 b의 개수
        for (int i = 0; i < aCount; i++) {
            if (charArr[i] == 'b') {
                bCount++;
            }
        }

        int minBCount = bCount;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i - 1] == 'b') {
                bCount--;
            }
            if (charArr[(i + aCount - 1) % charArr.length] == 'b') {
                bCount++;
            }

            minBCount = Math.min(minBCount, bCount);
        }

        System.out.println(minBCount);
    }
}