package crazyBook.C15.C15_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//自己练习,从一个文本文件中读取到字符输出到控制台
public class InputStreamReaderTest2 {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream =
                        new FileInputStream("poem.txt");
                InputStreamReader inputStreamReader =
                        new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader =
                        new BufferedReader(inputStreamReader);


                BufferedReader bufferedReader1 =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream("poem.txt")))

        ) {

            String line = null;
            while ((line = bufferedReader1.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
