package nicolas.quillon.iem.gestion_comics.Modele.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by iem on 05/12/2017.
 */

public class Comic implements Serializable {
    private int id;
    private int digitalId=0;
    private String title;
    private int issueNumber;
    private String variantDescription="";
    private String description;
    private String diamondCode;
    private String date;
    private float price;
    private int pageCount;
    private String image;
    private Creator[] creators;

    public Comic() {
    }

    public Comic(int id, String title, int issueNumber, String description, String diamondCode, String date, float price, int pageCount, String image, Creator[] creators) {
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

    public Comic(int id, int digitalId, String title, int issueNumber, String variantDescription, String description, String diamondCode, String date, float price, int pageCount, String image, Creator[] creators) {
        this.id = id;
        this.digitalId = digitalId;
        this.title = title;
        this.issueNumber = issueNumber;
        this.variantDescription = variantDescription;
        this.description = description;
        this.diamondCode = diamondCode;
        this.date = date;
        this.price = price;
        this.pageCount = pageCount;
        this.image = image;
        this.creators = creators;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getDate() {
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try{
            d = formatter.parse(date.substring(0, date.length()-4));
        }catch (Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE dd/MM/yyyy");
        return outFormat.format(d);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Creator[] getCreators() {
        return creators;
    }

    public void setCreators(Creator[] creators) {
        this.creators = creators;
    }
}
