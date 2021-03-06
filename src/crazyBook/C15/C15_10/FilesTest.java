package crazyBook.C15.C15_10;


import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilesTest {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_10\\FilesTest.java");
        //复制文件
        Files.copy(
                Paths.get("C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_10\\FilesTest.java"),
                new FileOutputStream("a.txt")
        );
        //判断FilesTest.java是否为隐藏文件
        System.out.println("FilesTest.java是否为隐藏文件: " +
                Files.isHidden(Paths.get("C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_10\\FilesTest.java")));
        //一次性读取FilesTest.java文件所有行
        List<String> lines = Files.readAllLines(
                Paths.get("C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_10\\FilesTest.java"),
                StandardCharsets.UTF_8
        );
        //System.out.println(lines);
        for (String line : lines) {
            System.out.println(line);
        }
        //判断指定文件的大小
        System.out.println("FilesTest.java的大小为: " +
                Files.size(path)
        );

        List<String> poem = new ArrayList<>();
        poem.add("水晶谭底银鱼跃");
        poem.add("清徐风中碧竿横");
        //直接将多个字符写入指定文件中
        Files.write(Paths.get("poem.txt"), poem,
                StandardCharsets.UTF_8);
        //使用java 8新增的StreamAPI 列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(
                patht -> System.out.println(patht)
        );
        //使用java 8新增的StreamAPI读取文件内容
        Stream<String> lines1 = Files.lines(path, Charset.forName("UTF-8"));
        lines1.forEach(line -> System.out.println(line));
        FileStore cStore = Files.getFileStore(Paths.get("c:"));
        //判断C盘的总空间,可用空间
        System.out.println("C:总空间:" + cStore.getTotalSpace() / 1024 / 1024);
        System.out.println("c:可用空间" + cStore.getUsableSpace() / 1024 / 1024);
    }
}

