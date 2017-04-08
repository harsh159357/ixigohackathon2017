package ixigo.invincible.takemethere.harsh.models.recommendations;


import android.os.Parcel;
import android.os.Parcelable;

public class FlightData implements Parcelable {
    private String image;
    private String countryName;
    private String url;
    private String data;
    private String text;
    private String type;
    private String cityName;
    private String stateName;
    private int price;
    private String currency;
    private String cityId;
    private String destinationCategories[];

    public FlightData() {
    }

    public FlightData(String image, String countryName, String url, String data, String text, String type, String cityName, String stateName, int price, String currency, String cityId, String[] destinationCategories) {
        this.image = image;
        this.countryName = countryName;
        this.url = url;
        this.data = data;
        this.text = text;
        this.type = type;
        this.cityName = cityName;
        this.stateName = stateName;
        this.price = price;
        this.currency = currency;
        this.cityId = cityId;
        this.destinationCategories = destinationCategories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String[] getDestinationCategories() {
        return destinationCategories;
    }

    public void setDestinationCategories(String[] destinationCategories) {
        this.destinationCategories = destinationCategories;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.countryName);
        dest.writeString(this.url);
        dest.writeString(this.data);
        dest.writeString(this.text);
        dest.writeString(this.type);
        dest.writeString(this.cityName);
        dest.writeString(this.stateName);
        dest.writeInt(this.price);
        dest.writeString(this.currency);
        dest.writeString(this.cityId);
        dest.writeStringArray(this.destinationCategories);
    }

    protected FlightData(Parcel in) {
        this.image = in.readString();
        this.countryName = in.readString();
        this.url = in.readString();
        this.data = in.readString();
        this.text = in.readString();
        this.type = in.readString();
        this.cityName = in.readString();
        this.stateName = in.readString();
        this.price = in.readInt();
        this.currency = in.readString();
        this.cityId = in.readString();
        this.destinationCategories = in.createStringArray();
    }

    public static final Parcelable.Creator<FlightData> CREATOR = new Parcelable.Creator<FlightData>() {
        @Override
        public FlightData createFromParcel(Parcel source) {
            return new FlightData(source);
        }

        @Override
        public FlightData[] newArray(int size) {
            return new FlightData[size];
        }
    };
}
