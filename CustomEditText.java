package com.techmorphosis.qube.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

// Created by kamlesh on 22/2/16, 7:58 PM
public class CustomEditText extends EditText {
    private final String FONT_USED = "futura.ttf";

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_USED);
        setTypeface(tf);
    }
}
