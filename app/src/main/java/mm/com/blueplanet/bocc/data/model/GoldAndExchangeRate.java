package mm.com.blueplanet.bocc.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smmon on 5/23/17.
 */

public class GoldAndExchangeRate {

    @SerializedName("date")
    private String date;

    @SerializedName("message")
    private  String message;

    public GoldAndExchangeRate(String date, String message) {
        this.date = date;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
