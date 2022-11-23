package _1663;

// https://www.acmicpc.net/problem/1663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static int solution3(String str, char c){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    private static char solution2(String str, int k){
        return str.charAt(k - 1);
    }
    private static int solution1(String str){
        return str.length();
    }
    private static String transform(int n){
        String str = "Z";
        Map<String, String> map = new HashMap<>();
        map.put("X", "YZ");
        map.put("Y", "Z");
        map.put("Z", "X");
        while(n > 0){
            n--;
            String[] sArr = str.split("");
            str = Arrays.stream(sArr).map(map::get).collect(Collectors.joining());
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String type = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String str = transform(n);

        switch (type){
            case "1":
                System.out.println(solution1(str));
                break;
            case "2":
                int k = Integer.parseInt(br.readLine());
                System.out.println(solution2(str, k));
                break;
            case "3":
                char c = br.readLine().charAt(0);
                System.out.println(solution3(str, c));
        }
    }
}
