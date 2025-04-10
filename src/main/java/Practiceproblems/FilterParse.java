package Practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FilterParse {
    public static void main(String[] args) {
        System.out.println("Printing all reecords with age grater than 25");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            JsonNode dataNode=objectMapper.readTree(new File("src/SampleData/Data.json"));
            if(dataNode.isArray()){
                for(JsonNode node:dataNode){
                    if(node.has("age") && node.get("age").asInt()>25){
                        System.out.println(node);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
