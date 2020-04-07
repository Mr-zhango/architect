package cn.myfreecloud;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author: zhangyang
 * @date: 2020/4/7 19:08
 * @description: 解析xml
 */
public class XMLDemo {

    public static void main(String[] args) throws DocumentException {
        // xml解析器
        SAXReader saxReader = new SAXReader();
        // 获取文件
        Document read = saxReader.read(new File("D:\\idea_projects\\architect\\04_SpringIOC\\src\\main\\resources\\stu.xml"));
        // 获取根节点
        Element rootElement = read.getRootElement();
        // 解析根节点
        getNodes(rootElement);

    }

    static public void getNodes(Element rootElement) {
        System.out.println("当前节点名称:" + rootElement.getName());
        // 获取属性ID
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        if (!rootElement.getTextTrim().equals("")) {
            System.out.println(rootElement.getName() + "--" + rootElement.getText());
        }
        // 使用迭代器遍历
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }

    }

}
