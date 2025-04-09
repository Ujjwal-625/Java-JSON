package Practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student{
    private String name;
    private int age;
    private String[] subjects;

    public Student() {}

    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getSubjects() {
        return subjects;
    }
}

public class CreateJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            Student student1=new Student("name1",10,new String[]{"ajkfa","skdlfjkl"});
            Student student2=new Student("name2",11,new String[]{"ajkfa","skdlfjkl","fkasj"});
            Student student3=new Student("name3",13,new String[]{"ajkfa","skdlfjkl","jfsdklj"});
            Student student4=new Student("name4",12,new String[]{"ajkfa","skdlfjkl","math"});

            List<Student> list=new ArrayList<>();
            list.add(student1);
            list.add(student2);
            list.add(student3);
            list.add(student4);
            objectMapper.writeValue(new File("Student.json"),list);
            System.out.println("File created succefully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
