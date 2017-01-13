package com.antonbelka.test;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.Button;

public class CustomView extends Button {
    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(getContext(), android.R.drawable.btn_star_big_off),
                null, null, null);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(getContext(),
                        enabled ? android.R.drawable.btn_star_big_on
                                : android.R.drawable.btn_star_big_off),
                null, null, null);
    }

}
