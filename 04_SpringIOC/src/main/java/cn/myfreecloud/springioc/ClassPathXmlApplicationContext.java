package cn.myfreecloud.springioc;

import cn.myfreecloud.reflex.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author: zhangyang
 * @date: 2020/4/10 18:29
 * @description:
 */
public class ClassPathXmlApplicationContext {

    public String xmlPath;


    public ClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws ParserConfigurationException, SAXException, DocumentException,
            ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        // 1.读取xml配置文件

        // 创建SAXReader对象
        SAXReader reader = new SAXReader();
        // 读取文件 转换成Document，获取当前项目路径
        Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));
        // 获取节点对象
        Element rootElement = document.getRootElement();
        // 找出根节点的所有element元素
        List<Element> elements = rootElement.elements();

        // 返回的对象
        Object instance = null;
        if (elements != null) {
            //2.获取每个bean配置，获取class
            for (Element sonElement : elements) {
                // 获得beanid
                String sonbenId = sonElement.attributeValue("id");

                if (!beanId.equals(sonbenId)) {
                    // 结束本次循环
                    continue;
                }
                // 获得class
                String beanClassPath = sonElement.attributeValue("class");
                // 3.拿到class地址，进行反射实例化对象，再通过反射api为私有变量赋值
                Class<?> forName = Class.forName(beanClassPath);
                // 实例化class
                instance = forName.newInstance();
                // 拿到成员属性
                List<Element> sonSonEleList = sonElement.elements();
                for (Element sonSonEle : sonSonEleList) {
                    // 获取每个bean中的id,name
                    String name = sonSonEle.attributeValue("name");
                    String value = sonSonEle.attributeValue("value");
                    //使用反射为name和value进行赋值
                    /*Field fieldName = forName.getDeclaredField(name);*/
                    Field fieldName = forName.getDeclaredField(name);
                    // 允许向私有变量赋值
                    fieldName.setAccessible(true);
                    fieldName.set(instance, value);
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws IllegalAccessException, DocumentException, SAXException, InstantiationException, NoSuchFieldException, ParserConfigurationException, ClassNotFoundException {
        //调用ClassPathXmlApp
        ClassPathXmlApplicationContext pathXmlApplicationContent = new ClassPathXmlApplicationContext("user.xml");
        Object bean = pathXmlApplicationContent.getBean("user1");
        User userEntity = (User) bean;
        System.out.println("User is " + userEntity.getUserName() + userEntity.getUserId());

    }

}