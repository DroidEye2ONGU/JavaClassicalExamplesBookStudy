package ELSE.Day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

//获取一个文本上每个字符出现的次数,将结果统计在times.txt上
public class Test7Count {

    private static TreeMap<Character, Integer> times = new TreeMap<>();

    public static void main(String[] args) {
        String pth = new Scanner(System.in).nextLine();
        File inPath = new File(pth);

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(inPath)
                        )
                );
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("times.txt")
                        )
                )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (!times.containsKey(chars[i])) {
                        times.put(chars[i], 1);
                    } else {
                        times.put(chars[i],times.get(chars[i]) + 1);
                    }
                }
            }

            System.out.println(times);

            TreeSet<Character> keySet = new TreeSet<>();
            keySet.addAll(times.keySet());
            keySet.forEach(s-> {
                String t = "" + s + ":" + times.get(s) + "次";
                try {
                    bw.write(t);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
