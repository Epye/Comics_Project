package nicolas.quillon.iem.gestion_comics.Modele.pojo;

import java.io.Serializable;

/**
 * Created by iem on 08/12/2017.
 */

public class Creator implements Serializable {
    private String name;
    private String role;

    public Creator() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Creator(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
