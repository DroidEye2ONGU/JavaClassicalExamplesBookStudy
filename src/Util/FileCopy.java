package Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/*
* 只要指定编码格式,就必须用 转换流InputStreamReader
* */
public class FileCopy {
    private static String filePath;
    private static String outPath;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入要转换的GBK文件路径:");
        filePath = sc.next();

        System.out.println();
        System.out.print("请输入要输出的UTF-8文件路径:");
        outPath = sc.next();
        sc.close();

        File inF = new File(filePath);
        File outF = new File(outPath);

        try (
                InputStreamReader isr = new InputStreamReader(
                        new FileInputStream(inF), "GBK");
                BufferedReader br = new BufferedReader(isr);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(outF),StandardCharsets.UTF_8
                ))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
