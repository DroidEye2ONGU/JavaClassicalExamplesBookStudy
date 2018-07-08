package ELSE.JavaSE.Day13;

import java.util.HashMap;
import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] inputs = input.split(" ");

        HashMap<Integer, String> wordsMap = new HashMap<>();

        for (int i = 0; i < inputs.length; i++) {
            wordsMap.put(i, inputs[i]);
        }

        System.out.println("共有" + wordsMap.keySet().size() + "个单词");
    }
}
