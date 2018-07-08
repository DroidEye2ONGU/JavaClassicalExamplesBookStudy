package ELSE.XML.Day02.parsexml.jaxpdom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ELSE.XML.Day02.parsexml.bean.Student;


public class DomXml {
	
	//解析文件，将值保存到Student对象中，然后返回List
	public List<Student> parseXML(String fileName) throws Exception{
		//获得一个负责生产DocumentBuilder对象的工厂实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//设置是否支持名称空间(无所谓)
		factory.setNamespaceAware(true);
		
		//通过工厂获得一个DocumentBuilder对象,DocumentBuilder可以获得Document对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		/*//如果是xml上面声明了对DTD的引用,则可以这样忽略掉DTD,否则会自动根据地址查找DTD
		builder.setEntityResolver(new EntityResolver() {
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				byte[] data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes();
				return new InputSource(new ByteArrayInputStream(data));
			}
		});*/
		
		//获得Document对象,这个对象可以表示一个文档,例如一个xml文档
		Document document = builder.parse(fileName);
		
		//获得根元素
		Element root = document.getDocumentElement();
//		System.out.println(root.getNodeName());
		
		//获得根元素下面的所有子元素(空格、换行也算是 文本元素)
		NodeList rootChildNodes = root.getChildNodes();
		System.out.println("lenght: "+rootChildNodes.getLength());
		//注意，即使越界访问，也不会报错，输出null即可
		//System.out.println("0: " + rootChildNodes.item(0));
		//System.out.println("1: " + rootChildNodes.item(1));
		//System.out.println("2: " + rootChildNodes.item(2));
		//System.out.println("3: " + rootChildNodes.item(3));
		//System.out.println("4: " + rootChildNodes.item(4));
	
//		String sname = rootChildNodes.item(0).getAttributes().getNamedItem("sname").getNodeValue();
//		System.out.println(sname);
		
		List<Student> list = new ArrayList<>();
		Student s = null;
		for(int i = 0; i < rootChildNodes.getLength(); i++){
			//item(i)获取第i个元素,从0开始
			Node node = rootChildNodes.item(i);
			//获取节点类型   ELEMENT_NODE元素节点
			if(node.getNodeType() == Node.ELEMENT_NODE){
				s = new Student();
				//根据节点和对象，进行数据填充  node: stu
				getStu(node,s);
				NodeList stuChildNodes = node.getChildNodes();
				
				for(int j=0;j<stuChildNodes.getLength();j++){
					//node2: name age还是元素节点
					Node node2 = stuChildNodes.item(j);
					if(node2.getNodeType() == Node.ELEMENT_NODE){
						getStu(node2,s);
					}
				}
				list.add(s);
			}
		}
		return list;
	}
	
	//将节点中的学生信息提取出来，写入stu对象中
	private void getStu(Node node,Student stu) {
		if(node.getNodeType() == Node.ELEMENT_NODE){
			//获取节点名称，然后操作
			if("stu".equals(node.getNodeName())) {
				//根据节点获取其属性
				String id = node.getAttributes().getNamedItem("id").getNodeValue();
				stu.setId(Long.parseLong(id));
			}else if("name".equals(node.getNodeName())) {
				//获取节点 里面的文本内容值
				String name = node.getTextContent();
				stu.setName(name);
			}else if("age".equals(node.getNodeName())) {
				String age = node.getTextContent();
				stu.setAge(Integer.parseInt(age));
			}
		}
	}
	
	//更新指定xml文件中 学生信息(根据id)
	public void update(String fileName,Student stu)throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileName);
		
		//根据 元素名称 获取元素
		NodeList elementsByTagName = document.getElementsByTagName("stu");
		for(int i=0;i<elementsByTagName.getLength();i++){
			Node node = elementsByTagName.item(i);
			//获取id值
			String idValue = node.getAttributes().getNamedItem("id").getNodeValue();
			//根据id值确定要更新的对象
			if(idValue.equals(stu.getId()+"")){
				NodeList childNodes = node.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++){
					Node child = childNodes.item(j);
					if(child.getNodeType()==Node.ELEMENT_NODE){
						if("name".equals(child.getNodeName())){
							child.setTextContent(stu.getName());
						}
						else if("age".equals(child.getNodeName())){
							child.setTextContent(stu.getAge()+"");
						}
					}
				}
				
				break;
			}
			
		}
		
		//得到TransformerFactory工厂实例
		TransformerFactory tff = TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf = tff.newTransformer();
		//设置编码
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//设置格式
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//把一个dom模型转换成对应的xml文件
		tf.transform(new DOMSource(document), new StreamResult(fileName));
		
	}
	
	//根据id,删除xml文件中学生
	public void remove(String fileName,String stu_id)throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileName);
		
		//获取所有stu元素节点
		NodeList elementsByTagName = document.getElementsByTagName("stu");
		//遍历元素节点，根据id找到对应哪个
		for(int i=0;i<elementsByTagName.getLength();i++){
			Node node = elementsByTagName.item(i);
			//获取属性id值
			String idValue = node.getAttributes().getNamedItem("id").getNodeValue();
			//如果找到对应的那个元素
			if(idValue.equals(stu_id)){
				//根据当前元素找到父元素，然后通过父元素删除 该元素
				node.getParentNode().removeChild(node);
				break;
			}
		}
		
		//得到TransformerFactory工厂实例
		TransformerFactory tff = TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf = tff.newTransformer();
		//设置编码
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//设置格式
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//把一个dom模型转换成对应的xml文件
		tf.transform(new DOMSource(document), new StreamResult(fileName));
	}
	
	//增加xml文件节点
	public void add(String fileName,Student s)throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileName);
		
		//创建一个stu元素 并且设置属性
		Element stu = document.createElement("stu");
		stu.setAttribute("id", s.getId()+"");
		//创建name和age元素
		Element name = document.createElement("name");
		Element age = document.createElement("age");
		//设置name和age元素中的文本值
		name.setTextContent(s.getName());
		age.setTextContent(s.getAge()+"");
		
		//name和age元素追加到stu元素里面
		stu.appendChild(name);
		stu.appendChild(age);
		
		//stu元素追加到根元素里面
		document.getDocumentElement().appendChild(stu);
		
		//将document里面的内容，写入到本地xml文件
		//得到TransformerFactory工厂实例
		TransformerFactory tff = TransformerFactory.newInstance();
		//通过工厂得到一个转换器
		Transformer tf = tff.newTransformer();
		//设置编码
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//设置格式(没有格式的话，写进去就是一整行数据)
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//最关键的一步来了
		//把一个dom模型转换成对应的xml文件
		tf.transform(new DOMSource(document), new StreamResult(fileName));
	}
	
	public static void main(String[] args) {
		DomXml dr = new DomXml();
		try {
			List<Student> list = dr.parseXML("src/ELSE/XML/Day02/parsexml/jaxpdom/class.xml");
			for(Student st:list){
				System.out.println(st);
			}
			dr.add("src/ELSE/XML/Day02/parsexml/jaxpdom/class.xml",new Student(2016011,"张三",30));
//			dr.update("src/ELSE/XML/Day02/parsexml/jaxpdom/class.xml", new Student(2016002,"李四",23));
//			dr.remove("src/ELSE/XML/Day02/parsexml/jaxpdom/class.xml"", "2016011");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
