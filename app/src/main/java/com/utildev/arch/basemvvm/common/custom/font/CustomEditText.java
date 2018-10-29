package com.utildev.arch.basemvvm.common.custom.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class CustomEditText extends AppCompatEditText {
    private static final String ANDROID_SCHEMAL = "http://schemas.android.com/apk/res/android";

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        setIncludeFontPadding(false);
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMAL, "textStyle", Typeface.NORMAL);
        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        switch (textStyle) {
            case Typeface.NORMAL:
                return FontCache.getTypeface(context, "font-Normal.ttf");
            case Typeface.ITALIC:
                return FontCache.getTypeface(context, "font-Italic.ttf");
            case Typeface.BOLD:
                return FontCache.getTypeface(context, "font-Bold.ttf");
            default:
                return FontCache.getTypeface(context, "font-Normal.ttf");
        }
    }
}
