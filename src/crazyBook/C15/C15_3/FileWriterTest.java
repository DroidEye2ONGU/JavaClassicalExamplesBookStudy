package crazyBook.C15.C15_3;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        try (
                FileWriter fw =
                        new FileWriter("poem.txt")
        ) {
            fw.write("锦瑟-李商隐\r\n");
            fw.write("锄禾日当午\r\n");
            fw.write("汗滴和吓哭\r\n");
            fw.write("谁知白裤档\r\n");
            fw.write("压枪真辛苦\r\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
