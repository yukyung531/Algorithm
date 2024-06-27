import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> list;
    public static String[] S;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().split("");
        String[] T = br.readLine().split("");

        list = new ArrayList<>();

        for (int i = 0; i < T.length; i++) {
            list.add(T[i]);
        }

        dfs(list);
        if(flag) System.out.println(1);
        else System.out.println(0);


    }
    // main

    public static void dfs(List list) {
        if (list.size() == S.length) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(S[i])) {
                    cnt++;
                }
            }
            if(cnt == S.length){
                flag = true;
                return;
            }
        }

        if (list.size() > 0) {
            if (list.get(list.size() - 1).equals("A")) {
                List<String> newList = new ArrayList<>(list);
                newList.remove(newList.size() - 1);
                dfs(newList);
            }

            if (list.get(0).equals("B")) {
                List<String> newList = new ArrayList<>(list);
                newList.remove(0);
                Collections.reverse(newList);
                dfs(newList);
            }
        }

    }

}