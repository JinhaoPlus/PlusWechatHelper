package top.jinhaoplus.wechathelper.wechat.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;

public class JaxbXmlUtil {

    /**
     * XML转Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, Class... beanClasses) {
        try {
            Arrays.sort(beanClasses, new Comparator<Class>() {
                @Override
                public int compare(Class o1, Class o2) {
                    if (o1.isAssignableFrom(o2))
                        return -1;
                    else if (o2.isAssignableFrom(o1))
                        return 1;
                    return 0;
                }
            });
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClasses);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T user = (T) unmarshaller.unmarshal(new StringReader(xml));
            return user;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Bean转XML
     */
    public static String beanToXml(Object obj) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            //决定是否在转换成xml时同时进行格式化(即按标签自动换行,否则即是一行的xml)
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Marshaller.JAXB_ENCODING xml的编码方式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
