package ixigo.invincible.takemethere.haimal.Utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by haimal on 08/04/17.
 */

public class SourceTextView extends android.support.v7.widget.AppCompatTextView {

    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + "sourcesanspro_semibold.otf");

    public SourceTextView(Context context) {
        super(context);
        setTypeface(myTypeface);
    }

    public SourceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(myTypeface);
    }

    public SourceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(myTypeface);
    }

}
