package Practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            JsonNode node=objectMapper.readTree(new File("Student.json"));

            System.out.println("Printing only name and age");
            System.out.println(node.get("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
