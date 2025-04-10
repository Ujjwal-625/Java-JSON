package HandsonPractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJson {
    public static void main(String[] args) throws IOException {
        System.out.println("Printing all keys and values");
        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode dataNode=objectMapper.readTree(new File("src/SampleData/Data.json"));

        if(dataNode.isArray()){
            for(JsonNode node: dataNode){
                System.out.println("-------------------");
                Iterator<Map.Entry<String ,JsonNode>> it=node.fields();
                while (it.hasNext()){
                    Map.Entry<String,JsonNode> entry=it.next();
                    System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue());
                }
            }
            System.out.println("-------------------");
        }
    }
}
