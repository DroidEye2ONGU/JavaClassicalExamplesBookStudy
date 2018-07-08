package ELSE.XML.Day02.parsexml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

@SuppressWarnings("all")
public class Dom4jTest {
	public void createDom(String file){
		//获得文档对象
		Document document = DocumentHelper.createDocument();
		
		//添加根元素
		Element root = document.addElement("root");
		//根元素下面添加子元素及其属性
		Element city = root.addElement("city");
		city.addAttribute("name", "上海");
		//city元素下面添加子元素及其文本值
		Element num = city.addElement("peopleNumber");
		num.addText("9527");
		
		try {
//			输出格式化xml
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xw = new XMLWriter(new FileOutputStream(new File(file)),format);
			xw.write(document);
			xw.flush();
			xw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readXML(String filePath){
		
		try {
			//获得一个SAXReader对象
			SAXReader reader = new SAXReader();
			File file = new File(filePath);
			//读取这个要解析的xml文件
			Document document = reader.read(file);
			
			//获得document中的根节点
			Element rootElement = document.getRootElement();
			//获得根节点下面所有的子节点
			List<Element> elements = rootElement.elements();
			//遍历elements集合,拿到每一个子节点
			for(Element e:elements){
				
				/*Dom4J核心代码
				//获得元素的名字和文本值
				e.getName();
				e.getText();
				//获得元素中所有属性
				List<Attribute> attributes = e.attributes();
				for(Attribute att:attributes){
					System.out.println(att.getName()+"  "+att.getValue());
				}*/
				
				String s = e.attributeValue("name");
				System.out.println(e.getName()+"节点的name属性的值为: "+s);
				
				//获得当前这个子节点下面所有的子节点
				List<Element> elements2 = e.elements();
				//遍历elements2集合,拿到每一个子节点
				for(Element e2:elements2){
					System.out.println(e2.getName()+": "+e2.getText());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Dom4jTest t = new Dom4jTest();
		String filePath = "src/ELSE/XML/Day02/parsexml/dom4j/test3.xml";
		t.createDom(filePath);
//		t.readXML(filePath);
	}
}
