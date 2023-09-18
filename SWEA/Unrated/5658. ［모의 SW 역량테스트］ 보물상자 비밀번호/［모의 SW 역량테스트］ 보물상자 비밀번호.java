
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		// 16진수를 10 진수르 표현하는 방법 => Integer.parseInt("_", 16);

		int T = sc.nextInt(); // tc 개수

		for (int tc = 1; tc <= T; tc++) {

			List<String> sum;
			String str = "";
			int N = sc.nextInt(); // 입력될 숫자의 개수
			int K = sc.nextInt(); // K번째의 숫자를 구해야 함

			String[] strArr = new String[N]; // 입력된 문자열을 한 문자씩 쪼개서 담을 배열
			String no = sc.next(); // 일단 문자열로 받고
			strArr = no.split("");// 문자열을 쪼개서 문자열 배열에 넣어준 후

			List<String> list = new ArrayList<>(); // 입력된 문자열을 담을 리스트

			for (int i = 0; i < N; i++) {
				list.add(strArr[i]); // 리스트에 담자주자
			}

			List<Integer> result = new ArrayList<>(); // 결과담을 리스트

			for (int i = 0; i < N - (N / 4) +1; i += N / 4) { // 회전하기 전의 수를 result 배열에 입력
				sum = new ArrayList<>(); // N/4개씩 쪼갠 숫자를 넣을 배열
				for (int j = i; j < i + (N / 4); j++) {
					sum.add(list.get(j));
				} // sum 배열에 N/4 개의 숫자를 담은 후
				str = ""; // 결과 숫자 초기화
				for (int j = 0; j < N / 4; j++) { // sum 배열 순회
					str += sum.get(j);
				} // 이제 다시 문자열을 숫자로 변환하여 결과 리스트에 넣는다ㅏ.
				int resultNum = Integer.parseInt(str, 16);
				result.add(resultNum);
			} // 회전하기 전의 숫자

			int cycle = 0; // 회전 수
			while (cycle < N / 4) { //N/4번 회번하면 처음과 동일하므로 N/4 -1번 회전한다.
				list.add(0, list.get(list.size() - 1)); // 맨 뒤의 숫자를 맨 앞으로
				list.remove(list.size() - 1); // 맨 뒤의 숫자 삭제
				for (int i = 0; i < N - (N / 4) +1; i += N / 4) { // 회전한 후의 수를 result 배열에 입력
					sum = new ArrayList<>(); // N/4개씩 쪼갠 숫자를 넣을 배열
					for (int j = i; j < i + (N / 4); j++) {
						sum.add(list.get(j));
					} // sum 배열에 N/4 개의 숫자를 담은 후
					str = ""; // 결과 숫자 초기화
					for (int j = 0; j < N / 4; j++) { // sum 배열 순회
						str += sum.get(j);
					} 
					// 이제 다시 문자열을 숫자로 변환하여 결과 리스트에 넣는다ㅏ.
					int resultNum = Integer.parseInt(str, 16);
					result.add(resultNum);
				} // 회전한 후의 숫자
				cycle++;
			} // while
			
			// result 에서 중복된 값을 제거하자.
			// list -> set으로 바꾸면 중복 제거 가능!
			Set<Integer> set = new HashSet<Integer>(result);

			// 다시 set 을 list로 바꾸자
			result = new ArrayList<Integer>(set);
			
			// result 내림차순 정렬하자!
			Collections.sort(result, Collections.reverseOrder());
			// 이제 K번째 값을 출력하자.
			System.out.println("#"+tc+ " "+result.get(K-1));
		} // tc
		
		

	} // main

}
