package ixigo.invincible.takemethere.harsh.customview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import ixigo.invincible.takemethere.R;


//Custom EditText with Dynamic Font
@SuppressLint("AppCompatCustomView")
public class EditTextCustom extends EditText {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditTextCustom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public EditTextCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public EditTextCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EditTextCustom(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Custom);
            String fontName = a.getString(R.styleable.Custom_font);
            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                    setTypeface(myTypeface);
                } else {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + getContext().getString(R.string.font_roboto_regular));
                    setTypeface(myTypeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.recycle();
        }
    }
}