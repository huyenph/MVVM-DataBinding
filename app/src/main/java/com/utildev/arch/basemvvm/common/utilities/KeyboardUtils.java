package com.utildev.arch.basemvvm.common.utilities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyboardUtils {
    public static void setupUI(View view, Activity activity) {
        setupUI(view, activity, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    private static void setupUI(View view, Activity activity, boolean clearFocus) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener((v, event) -> {
                if (view.getTag() != null) {
                    return false;
                }
                if (clearFocus) {
                    view.requestFocus();
                }
                hideSoftKeyboard(activity);
                return false;
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView, activity, clearFocus);
            }
        }
    }

    private static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View view = activity.getCurrentFocus();
            if (view != null && manager != null) {
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    clearFocusEditText(new EditText[]{editText});
                }
            }
        } catch (Exception ignored) {

        }
    }

    private static void clearFocusEditText(EditText[] editTexts) {
        for (EditText editText : editTexts) {
            editText.clearFocus();
        }
    }
}
