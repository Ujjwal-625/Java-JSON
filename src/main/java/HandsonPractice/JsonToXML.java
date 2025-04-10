package HandsonPractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXML {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode json=objectMapper.readTree(new File("src/SampleData/Data.json"));

        XmlMapper xml=new XmlMapper();

        if(json.isArray()){
            json=objectMapper.createObjectNode().set("The Name will serve As wrapper tag",json);
        }

        String xmlOutput = xml.writerWithDefaultPrettyPrinter().writeValueAsString(json);

        System.out.println("xml contents : ");
        System.out.println(xmlOutput);
    }
}
