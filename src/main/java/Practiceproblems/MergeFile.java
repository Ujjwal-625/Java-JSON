package Practiceproblems;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student1{
    String name;
    int age;
    String [] Subjects;

    Student1(){

    }

    public Student1(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.Subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubjects(String[] subjects) {
        Subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getSubjects() {
        return Subjects;
    }
}

public class MergeFile {
    public static void main(String[] args) {
        ObjectMapper objectMapper=new ObjectMapper();
        List<Student1> Students=new ArrayList<>();
        try{
            //since our json file contains array of objects that why we have to specify like this

            Student1 [] s1= objectMapper.readValue(new File("src/Merge1.json"), Student1[].class);
            Student1 []  s2=objectMapper.readValue(new File("src/Merge2.json"),Student1[].class);

            Students.addAll(Arrays.asList(s1));
            Students.addAll(Arrays.asList(s2));
            objectMapper.writeValue(new File("src/MergedFile.json"),Students);

            System.out.println("File meged Succesfully");
        } catch (StreamReadException e) {
            System.out.println(e.getMessage());
        } catch (DatabindException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
