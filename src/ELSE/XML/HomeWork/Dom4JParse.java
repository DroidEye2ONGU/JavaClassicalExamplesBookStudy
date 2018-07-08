package ELSE.XML.HomeWork;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Dom4JParse {
    public List<Student> getStudentsFromXml(String filePath) {
        List<Student> students = new ArrayList<>();
        try {
            //获得一个SAXReader对象
            SAXReader saxReader = new SAXReader();
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("文件不存在");
            }

            //读取这个要解析的XML文件
            Document document = saxReader.read(file);

            //获取document中的根节点
            Element rootElement = document.getRootElement();
            //获得根节点下的所有子节点
            List<Element> elements = rootElement.elements();

            //遍历elements集合,拿到每一个子节点
            for (Element e :
                    elements) {
                String id = e.attributeValue("id");
                String name = e.elementText("name");
                String age = e.elementText("age");
                String city = e.element("address").elementText("city");
                students.add(new Student(Integer.parseInt(id),
                        Integer.parseInt(age), name, city));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        Dom4JParse dom4JParse = new Dom4JParse();
        List<Student> students = dom4JParse.getStudentsFromXml("src/ELSE/XML/HomeWork/student.xml");
        students.forEach(s-> System.out.println(s));
    }
}
