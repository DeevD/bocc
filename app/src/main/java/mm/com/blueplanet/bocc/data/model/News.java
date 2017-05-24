package mm.com.blueplanet.bocc.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smmon on 5/24/17.
 */

public class News
{
    @SerializedName("keyword")
    private String keyword;

    @SerializedName("message")
    private String message;

    @SerializedName("date")
    private  String date;

    public News(String keyword, String message, String date) {
        this.keyword = keyword;
        this.message = message;
        this.date = date;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
