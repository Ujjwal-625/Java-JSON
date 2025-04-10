package HandsonPractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseDataToJson {
    public static void main(String[] args) throws IOException {
        String src="src/SampleData/Database.csv";

        List<Map<String,String>> list=ReadFile(src);

        WriteJsonFile(list);
        System.out.println("File written succesfully");
    }

    static List<Map<String,String>> ReadFile(String src){

        List<Map<String,String>> ans=new ArrayList<>();
        try(CSVReader reader=new CSVReader(new FileReader(src))){
            String [] header=reader.readNext();

            if(header==null){
                throw new IOException("Header is empty");
            }

            String [] line;

            while((line=reader.readNext())!=null){
                Map<String,String> map=new LinkedHashMap<>();
                for(int i=0;i<header.length;i++){
                    map.put(header[i],line[i]);
                }
                ans.add(map);
            }
            return ans;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void WriteJsonFile(List<Map<String,String>> list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty Print JSON

        objectMapper.writeValue(new File("src/SampleData/Database.json"), list);
    }
}
