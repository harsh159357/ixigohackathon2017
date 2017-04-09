package ixigo.invincible.takemethere.harsh.models.hotels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HotelsData {
    @SerializedName("Hotel")
    @Expose
    ArrayList<DataHotels> hotelsArrayList;

    public HotelsData() {
    }

    public HotelsData(ArrayList<DataHotels> hotelsArrayList) {
        this.hotelsArrayList = hotelsArrayList;
    }

    public ArrayList<DataHotels> getHotelsArrayList() {
        return hotelsArrayList;
    }

    public void setHotelsArrayList(ArrayList<DataHotels> hotelsArrayList) {
        this.hotelsArrayList = hotelsArrayList;
    }
}
