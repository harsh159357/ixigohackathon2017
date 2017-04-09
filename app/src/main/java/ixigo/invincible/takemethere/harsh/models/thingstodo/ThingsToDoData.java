package ixigo.invincible.takemethere.harsh.models.thingstodo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ThingsToDoData {
    @SerializedName("Things To Do")
    @Expose
    ArrayList<DataThingsToDo> thingsToDoArrayList;

    public ThingsToDoData() {
    }

    public ArrayList<DataThingsToDo> getThingsToDoArrayList() {
        return thingsToDoArrayList;
    }

    public void setThingsToDoArrayList(ArrayList<DataThingsToDo> thingsToDoArrayList) {
        this.thingsToDoArrayList = thingsToDoArrayList;
    }
}
