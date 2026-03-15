package parser;

import model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentHandler extends DefaultHandler {

    Student student;
    String content;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equals("student")){
            student = new Student();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length).trim();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(student != null){

            switch(qName){

                case "code":
                    student.setCode(content);
                    break;

                case "name":
                    student.setName(content);
                    break;

                case "age":
                    student.setAge(Integer.parseInt(content));
                    break;

                case "student":
                    System.out.println("Mã SV: " + student.getCode());
                    System.out.println("Tên SV: " + student.getName());
                    System.out.println("Tuổi: " + student.getAge());
                    System.out.println("----------------------");
                    break;
            }
        }
    }
}
