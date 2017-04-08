package ixigo.invincible.takemethere.haimal.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import ixigo.invincible.takemethere.haimal.modals.City;

/**
 * Created by haimal on 08/04/17.
 */

public class AutoCompleteAdapter extends ArrayAdapter<City> implements Filterable {

    private Context context;
    private LayoutInflater mInflater;

    public AutoCompleteAdapter(Context context) {
        super(context, -1);
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

}
