package creatingConfig;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

/**
 * Created by Michael on 31/03/2015.
 */
public class FileInteraction {
    /**
     * Save a level into a file
     * @param level, a JSONObject which represent a Level
     */
    public static void saveLevel(JSONObject level, String pathFile){
        try {
            FileWriter file = new FileWriter(pathFile);
            file.write(level.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JSONObject loadLevel(String pathFile){
        String json="";
        try{
            InputStream flux=new FileInputStream(pathFile); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                json+=ligne+"\n";
            }
            buff.close(); 
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JSONObject jsonLevel = new JSONObject(json);
        return jsonLevel;
    }
}
