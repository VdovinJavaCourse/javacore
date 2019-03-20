package Lesson121;

import java.io.File;
import java.util.List;

public class XmlParserDemo {


    public static void main(String[] args) {
        File fileWithXml = null;
        try {
            fileWithXml = new File("C:\\Users\\Катя\\IdeaProjects\\EpamJavaCore\\src\\Lesson12\\Countries.xml");
            List<Country> countries = new DomXmlParser().parse(fileWithXml.getAbsolutePath());
            for (Country country : countries) {
                System.out.println(country + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

