package ixigo.invincible.takemethere.harsh.models.placestovisit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlacesToVisitData {
    @SerializedName("Places To Visit")
    @Expose
    ArrayList<DataPlacesToVisit> placesToVisitArrayList;

    public PlacesToVisitData() {
    }

    public PlacesToVisitData(ArrayList<DataPlacesToVisit> placesToVisitArrayList) {
        this.placesToVisitArrayList = placesToVisitArrayList;
    }

    public ArrayList<DataPlacesToVisit> getPlacesToVisitArrayList() {
        return placesToVisitArrayList;
    }

    public void setPlacesToVisitArrayList(ArrayList<DataPlacesToVisit> placesToVisitArrayList) {
        this.placesToVisitArrayList = placesToVisitArrayList;
    }
}
