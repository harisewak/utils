package com.techmorphosis.qube.utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.techmorphosis.qube.R;


/**
 * Created by Kamlesh on 023 23/11/15.
 */
public class AnimUtils {
    public static void forwardAnimation(Context context, View inView, View outView) {
        inView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_in_right));
        outView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_out_left));
    }

    public static void backwardAnimation(Context context, View inView, View outView) {
        inView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_in_left));
        outView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_out_right));
    }

    public static void animateAfter(final Context context, final View view, final int animResId, int delayInMillis) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(AnimationUtils.loadAnimation(context, animResId));
            }
        }, delayInMillis);
    }

    public static void forwardSwipeAnimation(Context context, View outView) {
        outView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_swipe_left));
    }

    public static void backwardSwipeAnimation(Context context, View inView) {
        inView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_swipe_right));
    }

    public static void slideUpAnimation(Context context, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_up));
    }

    public static void slideDownAnimation(Context context, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.a_slide_down));
    }
}
