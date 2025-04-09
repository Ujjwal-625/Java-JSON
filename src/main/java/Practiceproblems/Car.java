package Practiceproblems;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Car {
    String name;
    String model;
    int price;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public String getGetName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Test{
    public static void main(String[] args) {
        Car c=new Car();
        c.setModel("ABC");
        c.setName("DEF");
        c.setPrice(9803739);

        ObjectMapper objectMapper=new ObjectMapper();

        try{
            String jsonString =objectMapper.writeValueAsString(c);
            System.out.println("Json car object is : "+jsonString);
        }
         catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
