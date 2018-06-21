package crazyBook.C8.C8_6;
import java.util.*;
import java.io.*;

public class PropertiesTest
{
	public static void main(String[] args)
		throws Exception
	{
		Properties props = new Properties();
		// 向Properties中增加属性
		props.setProperty("username" , "yeeku");
		props.setProperty("password" , "123456");
		// 将Properties中的key-value对保存到a.ini文件中
		props.store(new FileOutputStream("a.ini")
			, "comment line");   //①
		// 新建一个Properties对象
		Properties props2 = new Properties();
		// 向Properties中增加属性
		props2.setProperty("gender" , "male");
		// 将a.ini文件中的key-value对追加到props2中
		props2.load(new FileInputStream("a.ini") );   //②
		System.out.println(props2);
	}
}
