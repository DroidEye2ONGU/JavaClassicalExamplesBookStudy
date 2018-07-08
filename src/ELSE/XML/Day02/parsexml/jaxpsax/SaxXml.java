package ELSE.XML.Day02.parsexml.jaxpsax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ELSE.XML.Day02.parsexml.bean.Student;


public class SaxXml {
	private Student s;
	private List<Student> list = new ArrayList<Student>();
	
	public void parse(String path) throws Exception {
		//File file = new File("src/com/briup/parsexml/jaxpsax/namespace.xml");
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		
		//1.获得工厂实例
		SAXParserFactory factroy = SAXParserFactory.newInstance();
		//是否支持命名空间
//		factroy.setNamespaceAware(true);
		
		//2.使用工厂创建SAX解析器
		SAXParser saxParser = factroy.newSAXParser();
		
		//3.开始解析
		saxParser.parse(file, new DefaultHandler(){
			//记录当前解析的标签
			private String currentTagName;
			
			@Override
			public void startDocument() throws SAXException {
				System.out.println("sax解析器开始解析xml文档!");
			}

			@Override
			public void endDocument() throws SAXException {
				System.out.println("sax解析器解析xml文档结束");
			}
			
			//uri         命名空间
		    //localName   本地名称（不带前缀）
		    //qName       限定的名称（带有前缀） 
			//attributes  附加到元素的属性
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				//记录当前解析的标签
				this.currentTagName = qName;
				if("stu".equals(qName)) {
					s = new Student();
					//根据key获取值
					String id = attributes.getValue("id");
					s.setId(Long.parseLong(id));
				}
			}
			
			//uri         命名空间
		    //localName   本地名称  （不带前缀）
		    //qName       限定的名称（带有前缀） 
			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				//当解析到结束标签时
				if("stu".equals(qName)) {
					list.add(s);
				}
				//清空当前解析标签(当前解析已经完成)
				currentTagName = null;
			}
			
			
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				//进入文本中  获取其值
				//注意获取到的值是  王五(name) 或 43(age)
				String str = new String(ch,start,length);
				
				//根据当前解析标签值 进行处理
				if("name".equals(currentTagName)) {
					s.setName(str);
				}else if("age".equals(currentTagName)) {
					s.setAge(Integer.parseInt(str));
				}
			}
		});
		
		//解析完成后，去遍历一下，看是否成功
		for(Student stu:list){
			System.out.println(stu);
		}
		
	}

	public static void main(String[] args) {

		SaxXml st = new SaxXml();
		String path = "src/ELSE/XML/Day02/parsexml/jaxpsax/class.xml";
		try {
			st.parse(path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
