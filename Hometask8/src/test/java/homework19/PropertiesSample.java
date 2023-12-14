//package homework19;
//
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Properties;
//
//public class PropertiesSample {
//
//    public static void main(String[] args) {
//
//
//        File file = new File("Hometask8/src/test/resources/homework19.properties");
//
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader(file));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////        return properties;
//        String name = properties.getProperty("name", "dot");
//        String email = properties.getProperty("email");
//        String subject = properties.getProperty("subject");
//
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(subject);
//
//    }
////    public String getName(){
////        return this.getProperties().getProperty("name", "dot");
////    }
////
////    public String getEmail(){
////        return this.getProperties().getProperty("email" );
////    }
////
////    public String getSubject(){
////        return this.getProperties().getProperty("subject" );
////    }
//}
