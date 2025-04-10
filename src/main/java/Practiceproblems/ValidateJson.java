package Practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode node=objectMapper.readTree(new File("src/SampleData/ValidSchema.json"));

        JsonSchemaFactory factory=JsonSchemaFactory.byDefault();

        JsonSchema schema= factory.getJsonSchema(node);

        JsonNode dataNode=objectMapper.readTree(new File("src/SampleData/Data.json"));

        if(schema.validate(dataNode).isSuccess()){
            System.out.println("Valid json data provided");
        }
        else{
            System.out.println("Invalid  json data provided");
        }
    }
}
