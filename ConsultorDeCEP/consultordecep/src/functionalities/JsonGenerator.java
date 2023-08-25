package functionalities;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Address;

public class JsonGenerator {
    
    public void generate(Address address) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(address.cep() + ".json");
        writer.write(gson.toJson(address));
        writer.close();
        
    }
}
