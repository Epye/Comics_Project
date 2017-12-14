package nicolas.quillon.iem.gestion_comics.Modele.manager;

import android.os.Environment;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comic;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;

/**
 * Created by iem on 05/12/2017.
 */

//context.getFilesDir()+path
public class JSONManager {
    private ObjectMapper objectMapper = null;
    private JsonFactory jsonFactory = null;
    private JsonParser jp = null;
    private Comics comics;
    private File jsonFile;

    public JSONManager(String path) {
        objectMapper = new ObjectMapper();
        jsonFactory = new JsonFactory();

        jsonFile=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+path);

        try {
            jp = jsonFactory.createParser(jsonFile);
            comics = objectMapper.readValue(jp, Comics.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Comics getAll() {
        if(comics == null){
            return new Comics("200", new ArrayList<Comic>());
        }
        return comics;
    }

    public Comic findByIndex(int id) {
        return comics.getResults().get(id);
    }
}
