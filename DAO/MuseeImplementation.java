package DAO;

import Model.Musee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author MichkaDaCoder
 */
public class MuseeImplementation {

    public MuseeImplementation() {
        
    }
    public List<Musee> getMuseesList() {
        final String JSON_FILE = "c:\\users\\user\\desktop\\musees.json";
        List<Musee> listMusees = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(JSON_FILE);
            JsonReader jr = Json.createReader(is);
            JsonObject jo = jr.readObject();
            JsonArray ja = jo.getJsonArray("records");

            for (int i = 0; i < ja.size(); i++) {
                JsonObject jo1 = ja.getJsonObject(i);
                JsonObject fields = jo1.getJsonObject("fields");
                String nom = fields.getString("nom_du_musee");
                System.out.println(nom);
                listMusees.add(new Musee(nom));
            }
            
        } catch (IOException ex) {
            System.err.println("Failed to open JSON file.");
        } catch (NullPointerException ex) {
            System.err.println("Corrupted JSON file.");
        }
        return listMusees;
    }
}
