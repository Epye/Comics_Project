package nicolas.quillon.iem.gestion_comics.Modele.manager;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comic;

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public JSONManager(String path) {
        objectMapper = new ObjectMapper();
        jsonFactory = new JsonFactory();
        jsonFile=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+path);
    }

    public void init() {
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
        return comics;
    }

    public Comic findById(int id) {
        return comics.getResults().get(id);
    }
}
