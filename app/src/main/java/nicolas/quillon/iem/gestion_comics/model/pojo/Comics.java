package nicolas.quillon.iem.gestion_comics.model.pojo;

import java.util.ArrayList;

/**
 * Created by iem on 08/12/2017.
 */

public class Comics{
    private String code;
    private ArrayList<Comic> results;

    public Comics() {
    }

    public Comics(String code, ArrayList<Comic> results) {
        this.code = code;
        this.results = results;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Comic> getResults() {
        return results;
    }

    public void setResults(ArrayList<Comic> results) {
        this.results = results;
    }
}
