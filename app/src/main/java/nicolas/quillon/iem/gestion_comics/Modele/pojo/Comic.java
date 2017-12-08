package nicolas.quillon.iem.gestion_comics.Modele.pojo;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }
}
