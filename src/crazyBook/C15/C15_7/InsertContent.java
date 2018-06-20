package crazyBook.C15.C15_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile依然不能向文件的指定位置插入内容,如果直接将文件记录指针
 * 移动到中间某位置后输出,则输出的内容会覆盖文件中原有的内容.
 * 如果需要向指定位置插入内容,程序需要先把插入点后面的内容读入缓冲区,等把需要
 * 插入的数据写入文件后,再将缓冲区的内容追加到文件后面
 *
 * */
public class InsertContent {
    public static void insert(String fileName, long pos,
                              String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (
                RandomAccessFile raf =
                        new RandomAccessFile(fileName, "rw");
                //使用临时文件来保存插入点后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp)
        ) {
            raf.seek(pos);
            //-----------下面代码将插入点后的内容读入临时文件中保存-----------
            byte[] bbuf = new byte[64];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环方式读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) > 0) {
                //将读取的数据文件写入临时文件
                tmpOut.write(bbuf,0,hasRead);
            }
            //-----------下面代码用于插入内容-----------
            // //把文件记录指针重新定位到pos位置
            System.out.println(raf.getFilePointer());

            raf.seek(pos);
            //追加需要插入的内容
            raf.write(insertContent.getBytes());
            System.out.println(raf.getFilePointer());
            //追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf,0,hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        insert("C:\\Users\\droid\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\JavaInstance.Capter10\\C15_7\\InsertContent.java",
                45, "插入的内容\r\n"
        );
    }
}
