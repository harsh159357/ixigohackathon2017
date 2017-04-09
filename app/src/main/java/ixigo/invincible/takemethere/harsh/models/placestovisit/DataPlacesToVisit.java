package ixigo.invincible.takemethere.harsh.models.placestovisit;

import android.os.Parcel;
import android.os.Parcelable;

public class DataPlacesToVisit implements Parcelable {
    private String address;
    private String categoryNames[];
    private String cityName;
    private String countryName;
    private String description;
    private String cityId;
    private String xid;
    private String latitude;
    private String longitude;
    private String name;
    private String stateName;
    private String shortDescription;
    private String id;

    public DataPlacesToVisit() {
    }

    public DataPlacesToVisit(String address, String[] categoryNames, String cityName, String countryName, String description, String cityId, String xid, String latitude, String longitude, String name, String stateName, String shortDescription, String id) {
        this.address = address;
        this.categoryNames = categoryNames;
        this.cityName = cityName;
        this.countryName = countryName;
        this.description = description;
        this.cityId = cityId;
        this.xid = xid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.stateName = stateName;
        this.shortDescription = shortDescription;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(String[] categoryNames) {
        this.categoryNames = categoryNames;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeStringArray(this.categoryNames);
        dest.writeString(this.cityName);
        dest.writeString(this.countryName);
        dest.writeString(this.description);
        dest.writeString(this.cityId);
        dest.writeString(this.xid);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.name);
        dest.writeString(this.stateName);
        dest.writeString(this.shortDescription);
        dest.writeString(this.id);
    }

    protected DataPlacesToVisit(Parcel in) {
        this.address = in.readString();
        this.categoryNames = in.createStringArray();
        this.cityName = in.readString();
        this.countryName = in.readString();
        this.description = in.readString();
        this.cityId = in.readString();
        this.xid = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.name = in.readString();
        this.stateName = in.readString();
        this.shortDescription = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<DataPlacesToVisit> CREATOR = new Parcelable.Creator<DataPlacesToVisit>() {
        @Override
        public DataPlacesToVisit createFromParcel(Parcel source) {
            return new DataPlacesToVisit(source);
        }

        @Override
        public DataPlacesToVisit[] newArray(int size) {
            return new DataPlacesToVisit[size];
        }
    };
}
