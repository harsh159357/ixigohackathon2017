package ixigo.invincible.takemethere.haimal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ixigo.invincible.takemethere.R;
import ixigo.invincible.takemethere.haimal.Utils.LogClass;
import ixigo.invincible.takemethere.haimal.asyncclasses.GetCityPredictions;
import ixigo.invincible.takemethere.haimal.modals.City;


public class AutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List<City> resultList = new ArrayList<>();
    private static final String TAG = "AutoCompleteAdapter";

    public AutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public City getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_autocomplete_dropdown, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.tv_city)).setText(getItem(position).getCityName());
        String stateCity = getItem(position).getCityState() + "," + getItem(position).getCityCountry();
        ((TextView) convertView.findViewById(R.id.tv_state)).setText(stateCity);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    LogClass.displayLog(TAG, constraint.toString());
                    List<City> books = findCities(mContext, constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = books;
                    filterResults.count = books.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    resultList = (List<City>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

    /**
     * Returns a search result for the given book title.
     */
    private List<City> findCities(Context context, String cityTyped) {
        return GetCityPredictions.getCityPredictions(cityTyped);
    }
}