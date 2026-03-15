import parser.StudentHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        try {

            File file = new File("students.xml");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            StudentHandler handler = new StudentHandler();

            saxParser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
