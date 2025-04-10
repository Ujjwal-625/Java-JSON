package HandsonPractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class EmailValidation {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();

        JsonNode schemaNode=objectMapper.readTree(new File("src/SampleData/EmailSchema.json"));

        JsonSchemaFactory factory=JsonSchemaFactory.byDefault();

        JsonSchema schema=factory.getJsonSchema(schemaNode);

        JsonNode email=objectMapper.readTree(new File("src/SampleData/Email.json"));

        if(email.isArray()){
            for(JsonNode e:email){
                if(schema.validate(e).isSuccess()){
                    System.out.println("valid mail"+ e);
                }
                else{
                    System.out.println("Invalid  Mail : "+e);
                }
            }
        }
    }
}
