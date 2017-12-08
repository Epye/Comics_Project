package nicolas.quillon.iem.gestion_comics.model.pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by iem on 05/12/2017.
 */

public class Comic {
    private int id;
    private String title;
    private int issueNumber;
    private String description;
    private String diamondCode;
    private Date date;
    private float price;
    private int pageCount;
    private String image;
    private Creators creators;

    public Comic(int id, String title, int issueNumber, String description, String diamondCode, Date date, float price, int pageCount, String image, Creators creators) {
        this.id = id;
        this.title = title;
        this.issueNumber = issueNumber;
        this.description = description;
        this.diamondCode = diamondCode;
        this.date = date;
        this.price = price;
        this.pageCount = pageCount;
        this.image = image;
        this.creators = creators;
    }


}
