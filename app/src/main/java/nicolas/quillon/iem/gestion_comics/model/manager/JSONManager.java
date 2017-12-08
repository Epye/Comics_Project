package nicolas.quillon.iem.gestion_comics.model.manager;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import nicolas.quillon.iem.gestion_comics.R;
import nicolas.quillon.iem.gestion_comics.model.pojo.Comic;
import nicolas.quillon.iem.gestion_comics.model.pojo.Comics;

/**
 * Created by iem on 05/12/2017.
 */

//context.getFilesDir()+path
public class JSONManager {
    private ObjectMapper objectMapper = null;
    private JsonFactory jsonFactory = null;
    private JsonParser jp = null;
    private ArrayList<Comic> comicList = null;
    private Comics comics = null;
    private String jsonFile;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public JSONManager(Context context, String path) {
        objectMapper = new ObjectMapper();
        jsonFactory = new JsonFactory();
        //jsonFile=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+path); //file not found

        InputStream is = context.getResources().openRawResource(R.raw.ok);
        System.out.println(is);

        try (Scanner scanner = new Scanner(is)) {
            jsonFile=scanner.useDelimiter("\\A").next();
        }
    }

    public void init() {
        try {
            jp = jsonFactory.createParser(jsonFile);
            comics = objectMapper.readValue(jp, Comics.class);
            comicList = comics.get("results");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Comic> getAll() {
        return comicList;
    }

    public Comic findById(int id) {
        return comicList.get(id);
    }
}
