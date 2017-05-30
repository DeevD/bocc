package mm.com.blueplanet.bocc.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smmon on 5/26/17.
 */

public class FortuneResult {
    @SerializedName("date")
    private String publishedDate;

    @SerializedName("message")
    private  String content;

    @SerializedName("keyword")
    private String keyword;

    public FortuneResult(String publishedDate, String content, String keyword) {
        this.publishedDate = publishedDate;
        this.content = content;
        this.keyword = keyword;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
