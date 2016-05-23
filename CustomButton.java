package com.techmorphosis.qube.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

// Created by kamlesh on 23/2/16, 10:52 AM
public class CustomButton extends Button {
    private final String FONT_USED = "futura.ttf";

    public CustomButton(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_USED);
        this.setTypeface(tf);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_USED);
        this.setTypeface(tf);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), FONT_USED);
        this.setTypeface(tf);
    }
}
