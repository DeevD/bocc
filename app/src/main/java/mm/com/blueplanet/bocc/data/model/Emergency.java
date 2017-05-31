package mm.com.blueplanet.bocc.data.model;

import java.io.Serializable;

/**
 * Created by Lenovo on 5/25/2017.
 */

public class Emergency implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    String name;
    String phone;

    public Emergency(String name, String phone, String details, String desc, int icon) {
        this.name = name;
        this.phone = phone;
        this.details = details;
        this.desc = desc;
        this.icon = icon;
    }

    String details;
    String desc;
    int icon;
}
