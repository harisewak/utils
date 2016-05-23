package com.techmorphosis.qube.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

// Created by kamlesh on 22/2/16, 7:45 PM

public class CustomTextView extends TextView {
    private final String FONT_USED = "futura.ttf";

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_USED);
        setTypeface(tf);
    }
}
