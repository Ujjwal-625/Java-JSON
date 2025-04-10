package Practiceproblems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectsToJson {
    public static void main(String[] args) {
        List<Student> studentsList=new ArrayList<>();

        Student student1=new Student("name1",10,new String[]{"ajkfa","skdlfjkl"});
        Student student2=new Student("name2",11,new String[]{"ajkfa","skdlfjkl","fkasj"});
        Student student3=new Student("name3",13,new String[]{"ajkfa","skdlfjkl","jfsdklj"});
        Student student4=new Student("name4",12,new String[]{"ajkfa","skdlfjkl","math"});

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);

        ObjectMapper objectMapper=new ObjectMapper();

        //converting to json

        try {
            String jsonData=objectMapper.writeValueAsString(studentsList);

            System.out.println("Object to Json : "+jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
