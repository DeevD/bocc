package mm.com.blueplanet.bocc.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smmon on 5/16/17.
 */

public class BeautyTip {

    @SerializedName("id")
    private Integer id;

    @SerializedName("date")
    private  String date;

    @SerializedName("content")
    private  String content;

    public BeautyTip(Integer id, String date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }



    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
